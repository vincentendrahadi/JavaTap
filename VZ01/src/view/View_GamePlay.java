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
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import stage.*;
import world.*;
import controller.*;

/**
 * Created by adit on 22/04/17.
 */


public class View_GamePlay extends JFrame {

    private static JPanel panelGamePlay = new JPanel();
    private static JPanel panelIdlePlayer = new JPanel();
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
    public static JLabel level = new JLabel("Level  : ");
    public static JLabel currLevel = new JLabel();

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
    private static boolean haveBuiltShop = false;

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
            Timer executionTime = new Timer();
            executionTime.scheduleAtFixedRate(new TimerTask() {
                private int index = 0;
                private int maxIndex = 100;
                @Override
                public void run() {
                    if (maxIndex >= index) {
                        countdown.setValue(maxIndex);
                        maxIndex = maxIndex - 10;
                    } else {
                        enterTimeBoss = false;
                        countdown.setValue(index);
                        executionTime.cancel();
                    }
                }
            }, 10, 900);

            /*
            int timerDelay = 774;
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
            */
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
            if(ec.getModelHealth() > 0) {

            }
        } catch (NullPointerException e) {
            initiateController("stage.txt");

        }
/*
        SwingWorker keyPress = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {

            }
        };
        keyPress.execute();
*/
        frameMain.setSize(1366, 768);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelGamePlay.setLayout(null);
        panelGamePlay.setBackground(Color.gray);

        try {
            BufferedImage img = ImageIO.read(new File("/home/adit/IdeaProjects/KeyboardSmasher/src/res/idlePlayer.png"));
            ImageIcon icon = new ImageIcon(img);
            idlePlayer = new JLabel(icon);
            idlePlayer.setBounds(550,300,400,400);
            panelGamePlay.add(idlePlayer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            BufferedImage img = ImageIO.read(new File("/home/adit/IdeaProjects/VZ01/src/res/attackingPlayer.png"));
            ImageIcon icon = new ImageIcon(img);
            attackPlayer = new JLabel(icon);
            attackPlayer.setBounds(450,300,400,400);
            panelGamePlay.add(attackPlayer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            BufferedImage img = ImageIO.read(new File("/home/adit/IdeaProjects/VZ01/src/res/idleEnemy.png"));
            ImageIcon icon = new ImageIcon(img);
            enemyNotHurt = new JLabel(icon);
            enemyNotHurt.setBounds(580,50,250,250);
            panelGamePlay.add(enemyNotHurt);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            BufferedImage img = ImageIO.read(new File("/home/adit/IdeaProjects/VZ01/src/res/hurtEnemy.png"));
            ImageIcon icon = new ImageIcon(img);
            enemyHurt = new JLabel(icon);
            enemyHurt.setBounds(580,50,250,250);
            panelGamePlay.add(enemyHurt);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        ////////////////////////////////////////////////////////
        try {
            BufferedImage img = ImageIO.read(new File("/home/adit/IdeaProjects/VZ01/src/res/hero_joy.png"));
            ImageIcon icon = new ImageIcon(img);
            joyHero = new JLabel(icon);
            joyHero.setBounds(1000,450,150,150);
            panelGamePlay.add(joyHero);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            BufferedImage img = ImageIO.read(new File("/home/adit/IdeaProjects/VZ01/src/res/hero_joy.png"));
            ImageIcon icon = new ImageIcon(img);
            sadnessHero = new JLabel(icon);
            sadnessHero.setBounds(1100,150,150,150);
            panelGamePlay.add(sadnessHero);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            BufferedImage img = ImageIO.read(new File("/home/adit/IdeaProjects/VZ01/src/res/hero_joy.png"));
            ImageIcon icon = new ImageIcon(img);
            angerHero = new JLabel(icon);
            angerHero.setBounds(70,120,150,150);
            panelGamePlay.add(angerHero);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            BufferedImage img = ImageIO.read(new File("/home/adit/IdeaProjects/VZ01/src/res/hero_joy.png"));
            ImageIcon icon = new ImageIcon(img);
            disgustHero = new JLabel(icon);
            disgustHero.setBounds(200,320,150,150);
            panelGamePlay.add(disgustHero);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            BufferedImage img = ImageIO.read(new File("/home/adit/IdeaProjects/VZ01/src/res/hero_joy.png"));
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

        level.setForeground(Color.BLACK);
        level.setBounds(1106, 51, 300, 30);
        level.setFont(new Font("", Font.BOLD, 20));

        currLevel.setForeground(Color.BLACK);
        currLevel.setBounds(1216, 51, 300, 30);
        currLevel.setFont(new Font("", Font.BOLD, 20));
        currLevel.setText("0");

        attack.setForeground(Color.RED);
        attack.setBounds(1106, 91, 300, 30);
        attack.setFont(new Font("", Font.BOLD, 20));

        currAttack.setForeground(Color.RED);
        currAttack.setBounds(1216, 91, 300, 30);
        currAttack.setFont(new Font("", Font.BOLD, 20));

        panelGamePlay.add(countdown);
        panelGamePlay.add(currMoney);
        panelGamePlay.add(money);
        panelGamePlay.add(level);
        panelGamePlay.add(currLevel);
        panelGamePlay.add(attack);
        panelGamePlay.add(currAttack);
        panelGamePlay.add(dummy);
        frameMain.getContentPane().add(View_GamePlay.getPanelGamePlay());
        frameMain.setVisible(true);

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
                    pc.plusModelMoney(pc.getModelAttPower());
                }
            }

            @Override

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
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
            }
        });
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
                            currLevel.setText(String.valueOf(View_GamePlay.pc.getModelLevel()));

                            if (ec.getEnemyModel().isBoss()) {
                                countdown.setVisible(true);
                                viewTimeBoss();
                            } else {
                                countdown.setVisible(false);
                            }
                        }
                    }, 10, 1);

                    int cur = stages.getCurStage();
                    gc.setWorldMonster();
                    for (int i = 0; i < gc.getWorldHeroCount(); i++) {
                        System.out.println(gc.getWorldHero(0).getThreadName());
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
                                countdown.setVisible(true);
                                viewTimeBoss();
                            } else {
                                countdown.setVisible(false);
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

    public static void setPanelGamePlay(JPanel panelGamePlay) {
        View_GamePlay.panelGamePlay = panelGamePlay;
    }

    public static JPanel getPanelGamePlay() {
        return panelGamePlay;
    }
}