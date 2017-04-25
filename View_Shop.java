package view;

import javax.imageio.ImageIO;
import javax.swing.*;

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
        lowerPanel.setBounds(0,708,1366,60);
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

        JLabel playerPrice = new JLabel("500");
        playerPrice.setLayout(null);
        playerPrice.setFont(new Font("", Font.PLAIN,30));
        playerPrice.setForeground(Color.WHITE);
        playerPrice.setBounds(130,120,200,50);

        JLabel joyPrice = new JLabel("600");
        joyPrice.setLayout(null);
        joyPrice.setFont(new Font("", Font.PLAIN,30));
        joyPrice.setForeground(Color.WHITE);
        joyPrice.setBounds(130,300,200,50);

        JLabel sadnessPrice = new JLabel("700");
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
            BufferedImage img1 = ImageIO.read(new File("/home/axelinate/IdeaProjects/B&B/src/res/player_icon.jpg"));
            ImageIcon icon1 = new ImageIcon(img1);
            JLabel label1 = new JLabel(icon1);
            firstCenterPanel.add(label1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedImage img2 = ImageIO.read(new File("/home/axelinate/IdeaProjects/B&B/src/res/joy_icon.jpg"));
            ImageIcon icon2 = new ImageIcon(img2);
            JLabel label2 = new JLabel(icon2);
            firstCenterPanel.add(label2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedImage img3 = ImageIO.read(new File("/home/axelinate/IdeaProjects/B&B/src/res/sadness_icon.jpg"));
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

        JLabel angerPrice = new JLabel("800");
        angerPrice.setLayout(null);
        angerPrice.setFont(new Font("", Font.PLAIN,30));
        angerPrice.setForeground(Color.WHITE);
        angerPrice.setBounds(130,120,200,50);

        JLabel disgustPrice = new JLabel("900");
        disgustPrice.setLayout(null);
        disgustPrice.setFont(new Font("", Font.PLAIN,30));
        disgustPrice.setForeground(Color.WHITE);
        disgustPrice.setBounds(130,300,200,50);

        JLabel fearPrice = new JLabel("1000");
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
            BufferedImage img4 = ImageIO.read(new File("/home/axelinate/IdeaProjects/B&B/src/res/anger_icon.jpg"));
            ImageIcon icon4 = new ImageIcon(img4);
            JLabel label4 = new JLabel(icon4);
            rightPanel.add(label4);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedImage img5 = ImageIO.read(new File("/home/axelinate/IdeaProjects/B&B/src/res/disgust_icon.jpg"));
            ImageIcon icon5 = new ImageIcon(img5);
            JLabel label5 = new JLabel(icon5);
            rightPanel.add(label5);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedImage img6 = ImageIO.read(new File("/home/axelinate/IdeaProjects/B&B/src/res/fear_icon.jpg"));
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
                frameShop.setVisible(false);
            }
        });

        playerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }

        });

        joyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!joyUnlocked) {
                    View_GamePlay.gc.setWorldThreadToNull();
                    joyButton.setText("Level up Joy");
                    joyUnlocked = true;
                    View_GamePlay.setJoyHero();
                    View_GamePlay.gc.addWorldHero();
                    View_GamePlay.focusKey();
                    View_GamePlay.runThread();
                    frameShop.setVisible(false);
                }

                sadness = true;
                if(sadness)
                {
                    sadnessButton.setEnabled(true);
                }
            }

        });

        sadnessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!sadnessUnlocked) {
                    sadnessButton.setText("Level up Sadness");
                    sadnessUnlocked = true;

                }

                anger =  true;
                if(anger){
                    angerButton.setEnabled(true);
                }
            }
        });

        angerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!angerUnlocked) {
                    angerButton.setText("Level up Anger");
                    angerUnlocked = true;
                }

                disgust = true;
                if(disgust){
                    disgustButton.setEnabled(true);
                }
            }
        });
        disgustButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!disgustUnlocked) {
                    disgustButton.setText("Level up Disgust");
                    disgustUnlocked = true;
                }

                fear = true;
                if(fear){
                    fearButton.setEnabled(true);
                }
            }

        });

        fearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!fearUnlocked) {
                    fearButton.setText("Level up Fear");
                    fearUnlocked = true;
                }
            }

        });
    }

}