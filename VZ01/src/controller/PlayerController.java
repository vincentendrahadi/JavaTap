package controller;

import enemy.Enemy;
import maincharacter.player.Player;

/**
 * Created by axelinate on 4/23/17.
 */
public class PlayerController {
    private Player playerModel;

    public PlayerController(Player playerModel) {
        this.playerModel = playerModel;
    }

    public Thread getModelThread() {
        return playerModel.getPlayerThread();
    }

    public String getModelName() {
        return playerModel.getName();
    }

    public int getModelAttPower() {
        return playerModel.getAttPower();
    }

    public int getModelLevel() {
        return playerModel.getLevel();
    }

    public int getModelMoney() {
        return playerModel.getMoney();
    }

    public boolean getModelThereIsEbnemy() {
        return playerModel.getThereIsEnemy();
    }

    public Player getPlayerModel() {
        return playerModel;
    }

    public void setPlayerModel(Player playerModel) {
        this.playerModel = playerModel;
    }

    public void setModelEnemy(Enemy enemy) {
       playerModel.setEnemy(enemy);
    }

    public void plusModelMoney(int money) {
        playerModel.plusMoney(money);
    }

    public void startModel() {
        playerModel.start();
    }

    public void setModelThreadNull() {
        playerModel.setThreadNull();
    }

    public void modelLevelUp() {
        playerModel.levelUp();
    }

    public void attackEnemy(EnemyController ec) {
        playerModel.attack(ec.getEnemyModel());
    }

}
