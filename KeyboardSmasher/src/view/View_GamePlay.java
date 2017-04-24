package view;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import maincharacter.*;
import enemy.*;
import maincharacter.hero.Hero;
import maincharacter.player.Player;
import stage.*;
import world.*;
import controller.*;

/**
 * Created by adit on 22/04/17.
 */


public class View_GamePlay extends JFrame {

  private static JPanel panelGamePlay = new JPanel();
  private static JPanel panelIdlePlayer = new JPanel();
  private static JButton shop = new JButton("Shop");
  private static JFrame frameMain = new JFrame("GamePlay");
  private static JLabel idlePlayer;
  private static JLabel attackPlayer;
  private static JLabel enemyNotHurt;
  private static JLabel enemyHurt;
  private static JTextField dummy = new JTextField();
  private static JProgressBar progressbar = new JProgressBar();

  private static Player p;
  private static PlayerController pc;
  private static Hero h;
  private static HeroController hc;
  private static ArrayList<Hero> hero;
  private static Stage stages;
  private static int curStage;
  private static EnemyController ec;
  private static World world;
  private static GameplayController gc;

  public static void viewBar() {
    panelGamePlay.add(progressbar);
    progressbar.setBounds(500, 10, 400, 30);
    progressbar.setStringPainted(true);
    progressbar.setForeground(Color.GREEN);
    progressbar.setValue(100);

    // progressbar.setValue(progressbar.getMinimum());
  }

  public static void initiateController() throws FileNotFoundException {
    curStage = 0;
    p = new Player("Player");
    pc = new PlayerController(p);
    h = new Hero("Hero", 4,0.5);
    hc = new HeroController(h);
    hero = new ArrayList<>();
    stages = new Stage();
    ec = new EnemyController(stages.getCurEnemy());
    world = new World(p, hero, stages);
    world.addHero(h);
    gc = new GameplayController(world);
  }

  public static void buildViewGamePlay() throws FileNotFoundException {
    initiateController();

    SwingWorker keyPress = new SwingWorker() {
      @Override
      protected Object doInBackground() throws Exception {
        dummy.addKeyListener(new KeyListener() {
          @Override
          public void keyTyped(KeyEvent e) {

          }

          @Override
          public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
              enemyNotHurt.setVisible(false);
              enemyHurt.setVisible(true);
              attackPlayer.setVisible(true);
              idlePlayer.setVisible(false);
            }
          }

          @Override
          public void keyReleased(KeyEvent e) {
            if (ec.getModelHealth() > 0) {
              pc.attackEnemy(ec);
              System.out.println("Enemy : " + ec.getEnemyModel().getName());
              System.out.println("Enemy : " + ec.getEnemyModel().getCurHealth());
            }
            enemyNotHurt.setVisible(true);
            enemyHurt.setVisible(false);
            attackPlayer.setVisible(false);
            idlePlayer.setVisible(true);
          }
        });
        return null;
      }
    };
    keyPress.execute();

    frameMain.setSize(1366, 768);
    frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panelGamePlay.setLayout(null);
    panelGamePlay.setBackground(Color.gray);

    try {
      BufferedImage img = ImageIO.read(new File("/home/axelinate/IdeaProjects/B&B/src/res/idlePlayer.png"));
      ImageIcon icon = new ImageIcon(img);
      idlePlayer = new JLabel(icon);
      idlePlayer.setBounds(550,300,400,400);
      panelGamePlay.add(idlePlayer);
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    try {
      BufferedImage img = ImageIO.read(new File("/home/axelinate/IdeaProjects/B&B/src/res/attackPlayer.png"));
      ImageIcon icon = new ImageIcon(img);
      attackPlayer = new JLabel(icon);
      attackPlayer.setBounds(450,300,400,400);
      panelGamePlay.add(attackPlayer);
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    try {
      BufferedImage img = ImageIO.read(new File("/home/axelinate/IdeaProjects/B&B/src/res/idleEnemy.png"));
      ImageIcon icon = new ImageIcon(img);
      enemyNotHurt = new JLabel(icon);
      enemyNotHurt.setBounds(560,30,250,250);
      panelGamePlay.add(enemyNotHurt);
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    try {
      BufferedImage img = ImageIO.read(new File("/home/axelinate/IdeaProjects/B&B/src/res/hurtEnemy.png"));
      ImageIcon icon = new ImageIcon(img);
      enemyHurt = new JLabel(icon);
      enemyHurt.setBounds(560,30,250,250);
      panelGamePlay.add(enemyHurt);
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    viewBar();
    attackPlayer.setVisible(false);
    enemyHurt.setVisible(false);
    panelGamePlay.add(View_GamePlay.getShop());
    panelGamePlay.add(dummy);
    shop.setBounds(1166, 665, 200, 53);
    frameMain.getContentPane().add(View_GamePlay.getPanelGamePlay());
    frameMain.setVisible(true);

    SwingWorker swingWork = new SwingWorker() {
      @Override
      protected Object doInBackground() throws Exception {
        while (!isCancelled()) {
          Timer execution = new Timer();
          execution.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
              if (((int) (((float) ec.getEnemyModel().getCurHealth() / (float) ec.getEnemyModel().getMaxHealth()) * 100)) >= 0) {
                progressbar.setValue((int) (((float) ec.getEnemyModel().getCurHealth() / (float) ec.getEnemyModel().getMaxHealth()) * 100));
              } else {
                progressbar.setValue(0);
              }
            }
          }, 60, 1);
          int cur = 0;
          gc.setWorldMonster();
          ec.setEnemyModel(gc.getWorldCurEnemy());
          for (int i = 0; i < gc.getWorldHeroCount(); i++) {
            gc.getWorldHero(i).start();
          }
          gc.getWorldPlayer().start();
          while (cur < gc.getWorldStage().getGameStage().size()) {
            synchronized (gc.getWorldHero(0).getHeroThread()) {
              try {
                gc.getWorldHero(0).getHeroThread().wait();
                gc.getWorldPlayer().plusMoney(ec.getModelMoneyLoot());
                System.out.println("Money : " + gc.getWorldPlayer().getMoney());
                cur++;
                gc.getWorldStage().setCurStage(cur);
                gc.getWorldHero(0).getHeroThread().sleep(1);
              } catch (InterruptedException e) {
                System.out.println("World Interrupted");
              }
            }
            gc.setWorldThreadToNull();
            gc.setWorldMonster();
            ec.setEnemyModel(gc.getWorldCurEnemy());
            gc.getWorldHero(0).start();
          }
          cancel(true);
        }
        return null;
      }
    };
    swingWork.execute();
  }

  public static void setFrameMain(JFrame frameMain) {
    View_GamePlay.frameMain = frameMain;
  }

  public static JFrame getFrameMain() {
    return frameMain;
  }

  public static void setShop(JButton shop) {
    View_GamePlay.shop = shop;
  }

  public static JButton getShop() {
    return shop;
  }

  public static void setPanelGamePlay(JPanel panelGamePlay) {
    View_GamePlay.panelGamePlay = panelGamePlay;
  }

  public static JPanel getPanelGamePlay() {
    return panelGamePlay;
  }

  public View_GamePlay() throws FileNotFoundException {
    shop.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frameMain.setVisible(false);
        try {
          View_Shop.buildViewShop();
        } catch (FileNotFoundException e1) {
          e1.printStackTrace();
        }
      }
    });
  }
}