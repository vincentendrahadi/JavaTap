package Shop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by itb_13515140 on 22/04/17.
 */
public class ShopInterface {
    private JButton playerButton;
    private JPanel panelMain;
    private JLabel WELCOMETOTHESHOPLabel;
    private JButton joyButton;
    private JButton sadnessButton;
    private JButton angerButton;
    private JButton disgustButton;
    private JButton fearButton;
    private JTextField cash;
    private JTextField a100TextField;
    private JTextField a200TextField;
    private JTextField a300TextField;
    private JTextField a400TextField;
    private JTextField a500TextField;
    private JButton backToGameButton;
    private boolean joy = true;
    private boolean sadness = false;
    private boolean anger = false;
    private boolean disgust = false;
    private boolean fear = false;

    public ShopInterface() {

        sadnessButton.setEnabled(false);
        angerButton.setEnabled(false);
        disgustButton.setEnabled(false);
        fearButton.setEnabled(false);

        playerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"Hedon Lu!");
            }


        });

        joyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"Joy!");
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
                JOptionPane.showMessageDialog(null,"Sadness!");
                anger =  true;
                if(anger){
                    angerButton.setEnabled(true);
                }
            }
        });

        angerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"Anger!");
                disgust = true;
                if(disgust){
                    disgustButton.setEnabled(true);
                }
            }
        });
        disgustButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"Disgust!");
                fear = true;
                if(fear){
                    fearButton.setEnabled(true);
                }
            }

        });

        fearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"Fear!");
            }

        });


    }

    public void disableHero(){
        sadnessButton.setEnabled(false);
        angerButton.setEnabled(false);
        disgustButton.setEnabled(false);
        fearButton.setEnabled(false);
    }

    //public void enable()


    public static void main(String[] args) {
        JFrame testFrame = new JFrame("ShopInterface");
        testFrame.setContentPane(new ShopInterface().panelMain);
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testFrame.pack();
        testFrame.setVisible(true);

    }
}
