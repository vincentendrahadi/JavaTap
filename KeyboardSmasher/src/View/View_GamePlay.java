package View;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by adit on 22/04/17.
 */

public class View_GamePlay extends JFrame {
    private static JPanel panelGamePlay = new JPanel();
    private static JButton shop = new JButton("Shop");
    private static JFrame frameMain = new JFrame("GamePlay");

    public static void main(String[] args) {
        new View_GamePlay();
    }

    public static void setFrameMain(JFrame frameMain) {
        View_GamePlay.frameMain = frameMain;
    }

    public static JFrame getFrameMain() {
        return frameMain;
    }

    public static void setShop(JButton shop) {
        View_GamePlay.shop = shop;
    }

    public static JButton getShop() {
        return shop;
    }

    public static void setPanelGamePlay(JPanel panelGamePlay) {
        View_GamePlay.panelGamePlay = panelGamePlay;
    }

    public static JPanel getPanelGamePlay() {
        return panelGamePlay;
    }

    public View_GamePlay() {
        shop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMain.setVisible(false);
                if (!View_Shop.isBuild()) {
                    //Set frame
                    View_Shop.getFrameShop().setSize(1366, 768);
                    View_Shop.getFrameShop().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    //Set panel
                    View_Shop.getPanelShop().setBackground(Color.gray);

                    //Set and add Back to game button
                    View_Shop.getPanelShop().add(View_Shop.getBackToGameButton());

                    //Set and add Back player button
                    View_Shop.getPanelShop().add(View_Shop.getPlayerButton());

                    //Set and add Back joy button
                    View_Shop.getPanelShop().add(View_Shop.getJoyButton());

                    //Set and add Back sadness button
                    View_Shop.getPanelShop().add(View_Shop.getSadnessButton());
                    View_Shop.getSadnessButton().setEnabled(false);

                    //Set and add Back anger button
                    View_Shop.getPanelShop().add(View_Shop.getAngerButton());
                    View_Shop.getAngerButton().setEnabled(false);

                    //Set and add Back disgust button
                    View_Shop.getPanelShop().add(View_Shop.getDisgustButton());
                    View_Shop.getDisgustButton().setEnabled(false);

                    //Set and add Back fear button
                    View_Shop.getPanelShop().add(View_Shop.getFearButton());
                    View_Shop.getFearButton().setEnabled(false);

                    //Set frame with panel
                    View_Shop.getFrameShop().setContentPane(new View_Shop().getPanelShop());

                    //Show frame
                    View_Shop.getFrameShop().setVisible(true);
                    View_Shop.setBuild(true);
                } else {
                    View_Shop.getFrameShop().setVisible(true);
                }
            }
        });
    }
}
