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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Currency;
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
    private static JLabel joyHero;
    private static JLabel sadnessHero;
    private static JLabel angerHero;
    private static JLabel disgustHero;
    private static JLabel fearHero;
    private static JLabel money = new JLabel("Money  : ");
    private static JLabel currMoney = new JLabel("0");
    private static JLabel attack = new JLabel("Attack  : ");
    private static JLabel currAttack = new JLabel();
    private static JLabel executionTime = new JLabel();
    private static JTextField dummy = new JTextField();
    private static JProgressBar progressbar = new JProgressBar();
    private static JProgressBar countdown = new JProgressBar();

    public static Player p;
    public static PlayerController pc;
    public static Hero h;
    public static HeroController hc;
    public static ArrayList<Hero> hero;
    public static Stage stages;
    public static int curStage;
    public static EnemyController ec;
    public static World world;
    public static GameplayController gc;

    private static boolean enterTimeBoss = false;

    public static void setAngerHero() {
        angerHero.setVisible(true);
    }

    public static void setJoyHero() {
        joyHero.setVisible(true);
    }

    public static void setSadnessHero() {
        sadnessHero.setVisible(true);
    }

    public static void setDisgustHero() {
        disgustHero.setVisible(true);
    }

    public static void setFearHero() {
        fearHero.setVisible(true);
    }

    public static void viewBar() {
        panelGamePlay.add(progressbar);
        progressbar.setBounds(500, 10, 400, 30);
        progressbar.setStringPainted(true);
        progressbar.setForeground(Color.GREEN);
        progressbar.setValue(100);

        // progressbar.setValue(progressbar.getMinimum());
    }

    public static void viewTimeBoss() {
        if (!enterTimeBoss) {
            enterTimeBoss = true;
            panelGamePlay.add(countdown);
            countdown.setBounds(0,0,400,30);
            countdown.setStringPainted(true);
            countdown.setForeground(Color.LIGHT_GRAY);
            countdown.setValue(100);
            countdown.setStringPainted(true);

            int timerDelay = 805;
            new javax.swing.Timer(timerDelay , new ActionListener() {
                private int index = 0;
                private int maxIndex = 100;
                public void actionPerformed(ActionEvent e) {
                    if (maxIndex >= index) {
                        countdown.setValue(maxIndex);
                        maxIndex = maxIndex - 10;
                    } else {
                        enterTimeBoss = false;
                        countdown.setValue(index);
                        ((javax.swing.Timer)e.getSource()).stop(); // stop the timer
                    }
                }
            }).start();

            countdown.setValue(countdown.getMinimum());
        }

    }

    public static void initiateController(String filename) throws FileNotFoundException {
        curStage = 0;
        p = new Player("Player");
        pc = new PlayerController(p);
        hero = new ArrayList<>();
        stages = new Stage(filename);
        ec = new EnemyController(stages.getCurEnemy());
        world = new World(p, hero, stages);
        gc = new GameplayController(world);
        gc.addWorldHero();
    }

    public static void buildViewGamePlay() throws FileNotFoundException {
        try {
            if (ec.getModelHealth() > 0) {

            }
        } catch (NullPointerException e) {
            initiateController("stage.txt");

        }

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
                    System.out.println("Enemy : " + ec.getEnemyModel().getName());
                    System.out.println("Enemy : " + ec.getEnemyModel().getCurHealth());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (ec.getModelHealth() > 0) {
                        pc.attackEnemy(ec);
                    }
                    enemyNotHurt.setVisible(true);
                    enemyHurt.setVisible(false);
                    attackPlayer.setVisible(false);
                    idlePlayer.setVisible(true);
                }
            }
        });

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
            BufferedImage img = ImageIO.read(new File("/home/axelinate/IdeaProjects/B&B/src/res/attackingPlayer.png"));
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
            enemyNotHurt.setBounds(580,50,250,250);
            panelGamePlay.add(enemyNotHurt);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            BufferedImage img = ImageIO.read(new File("/home/axelinate/IdeaProjects/B&B/src/res/hurtEnemy.png"));
            ImageIcon icon = new ImageIcon(img);
            enemyHurt = new JLabel(icon);
            enemyHurt.setBounds(580,50,250,250);
            panelGamePlay.add(enemyHurt);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        ////////////////////////////////////////////////////////
        try {
            BufferedImage img = ImageIO.read(new File("/home/axelinate/IdeaProjects/B&B/src/res/hero_joy.png"));
            ImageIcon icon = new ImageIcon(img);
            joyHero = new JLabel(icon);
            joyHero.setBounds(1000,450,150,150);
            panelGamePlay.add(joyHero);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            BufferedImage img = ImageIO.read(new File("/home/axelinate/IdeaProjects/B&B/src/res/hero_joy.png"));
            ImageIcon icon = new ImageIcon(img);
            sadnessHero = new JLabel(icon);
            sadnessHero.setBounds(1100,150,150,150);
            panelGamePlay.add(sadnessHero);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            BufferedImage img = ImageIO.read(new File("/home/axelinate/IdeaProjects/B&B/src/res/hero_joy.png"));
            ImageIcon icon = new ImageIcon(img);
            angerHero = new JLabel(icon);
            angerHero.setBounds(70,120,150,150);
            panelGamePlay.add(angerHero);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            BufferedImage img = ImageIO.read(new File("/home/axelinate/IdeaProjects/B&B/src/res/hero_joy.png"));
            ImageIcon icon = new ImageIcon(img);
            disgustHero = new JLabel(icon);
            disgustHero.setBounds(200,320,150,150);
            panelGamePlay.add(disgustHero);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            BufferedImage img = ImageIO.read(new File("/home/axelinate/IdeaProjects/B&B/src/res/hero_joy.png"));
            ImageIcon icon = new ImageIcon(img);
            fearHero = new JLabel(icon);
            fearHero.setBounds(320,520,150,150);
            panelGamePlay.add(fearHero);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        /////////////////////////////////////////////////////////////////////////////

        viewBar();

        attackPlayer.setVisible(false);
        enemyHurt.setVisible(false);
        joyHero.setVisible(false);
        sadnessHero.setVisible(false);
        angerHero.setVisible(false);
        disgustHero.setVisible(false);
        fearHero.setVisible(false);

        money.setForeground(Color.YELLOW);
        money.setBounds(1106,10,300,30);
        money.setFont(new Font( "", Font.BOLD, 20));

        currMoney.setForeground(Color.YELLOW);
        currMoney.setBounds(1216, 11, 300, 30);
        currMoney.setFont(new Font("", Font.BOLD, 20));

        attack.setForeground(Color.RED);
        attack.setBounds(1106, 51, 300, 30);
        attack.setFont(new Font("", Font.BOLD, 20));

        currAttack.setForeground(Color.RED);
        currAttack.setBounds(1216, 51, 300, 30);
        currAttack.setFont(new Font("", Font.BOLD, 20));

        panelGamePlay.add(countdown);
        panelGamePlay.add(currMoney);
        panelGamePlay.add(money);
        panelGamePlay.add(attack);
        panelGamePlay.add(currAttack);
        panelGamePlay.add(shop);
        panelGamePlay.add(dummy);
        shop.setBounds(1166, 665, 200, 53);
        frameMain.getContentPane().add(View_GamePlay.getPanelGamePlay());
        frameMain.setVisible(true);
        Double temp;
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
                            currMoney.setText(String.valueOf(pc.getModelMoney()));
                            currAttack.setText(String.valueOf(pc.getModelAttPower()) + " (" + String.valueOf(new DecimalFormat("##.##").format(((float) pc.getModelAttPower() / (float) ec.getEnemyModel().getMaxHealth()) * 100) + "%" + ")"));

                            if (ec.getEnemyModel().isBoss()) {
                                viewTimeBoss();
                            }
                        }
                    }, 60, 1);

                    int cur = stages.getCurStage();
                    gc.setWorldMonster();

                    while (cur < gc.getWorldStage().getGameStage().size()) {
                        for (int i = 0; i < gc.getWorldHeroCount(); i++) {
                            System.out.println(gc.getWorldHero(i).getThreadName());
                            gc.getWorldHero(i).start();
                        }
                        System.out.println(gc.getWorldHeroCount());
                        synchronized (gc.getWorldHero(0).getHeroThread()) {
                            try {
                                gc.getWorldHero(0).getHeroThread().wait();
                                gc.getWorldPlayer().plusMoney(ec.getModelMoneyLoot());
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
                    }
                    cancel(true);
                }
                return null;
            }
        };
        swingWork.execute();
        new View_GamePlay();
    }

    public static void focusKey() {
        dummy.requestFocusInWindow();
    }

    public static void runThread() {
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
                            currMoney.setText(String.valueOf(pc.getModelMoney()));
                            currAttack.setText(String.valueOf(pc.getModelAttPower()) + " (" + String.valueOf(new DecimalFormat("##.##").format(((float) pc.getModelAttPower() / (float) ec.getEnemyModel().getMaxHealth()) * 100) + "%" + ")"));

                            if (ec.getEnemyModel().isBoss()) {
                                viewTimeBoss();
                            }
                        }
                    }, 60, 1);

                    int cur = stages.getCurStage();
                    gc.setWorldMonster();

                    while (cur < gc.getWorldStage().getGameStage().size()) {
                        for (int i = 0; i < gc.getWorldHeroCount(); i++) {
                            System.out.println(gc.getWorldHero(i).getThreadName());
                            gc.getWorldHero(i).start();
                        }
                        System.out.println(gc.getWorldHeroCount());
                        synchronized (gc.getWorldHero(0).getHeroThread()) {
                            try {
                                gc.getWorldHero(0).getHeroThread().wait();
                                gc.getWorldPlayer().plusMoney(ec.getModelMoneyLoot());
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
                try {
                    View_Shop.buildViewShop();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }

        });
    }

}