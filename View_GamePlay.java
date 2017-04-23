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
import maincharacter.*;
import enemy.*;
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

    public static void buildViewGamePlay() throws FileNotFoundException{
        dummy.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    enemyHurt.setVisible(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        frameMain.setSize(1366,768);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelGamePlay.setLayout(null);
        panelGamePlay.setBackground(Color.gray);

        try {
            BufferedImage img = ImageIO.read(new File("/home/adit/IdeaProjects/idlePlayer.png"));
            ImageIcon icon = new ImageIcon(img);
            idlePlayer = new JLabel(icon);
            idlePlayer.setBounds(600,500,150,150);
            panelGamePlay.add(idlePlayer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            BufferedImage img = ImageIO.read(new File("/home/adit/IdeaProjects/attackPlayer.png"));
            ImageIcon icon = new ImageIcon(img);
            attackPlayer = new JLabel(icon);
            attackPlayer.setBounds(550,440,250,250);
            panelGamePlay.add(attackPlayer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            BufferedImage img = ImageIO.read(new File("/home/adit/IdeaProjects/idleEnemy.png"));
            ImageIcon icon = new ImageIcon(img);
            enemyNotHurt = new JLabel(icon);
            enemyNotHurt.setBounds(560,30,250,250);
            panelGamePlay.add(enemyNotHurt);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            BufferedImage img = ImageIO.read(new File("/home/adit/IdeaProjects/hurtEnemy.png"));
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
        new View_GamePlay();
        World w = new World();
        GameplayController gc = new GameplayController(w);
        gc.runWorld();

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
