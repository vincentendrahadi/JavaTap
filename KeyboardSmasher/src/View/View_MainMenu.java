package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.Font.*;

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
        panelMainMenu.setBounds(0,300,1366,768);
        panelMainMenu.setBackground(Color.BLACK);

        //logo.setLayout(null);
        //logo.setBounds(0,0,1366,300);
        logo.setBackground(Color.BLACK);




        try {
            BufferedImage img = ImageIO.read(new File("/home/adit/IdeaProjects/rsz_hero.png"));
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
        startButton.setBounds(615,50, 130,40);
        startButton.setBackground(Color.DARK_GRAY);
        startButton.setForeground(new Color(44,214,205));

        loadButton.setFocusPainted(false);
        loadButton.setBounds(615,150, 130,40);
        loadButton.setBackground(Color.DARK_GRAY);
        loadButton.setForeground(new Color(44,214,205));

        exitButton.setFocusPainted(false);
        exitButton.setBounds(615,250, 130,40);
        exitButton.setBackground(Color.DARK_GRAY);
        exitButton.setForeground(new Color(44,214,205));

        panelMainMenu.add(startButton);
        panelMainMenu.add(loadButton);
        panelMainMenu.add(exitButton);

        //frameMainMenu.setContentPane(new View_MainMenu());
        frameMainMenu.getContentPane().add(panelMainMenu);
        frameMainMenu.getContentPane().add(logo);
        frameMainMenu.setVisible(true);

        new View_MainMenu();
    }


    public View_MainMenu() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMainMenu.setVisible(false);
                View_GamePlay.getFrameMain().setSize(1366,768);
                View_GamePlay.getFrameMain().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                View_GamePlay.getPanelGamePlay().setBackground(Color.gray);
                View_GamePlay.getPanelGamePlay().add(View_GamePlay.getShop());
                View_GamePlay.getFrameMain().setContentPane(new View_GamePlay().getPanelGamePlay());
                View_GamePlay.getFrameMain().setVisible(true);
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMainMenu.setVisible(false);
                View_GamePlay.getFrameMain().setSize(1366,768);
                View_GamePlay.getFrameMain().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                View_GamePlay.getPanelGamePlay().setBackground(Color.gray);
                View_GamePlay.getPanelGamePlay().add(View_GamePlay.getShop());
                View_GamePlay.getFrameMain().add(View_GamePlay.getPanelGamePlay());
                View_GamePlay.getFrameMain().setVisible(true);
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