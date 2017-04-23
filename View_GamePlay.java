import javax.swing.*;
import javax.swing.text.View;

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
                View_Shop.getFrameShop().setSize(1366,768);
                View_Shop.getFrameShop().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                View_Shop.getPanelShop().setBackground(Color.gray);
                View_Shop.getPanelShop().add(View_Shop.getBackToGameButton());
                View_Shop.getFrameShop().setContentPane(new View_Shop().getPanelShop());
                View_Shop.getFrameShop().setVisible(true);
            }
        });
    }
}
