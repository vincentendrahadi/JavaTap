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

    public static void initiateController() throws FileNotFoundException{
        curStage = 0;
        p = new Player("Player");
        pc = new PlayerController(p);
        h = new Hero("Hero", 4);
        hc = new HeroController(h);
        hero = new ArrayList<>();
        stages = new Stage();
        ec = new EnemyController(stages.getCurEnemy());
        world = new World(p, hero, stages);
        world.addHero(h);
        gc = new GameplayController(world);
    }

    public static void buildViewGamePlay() throws FileNotFoundException{
        initiateController();


        frameMain.setSize(1366,768);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelGamePlay.setLayout(null);
        panelGamePlay.setBackground(Color.gray);

        try {
            BufferedImage img = ImageIO.read(new File("/home/axelinate/IdeaProjects/B&B/src/res/idlePlayer.png"));
            ImageIcon icon = new ImageIcon(img);
            idlePlayer = new JLabel(icon);
            idlePlayer.setBounds(600,500,150,150);
            panelGamePlay.add(idlePlayer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            BufferedImage img = ImageIO.read(new File("/home/axelinate/IdeaProjects/B&B/src/res/attackPlayer.png"));
            ImageIcon icon = new ImageIcon(img);
            attackPlayer = new JLabel(icon);
            attackPlayer.setBounds(550,440,250,250);
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

        attackPlayer.setVisible(false);
        enemyHurt.setVisible(false);
        panelGamePlay.add(View_GamePlay.getShop());
        panelGamePlay.add(dummy);
        shop.setBounds(1166,665,200,53);
        frameMain.getContentPane().add(View_GamePlay.getPanelGamePlay());
        frameMain.setVisible(true);

        SwingWorker swingWork = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                while (!isCancelled()) {
                    System.out.println("attack");

                    int cur = 0;
                    gc.setWorldMonster();
                    pc.setModelEnemy(gc.-*****);
                    for (int i = 0; i < gc.getWorldHeroCount(); i++) {
                        gc.getWorldHero(i).start();
                    }
                    gc.getWorldPlayer().start();
                    dummy.addKeyListener(new KeyListener() {
                        @Override
                        public void keyTyped(KeyEvent e) {

                        }

                        @Override
                        public void keyPressed(KeyEvent e) {
                            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                enemyNotHurt.setVisible(false);
                                enemyHurt.setVisible(true);
                                pc.attackEnemy(ec);
                                System.out.println("Enemy : " + ec.getEnemyModel().getName());
                                System.out.println("Enemy : " + ec.getEnemyModel().getCurHealth());
                            }
                        }

                        @Override
                        public void keyReleased(KeyEvent e) {

                        }
                    });
                    synchronized (gc.getWorldHero(0).getHeroThread()) {
                        try {
                            gc.getWorldHero(0).getHeroThread().wait();
                            gc.getWorldPlayer().plusMoney(ec.getModelMoneyLoot());
                            System.out.println("Money : " + gc.getWorldPlayer().getMoney());
                            cur++;
                            gc.getWorldStage().setCurStage(cur);
                            gc.getWorldHero(0).getHeroThread().sleep(10);
                        } catch (InterruptedException e) {
                            System.out.println("World Interrupted");
                        }
                    }
                    gc.setWorldThreadToNull();
                }
                cancel(true);
                return null;
            }
        };
        swingWork.execute();
        System.out.println("aa");


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