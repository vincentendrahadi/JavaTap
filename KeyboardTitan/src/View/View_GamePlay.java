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
                    View_Shop.buildShop();
                    View_Shop.getSadnessButton().setEnabled(false);
                    View_Shop.getAngerButton().setEnabled(false);
                    View_Shop.getDisgustButton().setEnabled(false);
                    View_Shop.getFearButton().setEnabled(false);
                    /*

                    //Set and add Back sadness button
                    View_Shop.getPanelShop().add(View_Shop.getSadnessButton());


                    //Set and add Back anger button
                    View_Shop.getPanelShop().add(View_Shop.getAngerButton());


                    //Set and add Back disgust button
                    View_Shop.getPanelShop().add(View_Shop.getDisgustButton());


                    //Set and add Back fear button
                    View_Shop.getPanelShop().add(View_Shop.getFearButton());


                    //Set frame with panel
                    View_Shop.getFrameShop().setContentPane(new View_Shop().getPanelShop());

                    //Show frame
                    View_Shop.getFrameShop().setVisible(true);
                    */

                    View_Shop.setBuild(true);
                    View_Shop.getFrameShop().setVisible(true);
                } else {
                    View_Shop.getFrameShop().setVisible(true);
                }
            }
        });
    }
}
