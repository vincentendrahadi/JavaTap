import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by adit on 22/04/17.
 */
public class View_Shop extends JFrame {
    private static JPanel panelShop = new JPanel();
    private static JButton backToGameButton = new JButton("Back to game");
    private static JFrame frameShop = new JFrame();

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

    public View_Shop() {
        backToGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameShop.setVisible(false);
                View_GamePlay.getFrameMain().setVisible(true);
            }
        });
    }
}
