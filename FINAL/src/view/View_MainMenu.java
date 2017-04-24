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

/**
 * Created by adit on 22/04/17.
 */
public class View_MainMenu extends JFrame {
    private static JFrame frameMainMenu = new JFrame("Tap Hero");
    private static JPanel panelMainMenu = new JPanel();
    private static JPanel logo = new JPanel();
    private static JButton startButton = new JButton("Start Game");
    private static JButton loadButton = new JButton("Load Game");
    private static JButton exitButton = new JButton("Quit Game");


    public static void buildViewGame() {
        frameMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMainMenu.setSize(1366,768);

        panelMainMenu.setLayout(null);
        panelMainMenu.setBounds(0,486,1366,768);
        panelMainMenu.setBackground(Color.BLACK);

        //logo.setLayout(null);
        //logo.setBounds(0,0,1366,300);
        logo.setBackground(Color.BLACK);

        try {
            BufferedImage img = ImageIO.read(new File("/home/itb_13515140/Desktop/FINAL/src/res/main_panel.png"));
            ImageIcon icon = new ImageIcon(img);
            JLabel label = new JLabel(icon);
            logo.add(label);
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*panelMainMenu.add(startButton);
        panelMainMenu.add(loadButton);
        panelMainMenu.add(exitButton);*/

        startButton.setFocusPainted(false);
        startButton.setBounds(590,30, 170,50);
        startButton.setBackground(Color.DARK_GRAY);
        startButton.setForeground(new Color(44,214,205));

        loadButton.setFocusPainted(false);
        loadButton.setBounds(590,100, 170,50);
        loadButton.setBackground(Color.DARK_GRAY);
        loadButton.setForeground(new Color(44,214,205));

        exitButton.setFocusPainted(false);
        exitButton.setBounds(590,170, 170,50);
        exitButton.setBackground(Color.DARK_GRAY);
        exitButton.setForeground(new Color(44,214,205));

        panelMainMenu.add(startButton);
        panelMainMenu.add(loadButton);
        panelMainMenu.add(exitButton);

        frameMainMenu.getContentPane().add(panelMainMenu);
        frameMainMenu.getContentPane().add(logo);
        frameMainMenu.setVisible(true);
    }


    public static void main(String[] args) throws FileNotFoundException{
        buildViewGame();
        new View_MainMenu();
    }

    public View_MainMenu() throws FileNotFoundException{
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMainMenu.setVisible(false);
                try {
                    View_GamePlay.buildViewGamePlay();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMainMenu.setVisible(false);
                try {
                    View_GamePlay.buildViewGamePlay();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMainMenu.dispose();
            }
        });

    }
}