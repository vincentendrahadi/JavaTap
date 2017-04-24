package view;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Vincent Endrahadi on 4/23/17.
 */
public class View_Stage extends JFrame {
  private static JFrame frameStages = new JFrame("View Stages");
  private static JPanel panelStages = new JPanel();
  private static JPanel header = new JPanel();
  private static JPanel body = new JPanel();
  private static JPanel footer = new JPanel();

  public static void buildViewStage() {
    frameStages.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frameStages.setSize(1366,768);
    frameStages.add(panelStages);
    frameStages.setVisible(true);

    panelStages.setLayout(new GridLayout(3,1));
    panelStages.setBackground(Color.BLUE);
    String filename = JOptionPane.showInputDialog("Input Filename : ");
    panelStages.setBackground(Color.WHITE);
    panelStages.revalidate();

    header.setLayout(new GridLayout(1,1));
    header.setPreferredSize(new Dimension(1366,200));
    header.setBackground(Color.BLUE);

    footer.setLayout(new GridLayout(1,1));
    footer.setPreferredSize(new Dimension(1366,200));
    footer.setBackground(Color.RED);

    body.setLayout(new GridLayout(1,1));
    body.setPreferredSize(new Dimension(1366,200));
    body.setBackground(Color.GREEN);

    panelStages.add(header);
    panelStages.add(footer);
    panelStages.add(body);
  }

  public View_Stage() {

  }

  public static void main(String[] args) {
    buildViewStage();

  }
}
