package view;

import static view.ViewGamePlay.ec;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import stage.Stage;

/**
 * <h2>ViewStage.java</h2>
 * Kelas ViewStage sebagai view dari Stage.
 *
 * @author Vincent Endrahadi.
 * @since 2017-04-23.
 */
public class ViewStage extends JFrame {
  private static JFrame frameStages = new JFrame("View Stages");
  private static JPanel panelStages = new JPanel();
  private static JPanel header = new JPanel();
  private static JPanel body = new JPanel();
  private static JPanel footer = new JPanel();
  private static JButton stage1 = new JButton();
  private static JButton stage2 = new JButton();
  private static JButton stage3 = new JButton();
  private static JButton stage4 = new JButton();
  private static JButton stage5 = new JButton();
  private static JButton stage6 = new JButton();
  private static JButton stage7 = new JButton();
  private static JButton stage8 = new JButton();
  private static JButton stage9 = new JButton();
  private static JButton stage10 = new JButton();
  private static JButton stage11 = new JButton();
  private static JButton stage12 = new JButton();
  private static JButton stage13 = new JButton();
  private static JButton stage14 = new JButton();
  private static JButton stage15 = new JButton();
  private static JButton stage16 = new JButton();
  private static JButton stage17 = new JButton();
  private static JButton stage18 = new JButton();
  private static JButton stage19 = new JButton();
  private static JButton stage20 = new JButton();
  private static JLabel headLabel;
  private static JLabel label1;
  private static JLabel label2;
  private static JLabel label3;
  private static JLabel label4;
  private static JLabel label5;
  private static JLabel label6;
  private static JLabel label7;
  private static JLabel label8;
  private static JLabel label9;
  private static JLabel label10;
  private static JLabel label11;
  private static JLabel label12;
  private static JLabel label13;
  private static JLabel label14;
  private static JLabel label15;
  private static JLabel label16;
  private static JLabel label17;
  private static JLabel label18;
  private static JLabel label19;
  private static JLabel label20;

  /**
   * Prosedur untuk membangun frame stage.
   */
  public static void buildViewStage() throws FileNotFoundException {
    frameStages.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frameStages.setSize(1366,768);
    frameStages.add(panelStages);

    panelStages.setLayout(null);
    panelStages.setBackground(Color.WHITE);
    panelStages.revalidate();
    panelStages.add(header);
    panelStages.add(body);

    header.setLayout(null);
    header.setBounds(0,0, 1366,150);
    header.setPreferredSize(new Dimension(1366,150));
    header.setBackground(Color.WHITE);

    String filename = JOptionPane.showInputDialog("Input Filename : ");
    headLabel = new JLabel("Stages From " + filename);
    headLabel.setBounds(555,20,500,100);
    headLabel.setFont(new Font("Serif", Font.PLAIN,30));
    headLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    header.add(headLabel);

    body.setLayout(null);
    body.setBounds(0,150 ,1366, 618);
    body.setPreferredSize(new Dimension(1366,618));
    body.setBackground(Color.DARK_GRAY);
    body.add(stage1);
    body.add(stage2);
    body.add(stage3);
    body.add(stage4);
    body.add(stage5);
    body.add(stage6);
    body.add(stage7);
    body.add(stage8);
    body.add(stage9);
    body.add(stage10);
    body.add(stage11);
    body.add(stage12);
    body.add(stage13);
    body.add(stage14);
    body.add(stage15);
    body.add(stage16);
    body.add(stage17);
    body.add(stage18);
    body.add(stage19);
    body.add(stage20);

    stage1.setLayout(null);
    stage2.setLayout(null);
    stage3.setLayout(null);
    stage4.setLayout(null);
    stage5.setLayout(null);
    stage6.setLayout(null);
    stage7.setLayout(null);
    stage8.setLayout(null);
    stage9.setLayout(null);
    stage10.setLayout(null);
    stage11.setLayout(null);
    stage12.setLayout(null);
    stage13.setLayout(null);
    stage14.setLayout(null);
    stage15.setLayout(null);
    stage16.setLayout(null);
    stage17.setLayout(null);
    stage18.setLayout(null);
    stage19.setLayout(null);
    stage20.setLayout(null);

    stage1.setBounds(50, 50, 100,150);
    stage2.setBounds(175, 50, 100,150);
    stage3.setBounds(300, 50, 100,150);
    stage4.setBounds(425, 50, 100,150);
    stage5.setBounds(550, 50, 100,150);
    stage6.setBounds(675, 50, 100,150);
    stage7.setBounds(800, 50, 100,150);
    stage8.setBounds(925, 50, 100,150);
    stage9.setBounds(1050, 50, 100,150);
    stage10.setBounds(1175, 50, 130,150);
    stage11.setBounds(50, 250, 100,150);
    stage12.setBounds(175, 250, 100,150);
    stage13.setBounds(300, 250, 100,150);
    stage14.setBounds(425, 250, 100,150);
    stage15.setBounds(550, 250, 100,150);
    stage16.setBounds(675, 250, 100,150);
    stage17.setBounds(800, 250, 100,150);
    stage18.setBounds(925, 250, 100,150);
    stage19.setBounds(1050, 250, 100,150);
    stage20.setBounds(1175, 250, 130,150);

    ViewGamePlay.initiateController(filename);
    label1 = new JLabel("<html>" + "Stage 1" + "<br>" + "<br>" + "Enemy :" + "<br>" 
      + ViewGamePlay.stages.getGameStage().get(0).getName() + "<br>" + "Health :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(0).getMaxHealth()
      + "<br>" + "Money :" + "<br>" + ViewGamePlay.stages.getGameStage().get(0).getMoneyLoot()
      + "</html>");
    System.out.println(ViewGamePlay.stages.getGameStage().get(0).getName());
    label1.setBounds(10,5,75,130);
    label1.setPreferredSize(new Dimension(75,130));

    label2 = new JLabel("<html>" + "Stage 2" + "<br>" + "<br>" + "Enemy :" + "<br>" 
      + ViewGamePlay.stages.getGameStage().get(1).getName() + "<br>" + "Health :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(1).getMaxHealth()
      + "<br>" + "Money :" + "<br>" + ViewGamePlay.stages.getGameStage().get(1).getMoneyLoot()
      + "</html>");
    System.out.println(ViewGamePlay.stages.getGameStage().get(1).getName());
    label2.setBounds(10,5,75,130);
    label2.setPreferredSize(new Dimension(75,130));

    label3 = new JLabel("<html>" + "Stage 3" + "<br>" + "<br>" + "Enemy :" + "<br>" 
      + ViewGamePlay.stages.getGameStage().get(2).getName() + "<br>" + "Health :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(2).getMaxHealth()
      + "<br>" + "Money :" + "<br>" + ViewGamePlay.stages.getGameStage().get(2).getMoneyLoot()
      + "</html>");
    System.out.println(ViewGamePlay.stages.getGameStage().get(2).getName());
    label3.setBounds(10,5,75,130);
    label3.setPreferredSize(new Dimension(75,130));

    label4 = new JLabel("<html>" + "Stage 4" + "<br>" + "<br>" + "Enemy :" + "<br>" 
      + ViewGamePlay.stages.getGameStage().get(3).getName() + "<br>" + "Health :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(3).getMaxHealth()
      + "<br>" + "Money :" + "<br>" + ViewGamePlay.stages.getGameStage().get(0).getMoneyLoot()
      + "</html>");
    System.out.println(ViewGamePlay.stages.getGameStage().get(3).getName());
    label4.setBounds(10,5,75,130);
    label4.setPreferredSize(new Dimension(75,130));

    label5 = new JLabel("<html>" + "Stage 5" + "<br>" + "<br>" + "Enemy :" + "<br>" 
      + ViewGamePlay.stages.getGameStage().get(4).getName() + "<br>" + "Health :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(4).getMaxHealth()
      + "<br>" + "Money :" + "<br>" + ViewGamePlay.stages.getGameStage().get(0).getMoneyLoot()
      + "</html>");
    System.out.println(ViewGamePlay.stages.getGameStage().get(4).getName());
    label5.setBounds(10,5,75,130);
    label5.setPreferredSize(new Dimension(75,130));

    label6 = new JLabel("<html>" + "Stage 6" + "<br>" + "<br>" + "Enemy :" + "<br>" 
      + ViewGamePlay.stages.getGameStage().get(5).getName() + "<br>" + "Health :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(5).getMaxHealth()
      + "<br>" + "Money :" + "<br>" + ViewGamePlay.stages.getGameStage().get(0).getMoneyLoot()
      + "</html>");
    System.out.println(ViewGamePlay.stages.getGameStage().get(5).getName());
    label6.setBounds(10,5,75,130);
    label6.setPreferredSize(new Dimension(75,130));

    label7 = new JLabel("<html>" + "Stage 7" + "<br>" + "<br>" + "Enemy :" + "<br>" 
      + ViewGamePlay.stages.getGameStage().get(6).getName() + "<br>" + "Health :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(6).getMaxHealth()
      + "<br>" + "Money :" + "<br>" + ViewGamePlay.stages.getGameStage().get(6).getMoneyLoot()
      + "</html>");
    System.out.println(ViewGamePlay.stages.getGameStage().get(6).getName());
    label7.setBounds(10,5,75,130);
    label7.setPreferredSize(new Dimension(75,130));

    label8 = new JLabel("<html>" + "Stage 8" + "<br>" + "<br>" + "Enemy :" + "<br>" 
      + ViewGamePlay.stages.getGameStage().get(7).getName() + "<br>" + "Health :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(7).getMaxHealth()
      + "<br>" + "Money :" + "<br>" + ViewGamePlay.stages.getGameStage().get(7).getMoneyLoot()
      + "</html>");
    System.out.println(ViewGamePlay.stages.getGameStage().get(7).getName());
    label8.setBounds(10,5,75,130);
    label8.setPreferredSize(new Dimension(75,130));

    label9 = new JLabel("<html>" + "Stage 9" + "<br>" + "<br>" + "Enemy :" + "<br>" 
      + ViewGamePlay.stages.getGameStage().get(8).getName() + "<br>" + "Health :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(8).getMaxHealth()
      + "<br>" + "Money :" + "<br>" + ViewGamePlay.stages.getGameStage().get(8).getMoneyLoot()
      + "</html>");
    System.out.println(ViewGamePlay.stages.getGameStage().get(8).getName());
    label9.setBounds(10,5,75,130);
    label9.setPreferredSize(new Dimension(75,130));

    label10 = new JLabel("<html>" + "Stage 10" + "<br>" + "<br>" + "Enemy :" + "<br>" 
      + ViewGamePlay.stages.getGameStage().get(9).getName() + "<br>" + "Health :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(9).getMaxHealth()
      + "<br>" + "Money :" + "<br>" + ViewGamePlay.stages.getGameStage().get(9).getMoneyLoot()
      + "</html>");
    System.out.println(ViewGamePlay.stages.getGameStage().get(9).getName());
    label10.setBounds(10,5,75,130);
    label10.setPreferredSize(new Dimension(75,130));

    label11 = new JLabel("<html>" + "Stage 11" + "<br>" + "<br>" + "Enemy :" + "<br>" 
      + ViewGamePlay.stages.getGameStage().get(10).getName() + "<br>" + "Health :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(10).getMaxHealth()
      + "<br>" + "Money :" + "<br>" + ViewGamePlay.stages.getGameStage().get(10).getMoneyLoot()
      + "</html>");
    System.out.println(ViewGamePlay.stages.getGameStage().get(10).getName());
    label11.setBounds(10,5,75,130);
    label11.setPreferredSize(new Dimension(75,130));

    label12 = new JLabel("<html>" + "Stage 12" + "<br>" + "<br>" + "Enemy :" + "<br>" 
      + ViewGamePlay.stages.getGameStage().get(11).getName() + "<br>" + "Health :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(11).getMaxHealth()
      + "<br>" + "Money :" + "<br>" + ViewGamePlay.stages.getGameStage().get(11).getMoneyLoot()
      + "</html>");
    System.out.println(ViewGamePlay.stages.getGameStage().get(11).getName());
    label12.setBounds(10,5,75,130);
    label12.setPreferredSize(new Dimension(75,130));

    label13 = new JLabel("<html>" + "Stage 13" + "<br>" + "<br>" + "Enemy :" + "<br>" 
      + ViewGamePlay.stages.getGameStage().get(12).getName() + "<br>" + "Health :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(12).getMaxHealth()
      + "<br>" + "Money :" + "<br>" + ViewGamePlay.stages.getGameStage().get(12).getMoneyLoot()
      + "</html>");
    System.out.println(ViewGamePlay.stages.getGameStage().get(12).getName());
    label13.setBounds(10,5,75,130);
    label13.setPreferredSize(new Dimension(75,130));

    label14 = new JLabel("<html>" + "Stage 14" + "<br>" + "<br>" + "Enemy :" + "<br>" 
      + ViewGamePlay.stages.getGameStage().get(13).getName() + "<br>" + "Health :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(13).getMaxHealth()
      + "<br>" + "Money :" + "<br>" + ViewGamePlay.stages.getGameStage().get(13).getMoneyLoot()
      + "</html>");
    System.out.println(ViewGamePlay.stages.getGameStage().get(13).getName());
    label14.setBounds(10,5,75,130);
    label14.setPreferredSize(new Dimension(75,130));

    label15 = new JLabel("<html>" + "Stage 15" + "<br>" + "<br>" + "Enemy :" + "<br>" 
      + ViewGamePlay.stages.getGameStage().get(14).getName() + "<br>" + "Health :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(14).getMaxHealth()
      + "<br>" + "Money :" + "<br>" + ViewGamePlay.stages.getGameStage().get(14).getMoneyLoot()
      + "</html>");
    System.out.println(ViewGamePlay.stages.getGameStage().get(14).getName());
    label15.setBounds(10,5,75,130);
    label15.setPreferredSize(new Dimension(75,130));

    label16 = new JLabel("<html>" + "Stage 16" + "<br>" + "<br>" + "Enemy :" + "<br>" 
      + ViewGamePlay.stages.getGameStage().get(15).getName() + "<br>" + "Health :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(15).getMaxHealth()
      + "<br>" + "Money :" + "<br>" + ViewGamePlay.stages.getGameStage().get(15).getMoneyLoot()
      + "</html>");
    System.out.println(ViewGamePlay.stages.getGameStage().get(15).getName());
    label16.setBounds(10,5,75,130);
    label16.setPreferredSize(new Dimension(75,130));

    label17 = new JLabel("<html>" + "Stage 17" + "<br>" + "<br>" + "Enemy :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(16).getName() + "<br>" + "Health :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(16).getMaxHealth()
      + "<br>" + "Money :" + "<br>" + ViewGamePlay.stages.getGameStage().get(16).getMoneyLoot()
      + "</html>");
    System.out.println(ViewGamePlay.stages.getGameStage().get(16).getName());
    label17.setBounds(10,5,75,130);
    label17.setPreferredSize(new Dimension(75,130));

    label18 = new JLabel("<html>" + "Stage 18" + "<br>" + "<br>" + "Enemy :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(17).getName() + "<br>" + "Health :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(17).getMaxHealth()
      + "<br>" + "Money :" + "<br>" + ViewGamePlay.stages.getGameStage().get(17).getMoneyLoot()
      + "</html>");
    System.out.println(ViewGamePlay.stages.getGameStage().get(17).getName());
    label18.setBounds(10,5,75,130);
    label18.setPreferredSize(new Dimension(75,130));

    label19 = new JLabel("<html>" + "Stage 19" + "<br>" + "<br>" + "Enemy :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(18).getName() + "<br>" + "Health :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(18).getMaxHealth()
      + "<br>" + "Money :" + "<br>" + ViewGamePlay.stages.getGameStage().get(18).getMoneyLoot()
      + "</html>");
    System.out.println(ViewGamePlay.stages.getGameStage().get(18).getName());
    label19.setBounds(10,5,75,130);
    label19.setPreferredSize(new Dimension(75,130));

    label20 = new JLabel("<html>" + "Stage 20" + "<br>" + "<br>" + "Enemy :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(19).getName() + "<br>" + "Health :" + "<br>"
      + ViewGamePlay.stages.getGameStage().get(19).getMaxHealth()
      + "<br>" + "Money :" + "<br>" + ViewGamePlay.stages.getGameStage().get(19).getMoneyLoot()
      + "</html>");
    System.out.println(ViewGamePlay.stages.getGameStage().get(19).getName());
    label20.setBounds(10,5,75,130);
    label20.setPreferredSize(new Dimension(75,130));

    stage1.add(label1);
    stage2.add(label2);
    stage3.add(label3);
    stage4.add(label4);
    stage5.add(label5);
    stage6.add(label6);
    stage7.add(label7);
    stage8.add(label8);
    stage9.add(label9);
    stage10.add(label10);
    stage11.add(label11);
    stage12.add(label12);
    stage13.add(label13);
    stage14.add(label14);
    stage15.add(label15);
    stage16.add(label16);
    stage17.add(label17);
    stage18.add(label18);
    stage19.add(label19);
    stage20.add(label20);

    stage1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewGamePlay.ec.setEnemyModel(ViewGamePlay.stages.getGameStage().get(0));
        ViewGamePlay.stages.setCurStage(0);
        frameStages.setVisible(false);
        try {
          ViewGamePlay.buildViewGamePlay();
        } catch (FileNotFoundException el) {
          el.printStackTrace();
        }
      }
    });
    stage2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewGamePlay.ec.setEnemyModel(ViewGamePlay.stages.getGameStage().get(1));
        ViewGamePlay.stages.setCurStage(1);
        frameStages.setVisible(false);
        try {
          ViewGamePlay.buildViewGamePlay();
        } catch (FileNotFoundException el) {
          el.printStackTrace();
        }
      }
    });
    stage3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewGamePlay.ec.setEnemyModel(ViewGamePlay.stages.getGameStage().get(2));
        ViewGamePlay.stages.setCurStage(2);
        frameStages.setVisible(false);
        try {
          ViewGamePlay.buildViewGamePlay();
        } catch (FileNotFoundException el) {
          el.printStackTrace();
        }
      }
    });
    stage4.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewGamePlay.ec.setEnemyModel(ViewGamePlay.stages.getGameStage().get(3));
        ViewGamePlay.stages.setCurStage(3);
        frameStages.setVisible(false);
        try {
          ViewGamePlay.buildViewGamePlay();
        } catch (FileNotFoundException el) {
          el.printStackTrace();
        }
      }
    });
    stage5.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewGamePlay.ec.setEnemyModel(ViewGamePlay.stages.getGameStage().get(4));
        ViewGamePlay.stages.setCurStage(4);
        frameStages.setVisible(false);
        try {
          ViewGamePlay.buildViewGamePlay();
        } catch (FileNotFoundException el) {
          el.printStackTrace();
        }
      }
    });
    stage6.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewGamePlay.ec.setEnemyModel(ViewGamePlay.stages.getGameStage().get(5));
        ViewGamePlay.stages.setCurStage(5);
        frameStages.setVisible(false);
        try {
          ViewGamePlay.buildViewGamePlay();
        } catch (FileNotFoundException el) {
          el.printStackTrace();
        }
      }
    });
    stage7.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewGamePlay.ec.setEnemyModel(ViewGamePlay.stages.getGameStage().get(6));
        ViewGamePlay.stages.setCurStage(6);
        frameStages.setVisible(false);
        try {
          ViewGamePlay.buildViewGamePlay();
        } catch (FileNotFoundException el) {
          el.printStackTrace();
        }
      }
    });
    stage8.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewGamePlay.ec.setEnemyModel(ViewGamePlay.stages.getGameStage().get(7));
        ViewGamePlay.stages.setCurStage(7);
        frameStages.setVisible(false);
        try {
          ViewGamePlay.buildViewGamePlay();
        } catch (FileNotFoundException el) {
          el.printStackTrace();
        }
      }
    });
    stage9.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewGamePlay.ec.setEnemyModel(ViewGamePlay.stages.getGameStage().get(8));
        ViewGamePlay.stages.setCurStage(8);
        frameStages.setVisible(false);
        try {
          ViewGamePlay.buildViewGamePlay();
        } catch (FileNotFoundException el) {
          el.printStackTrace();
        }
      }
    });
    stage10.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewGamePlay.ec.setEnemyModel(ViewGamePlay.stages.getGameStage().get(9));
        ViewGamePlay.stages.setCurStage(9);
        frameStages.setVisible(false);
        try {
          ViewGamePlay.buildViewGamePlay();
        } catch (FileNotFoundException el) {
          el.printStackTrace();
        }
      }
    });
    stage11.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewGamePlay.ec.setEnemyModel(ViewGamePlay.stages.getGameStage().get(10));
        ViewGamePlay.stages.setCurStage(10);
        frameStages.setVisible(false);
        try {
          ViewGamePlay.buildViewGamePlay();
        } catch (FileNotFoundException el) {
          el.printStackTrace();
        }
      }
    });
    stage12.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewGamePlay.ec.setEnemyModel(ViewGamePlay.stages.getGameStage().get(11));
        ViewGamePlay.stages.setCurStage(11);
        frameStages.setVisible(false);
        try {
          ViewGamePlay.buildViewGamePlay();
        } catch (FileNotFoundException el) {
          el.printStackTrace();
        }
      }
    });
    stage13.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewGamePlay.ec.setEnemyModel(ViewGamePlay.stages.getGameStage().get(12));
        ViewGamePlay.stages.setCurStage(12);
        frameStages.setVisible(false);
        try {
          ViewGamePlay.buildViewGamePlay();
        } catch (FileNotFoundException el) {
          el.printStackTrace();
        }
      }
    });
    stage14.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewGamePlay.ec.setEnemyModel(ViewGamePlay.stages.getGameStage().get(13));
        ViewGamePlay.stages.setCurStage(13);
        frameStages.setVisible(false);
        try {
          ViewGamePlay.buildViewGamePlay();
        } catch (FileNotFoundException el) {
          el.printStackTrace();
        }
      }
    });
    stage15.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewGamePlay.ec.setEnemyModel(ViewGamePlay.stages.getGameStage().get(14));
        ViewGamePlay.stages.setCurStage(14);
        frameStages.setVisible(false);
        try {
          ViewGamePlay.buildViewGamePlay();
        } catch (FileNotFoundException el) {
          el.printStackTrace();
        }
      }
    });
    stage16.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewGamePlay.ec.setEnemyModel(ViewGamePlay.stages.getGameStage().get(15));
        ViewGamePlay.stages.setCurStage(15);
        frameStages.setVisible(false);
        try {
          ViewGamePlay.buildViewGamePlay();
        } catch (FileNotFoundException el) {
          el.printStackTrace();
        }
      }
    });
    stage17.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewGamePlay.ec.setEnemyModel(ViewGamePlay.stages.getGameStage().get(16));
        ViewGamePlay.stages.setCurStage(16);
        frameStages.setVisible(false);
        try {
          ViewGamePlay.buildViewGamePlay();
        } catch (FileNotFoundException el) {
          el.printStackTrace();
        }
      }
    });
    stage18.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewGamePlay.ec.setEnemyModel(ViewGamePlay.stages.getGameStage().get(17));
        ViewGamePlay.stages.setCurStage(17);
        frameStages.setVisible(false);
        try {
          ViewGamePlay.buildViewGamePlay();
        } catch (FileNotFoundException el) {
          el.printStackTrace();
        }
      }
    });
    stage19.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewGamePlay.ec.setEnemyModel(ViewGamePlay.stages.getGameStage().get(18));
        ViewGamePlay.stages.setCurStage(18);
        frameStages.setVisible(false);
        try {
          ViewGamePlay.buildViewGamePlay();
        } catch (FileNotFoundException el) {
          el.printStackTrace();
        }
      }
    });
    stage20.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ViewGamePlay.ec.setEnemyModel(ViewGamePlay.stages.getGameStage().get(19));
        ViewGamePlay.stages.setCurStage(19);
        frameStages.setVisible(false);
        try {
          ViewGamePlay.buildViewGamePlay();
        } catch (FileNotFoundException el) {
          el.printStackTrace();
        }
      }
    });


    frameStages.setVisible(true);


  }

  /**
   * Prosedur untuk mengeksekusi pembangunan stage.
   * @throws FileNotFoundException exception bila file tidak ditemukan.
   */
  public ViewStage() throws FileNotFoundException {
    buildViewStage();
  }
}
