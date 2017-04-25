package view;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

//import MainCharacter.Player.Player;


/**
 * Created by adit on 22/04/17.
 */
public class View_Shop extends JFrame {
    private static JFrame frameShop = new JFrame();

    private static JPanel panelShop = new JPanel();
    private static JPanel leftPanel = new JPanel();
    private static JPanel rightPanel = new JPanel();
    private static JPanel firstCenterPanel = new JPanel();
    private static JPanel secondCenterPanel = new JPanel();
    private static JPanel lowerPanel = new JPanel();
    private static JPanel upperPanel = new JPanel();
    private static JPanel dummyPanel = new JPanel();

    private static JButton backToGameButton = new JButton("     Back to game     ");
    private static JButton playerButton = new JButton("Level up Player");
    private static JButton joyButton = new JButton("Unlock Joy");
    private static JButton sadnessButton = new JButton("Unlock Sadness");
    private static JButton angerButton = new JButton("Unlock Anger");
    private static JButton disgustButton = new JButton("Unlock Disgust");
    private static JButton fearButton = new JButton("Unlock Fear");

    private static JLabel playerPrice = new JLabel("5000");
    private static JLabel joyPrice = new JLabel("6000");
    private static JLabel sadnessPrice = new JLabel("7000");
    private static JLabel angerPrice = new JLabel("8000");
    private static JLabel disgustPrice = new JLabel("9000");
    private static JLabel fearPrice = new JLabel("10000");
    private static JLabel moneyCapacityText = new JLabel("Money  : ");
    private static JLabel moneyCapacity = new JLabel();

    private static boolean joy = true;
    private static boolean joyUnlocked = false;

    private static boolean sadness = false;
    private static boolean sadnessUnlocked = false;

    private static boolean anger = false;
    private static boolean angerUnlocked = false;

    private static boolean disgust = false;
    private static boolean disgustUnlocked = false;

    private static boolean fear = false;
    private static boolean fearUnlocked = false;

    private static boolean build = false;

    /* BUILDER PROCEDURE */
    public static void buildViewShop() throws FileNotFoundException{
        //Set frame
        frameShop.setSize(1366, 768);
        frameShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sadnessButton.setEnabled(false);
        angerButton.setEnabled(false);
        disgustButton.setEnabled(false);
        fearButton.setEnabled(false);

        //Set Lower panel
        lowerPanel.setLayout(null);
        lowerPanel.setBounds(0,680,1366,60);
        lowerPanel.setBackground(Color.BLACK);
        lowerPanel.setVisible(true);

        backToGameButton.setFocusPainted(false);
        backToGameButton.setBounds(73,0, 1200,25);
        backToGameButton.setBackground(Color.DARK_GRAY);
        backToGameButton.setForeground(new Color(44,214,205));

        lowerPanel.add(backToGameButton);

        //Set Upper Panel
        upperPanel.setBounds(0,0,1366,60);
        upperPanel.setBackground(Color.BLACK);
        upperPanel.setVisible(true);

        JLabel shopMessage = new JLabel("SHOP");
        shopMessage.setFont(new Font("", Font.PLAIN,40));
        shopMessage.setForeground(Color.WHITE);
        upperPanel.add(shopMessage);

        //Set Left Panel
        leftPanel.setLayout(null);
        leftPanel.setBounds(23,60,330,648);
        leftPanel.setBackground(Color.BLACK);
        leftPanel.setVisible(true);

        moneyCapacityText.setForeground(Color.YELLOW);
        moneyCapacityText.setBounds(0,0,300,30);
        moneyCapacityText.setFont(new Font( "", Font.BOLD, 20));

        moneyCapacity.setForeground(Color.YELLOW);
        moneyCapacity.setBounds(0, 0, 300, 30);
        moneyCapacity.setFont(new Font("", Font.BOLD, 20));


        playerButton.setFocusPainted(false);
        playerButton.setLayout(null);
        playerButton.setBounds(75,50, 200,40);
        playerButton.setBackground(Color.DARK_GRAY);
        playerButton.setForeground(new Color(44,214,205));

        joyButton.setFocusPainted(false);
        joyButton.setLayout(null);
        joyButton.setBounds(75,250, 200,40);
        joyButton.setBackground(Color.DARK_GRAY);
        joyButton.setForeground(new Color(44,214,205));

        sadnessButton.setFocusPainted(false);
        sadnessButton.setLayout(null);
        sadnessButton.setBounds(75,450, 200,40);
        sadnessButton.setBackground(Color.DARK_GRAY);
        sadnessButton.setForeground(new Color(44,214,205));

        playerPrice.setLayout(null);
        playerPrice.setFont(new Font("", Font.PLAIN,30));
        playerPrice.setForeground(Color.WHITE);
        playerPrice.setBounds(130,120,200,50);

        joyPrice.setLayout(null);
        joyPrice.setFont(new Font("", Font.PLAIN,30));
        joyPrice.setForeground(Color.WHITE);
        joyPrice.setBounds(130,300,200,50);

        sadnessPrice.setLayout(null);
        sadnessPrice.setFont(new Font("", Font.PLAIN,30));
        sadnessPrice.setForeground(Color.WHITE);
        sadnessPrice.setBounds(130,500,200,50);

        leftPanel.add(playerButton);
        leftPanel.add(playerPrice);
        leftPanel.add(joyButton);
        leftPanel.add(joyPrice);
        leftPanel.add(sadnessButton);
        leftPanel.add(sadnessPrice);


        //Set First Center Panel
        firstCenterPanel.setBounds(353,60,330,648);
        firstCenterPanel.setBackground(Color.BLACK);
        firstCenterPanel.setVisible(true);

        try {
            BufferedImage img1 = ImageIO.read(new File("/home/adit/IdeaProjects/KeyboardSmasher/src/view/player_icon.jpg"));
            ImageIcon icon1 = new ImageIcon(img1);
            JLabel label1 = new JLabel(icon1);
            firstCenterPanel.add(label1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedImage img2 = ImageIO.read(new File("/home/adit/IdeaProjects/KeyboardSmasher/src/view/joy_icon.jpg"));
            ImageIcon icon2 = new ImageIcon(img2);
            JLabel label2 = new JLabel(icon2);
            firstCenterPanel.add(label2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedImage img3 = ImageIO.read(new File("/home/adit/IdeaProjects/KeyboardSmasher/src/view/sadness_icon.jpg"));
            ImageIcon icon3 = new ImageIcon(img3);
            JLabel label3 = new JLabel(icon3);
            firstCenterPanel.add(label3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Set Second Center Panel
        secondCenterPanel.setLayout(null);
        secondCenterPanel.setBounds(683,60,330,648);
        secondCenterPanel.setBackground(Color.BLACK);
        secondCenterPanel.setVisible(true);

        angerButton.setFocusPainted(false);
        angerButton.setLayout(null);
        angerButton.setBounds(75,50, 200,40);
        angerButton.setBackground(Color.DARK_GRAY);
        angerButton.setForeground(new Color(44,214,205));

        disgustButton.setFocusPainted(false);
        disgustButton.setLayout(null);
        disgustButton.setBounds(75,250, 200,40);
        disgustButton.setBackground(Color.DARK_GRAY);
        disgustButton.setForeground(new Color(44,214,205));

        fearButton.setFocusPainted(false);
        fearButton.setLayout(null);
        fearButton.setBounds(75,450, 200,40);
        fearButton.setBackground(Color.DARK_GRAY);
        fearButton.setForeground(new Color(44,214,205));

        angerPrice.setLayout(null);
        angerPrice.setFont(new Font("", Font.PLAIN,30));
        angerPrice.setForeground(Color.WHITE);
        angerPrice.setBounds(130,120,200,50);

        disgustPrice.setLayout(null);
        disgustPrice.setFont(new Font("", Font.PLAIN,30));
        disgustPrice.setForeground(Color.WHITE);
        disgustPrice.setBounds(130,300,200,50);

        fearPrice.setLayout(null);
        fearPrice.setFont(new Font("", Font.PLAIN,30));
        fearPrice.setForeground(Color.WHITE);
        fearPrice.setBounds(130,500,200,50);

        secondCenterPanel.add(angerButton);
        secondCenterPanel.add(angerPrice);
        secondCenterPanel.add(disgustButton);
        secondCenterPanel.add(disgustPrice);
        secondCenterPanel.add(fearButton);
        secondCenterPanel.add(fearPrice);

        //Set Right Panel
        rightPanel.setBounds(1013,60,330,648);
        rightPanel.setBackground(Color.BLACK);
        rightPanel.setVisible(true);

        try {
            BufferedImage img4 = ImageIO.read(new File("/home/adit/IdeaProjects/KeyboardSmasher/src/view/anger_icon.jpg"));
            ImageIcon icon4 = new ImageIcon(img4);
            JLabel label4 = new JLabel(icon4);
            rightPanel.add(label4);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedImage img5 = ImageIO.read(new File("/home/adit/IdeaProjects/KeyboardSmasher/src/view/disgust_icon.jpg"));
            ImageIcon icon5 = new ImageIcon(img5);
            JLabel label5 = new JLabel(icon5);
            rightPanel.add(label5);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedImage img6 = ImageIO.read(new File("/home/adit/IdeaProjects/KeyboardSmasher/src/view/fear_icon.jpg"));
            ImageIcon icon6 = new ImageIcon(img6);
            JLabel label6 = new JLabel(icon6);
            rightPanel.add(label6);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* SET DUMMY PANEL */
        dummyPanel.setBounds(1343,60,23,648);
        dummyPanel.setBackground(Color.BLACK);
        dummyPanel.setVisible(true);


        //Set frame with panel
        frameShop.getContentPane().add(lowerPanel);
        frameShop.getContentPane().add(upperPanel);
        frameShop.getContentPane().add(leftPanel);
        frameShop.getContentPane().add(firstCenterPanel);
        frameShop.getContentPane().add(secondCenterPanel);
        frameShop.getContentPane().add(rightPanel);
        frameShop.getContentPane().add(dummyPanel);
        frameShop.setVisible(true);
        new View_Shop();
    }



    /* GETTER & SETTER */
    public static void setFrameShop(JFrame frameShop) {

        View_Shop.frameShop = frameShop;
    }

    public static JFrame getFrameShop() {

        return frameShop;
    }

    public static void setPanelShop(JPanel panelShop) {

        View_Shop.panelShop = panelShop;
    }

    public static JPanel getPanelShop() {

        return panelShop;
    }

    public static void setBackToGameButton(JButton backToGameButton) {

        View_Shop.backToGameButton = backToGameButton;
    }

    public static JButton getBackToGameButton() {

        return backToGameButton;
    }

    public static void setAngerButton(JButton angerButton) {
        View_Shop.angerButton = angerButton;
    }

    public static JButton getAngerButton() {

        return angerButton;
    }

    public static void setDisgustButton(JButton disgustButton) {
        View_Shop.disgustButton = disgustButton;
    }

    public static JButton getDisgustButton() {

        return disgustButton;
    }

    public static void setFearButton(JButton fearButton) {
        View_Shop.fearButton = fearButton;
    }

    public static JButton getFearButton() {

        return fearButton;
    }

    public static void setJoyButton(JButton joyButton) {
        View_Shop.joyButton = joyButton;
    }

    public static JButton getJoyButton() {

        return joyButton;
    }

    public static void setSadnessButton(JButton sadnessButton) {

        View_Shop.sadnessButton = sadnessButton;
    }

    public static JButton getSadnessButton() {

        return sadnessButton;
    }

    public static void setPlayerButton(JButton playerButton) {

        View_Shop.playerButton = playerButton;
    }

    public static JButton getPlayerButton() {

        return playerButton;
    }

    public static void setBuild(boolean build) {

        View_Shop.build = build;
    }

    public static boolean isBuild() {
        return build;
    }

    public View_Shop() throws FileNotFoundException{
        backToGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View_GamePlay.focusKey();
                frameShop.setVisible(false);
            }
        });

        playerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (View_GamePlay.pc.getModelMoney() >= Integer.parseInt(playerPrice.getText())) {
                    View_GamePlay.pc.plusModelMoney((-1) * Integer.parseInt(playerPrice.getText()));
                    View_GamePlay.pc.modelLevelUp();
                    View_GamePlay.runThread();
                    //View_GamePlay.currLevel.setText(String.valueOf(View_GamePlay.pc.getModelLevel()));
                }
            }
        });

        joyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (View_GamePlay.pc.getModelMoney() >= Integer.parseInt(joyPrice.getText())) {
                    View_GamePlay.pc.plusModelMoney((-1) * Integer.parseInt(joyPrice.getText()));
                    if (!joyUnlocked) {
                        sadnessButton.setEnabled(true);
                        View_GamePlay.gc.setWorldThreadToNull();
                        joyButton.setText("Level up Joy");
                        joyUnlocked = true;
                        View_GamePlay.setJoyHero();
                        View_GamePlay.gc.addWorldHero();
                        View_GamePlay.runThread();
                    }
                }
            }

        });

        sadnessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (View_GamePlay.pc.getModelMoney() >= Integer.parseInt(sadnessPrice.getText())) {
                    View_GamePlay.pc.plusModelMoney((-1) * Integer.parseInt(sadnessPrice.getText()));
                    if (!sadnessUnlocked) {
                        angerButton.setEnabled(true);
                        View_GamePlay.gc.setWorldThreadToNull();
                        sadnessButton.setText("Level up Sadness");
                        sadnessUnlocked = true;
                        View_GamePlay.setSadnessHero();
                        View_GamePlay.gc.addWorldHero();
                        View_GamePlay.runThread();
                    }
                }

            }
        });

        angerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (View_GamePlay.pc.getModelMoney() >= Integer.parseInt(angerPrice.getText())) {
                    View_GamePlay.pc.plusModelMoney((-1) * Integer.parseInt(sadnessPrice.getText()));
                    if (!angerUnlocked) {
                        disgustButton.setEnabled(true);
                        View_GamePlay.gc.setWorldThreadToNull();
                        angerButton.setText("Level up Sadness");
                        angerUnlocked = true;
                        View_GamePlay.setAngerHero();
                        View_GamePlay.gc.addWorldHero();
                        View_GamePlay.runThread();
                    }
                }

            }
        });
        disgustButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (View_GamePlay.pc.getModelMoney() >= Integer.parseInt(disgustPrice.getText())) {
                    View_GamePlay.pc.plusModelMoney((-1) * Integer.parseInt(disgustPrice.getText()));
                    if (!disgustUnlocked) {
                        fearButton.setEnabled(true);
                        View_GamePlay.gc.setWorldThreadToNull();
                        disgustButton.setText("Level up Sadness");
                        disgustUnlocked = true;
                        View_GamePlay.setDisgustHero();
                        View_GamePlay.gc.addWorldHero();
                        View_GamePlay.runThread();
                    }
                }
            }

        });

        fearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (View_GamePlay.pc.getModelMoney() >= Integer.parseInt(fearPrice.getText())) {
                    View_GamePlay.pc.plusModelMoney((-1) * Integer.parseInt(fearPrice.getText()));
                    if (!fearUnlocked) {
                        View_GamePlay.gc.setWorldThreadToNull();
                        fearButton.setText("Level up Sadness");
                        fearUnlocked = true;
                        View_GamePlay.setFearHero();
                        View_GamePlay.gc.addWorldHero();
                        View_GamePlay.runThread();
                    }
                }
            }

        });
    }

}