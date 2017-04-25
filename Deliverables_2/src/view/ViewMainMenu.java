package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * <h2>ViewMainMenu.java</h2>
 * Kelas ViewMainMenu sebagai view dari MainMenu.
 *
 * @author adit
 * @since 2017-04-22
 */
public class ViewMainMenu extends JFrame {
  private static JFrame frameMainMenu = new JFrame("Tap Hero");
  private static JPanel panelMainMenu = new JPanel();
  private static JPanel logo = new JPanel();
  private static JButton startButton = new JButton("Start Game");
  private static JButton loadButton = new JButton("Load Game");
  private static JButton exitButton = new JButton("Quit Game");

  /**
   * Prosedur untuk membangun frame main menu.
   */
  public static void buildViewGame() {
    frameMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frameMainMenu.setSize(1366,768);

    panelMainMenu.setLayout(null);
    panelMainMenu.setBounds(0,486,1366,768);
    panelMainMenu.setBackground(Color.BLACK);

    logo.setBackground(Color.BLACK);

    try {
      BufferedImage img = ImageIO.read(new
              File("/home/itb_13515140/Desktop/Deliverables/src/res/main_panel.png"));
      ImageIcon icon = new ImageIcon(img);
      JLabel label = new JLabel(icon);
      logo.add(label);
    } catch (IOException e) {
      e.printStackTrace();
    }

    startButton.setFocusPainted(false);
    startButton.setBounds(590,10, 170,50);
    startButton.setBackground(Color.DARK_GRAY);
    startButton.setForeground(new Color(44,214,205));

    loadButton.setFocusPainted(false);
    loadButton.setBounds(590,80, 170,50);
    loadButton.setBackground(Color.DARK_GRAY);
    loadButton.setForeground(new Color(44,214,205));

    exitButton.setFocusPainted(false);
    exitButton.setBounds(590,150, 170,50);
    exitButton.setBackground(Color.DARK_GRAY);
    exitButton.setForeground(new Color(44,214,205));

    panelMainMenu.add(startButton);
    panelMainMenu.add(loadButton);
    panelMainMenu.add(exitButton);

    frameMainMenu.getContentPane().add(panelMainMenu);
    frameMainMenu.getContentPane().add(logo);
    frameMainMenu.setVisible(true);
  }


  public static void main(String[] args) throws FileNotFoundException {
    buildViewGame();
    new ViewMainMenu();
  }

  /**
   * Konstruktor untuk ViewMainMenu.
   * @throws FileNotFoundException mengembalikan exception bila gagal membaca .
   */
  public ViewMainMenu() throws FileNotFoundException {
    startButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frameMainMenu.setVisible(false);
        try {
          ViewGamePlay.buildViewGamePlay();
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
          ViewStage.buildViewStage();
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