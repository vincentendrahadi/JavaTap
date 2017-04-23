import oracle.jrockit.jfr.JFR;
import sun.plugin2.util.ColorUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.*;

/**
 * Created by adit on 22/04/17.
 */
public class View_MainMenu extends JFrame {
    private static JFrame frameMainMenu;
    private static JPanel panelMainMenu;
    private static JPanel logo;
    private static JButton startButton;
    private static JButton loadButton;
    private static JButton exitButton;

    public static void main(String[] args) {
        frameMainMenu = new JFrame("Tap Hero");
        frameMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMainMenu.setSize(1366,768);
        panelMainMenu = new JPanel();
        logo = new JPanel();
        startButton = new JButton("Start Game");
        loadButton = new JButton("Load Game");
        exitButton = new JButton("Quit Game");
        panelMainMenu.setLayout(null);
        panelMainMenu.setSize(1366, 300);
        panelMainMenu.setBackground(Color.BLACK);
        startButton.setBounds(5,5, 30,30);
        panelMainMenu.add(startButton);
        panelMainMenu.add(loadButton);
        panelMainMenu.add(exitButton);
        frameMainMenu.add(panelMainMenu);
        frameMainMenu.add(logo);
        startButton.setFocusPainted(false);
        startButton.setBounds(615,0, 130,40);
        startButton.setBackground(Color.DARK_GRAY);
        startButton.setForeground(new Color(44,214,205));

        loadButton.setFocusPainted(false);
        loadButton.setBounds(615,50, 130,40);
        loadButton.setBackground(Color.DARK_GRAY);
        loadButton.setForeground(new Color(44,214,205));

        exitButton.setFocusPainted(false);
        exitButton.setBounds(615,100, 130,40);
        exitButton.setBackground(Color.DARK_GRAY);
        exitButton.setForeground(new Color(44,214,205));
        frameMainMenu.setContentPane(new View_MainMenu().panelMainMenu);
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
