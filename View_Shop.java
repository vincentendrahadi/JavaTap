package View;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MainCharacter.Player.Player;


/**
 * Created by adit on 22/04/17.
 */
public class View_Shop extends JFrame {
    private static JFrame frameShop = new JFrame();
    private static JPanel panelShop = new JPanel();
    private static JButton backToGameButton = new JButton("Back to game");
    private static JButton playerButton = new JButton("Level up Player");
    private static JButton joyButton = new JButton("Unlocked Joy");
    private static JButton sadnessButton = new JButton("Unlocked Sadness");
    private static JButton angerButton = new JButton("Unlocked Anger");
    private static JButton disgustButton = new JButton("Unlocked Disgust");
    private static JButton fearButton = new JButton("Unlocked Fear");

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

    public static void main(String[] args) {
        new View_Shop();
    }

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

    public View_Shop() {
        backToGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameShop.setVisible(false);
                View_GamePlay.getFrameMain().setVisible(true);
            }
        });

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
                if (!joyUnlocked) {
                    joyButton.setText("Level up Joy");
                    joyUnlocked = true;
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
                JOptionPane.showMessageDialog(null,"Sadness!");
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
                JOptionPane.showMessageDialog(null,"Anger!");
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
                JOptionPane.showMessageDialog(null,"Disgust!");
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
                JOptionPane.showMessageDialog(null,"Fear!");
                if (!fearUnlocked) {
                    fearButton.setText("Level up Fear");
                    fearUnlocked = true;
                }
            }

        });
    }
}
