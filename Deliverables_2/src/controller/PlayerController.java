package controller;

import enemy.Enemy;
import maincharacter.player.Player;

/**
 * <h2>PlayerController.java</h2>
 * Kelas PlayerController sebagai control dari PLAYER.
 *
 * @author axelinate
 * @since 2017-04-23
 */
public class PlayerController {
  private Player playerModel;

  /**
   * Konstruktor untuk PlayerController.
   * @param playerModel entitas model yang dimiliki player.
   */
  public PlayerController(Player playerModel) {
    this.playerModel = playerModel;
  }

  /**
   * Getter Thread yang berurusan dengan entitas player.
   * @return Thread.
   */
  public Thread getModelThread() {
    return playerModel.getPlayerThread();
  }

  /**
   * Getter nama player.
   * @return String.
   */
  public String getModelName() {
    return playerModel.getName();
  }

  /**
   * Getter attac power dari Player.
   * @return int .
   */
  public int getModelAttPower() {
    return playerModel.getAttPower();
  }

  /**
   * Getter level dari Player.
   * @return int .
   */
  public int getModelLevel() {
    return playerModel.getLevel();
  }

  /**
   * Getter uang dari entitas Player.
   * @return int .
   */
  public int getModelMoney() {
    return playerModel.getMoney();
  }

  /**
   * Getter status apakah ada entitas enemy.
   * @return boolean .
   */
  public boolean getModelThereIsEbnemy() {
    return playerModel.getThereIsEnemy();
  }

  /**
   * Getter entitas Player.
   * @return Player .
   */
  public Player getPlayerModel() {
    return playerModel;
  }

  /**
   * Setter entitas Player.
   * @param playerModel .
   */
  public void setPlayerModel(Player playerModel) {
    this.playerModel = playerModel;
  }

  /**
   * Setter entitas enemy.
   * @param enemy  .
   */
  public void setModelEnemy(Enemy enemy) {
    playerModel.setEnemy(enemy);
  }

  /**
   * Setter yang menjumlahkan uang.
   * @param money  .
   */
  public void plusModelMoney(int money) {
    playerModel.plusMoney(money);
  }

  /**
   * Memulai entitas Player.
   */
  public void startModel() {
    playerModel.start();
  }

  /**
   * Setter thread player menjadi.
   */
  public void setModelThreadNull() {
    playerModel.setThreadNull();
  }

  /**
   * Menambah level player.
   */
  public void modelLevelUp() {
    playerModel.levelUp();
  }

  /**
   * Memberi damage pada enemy.
   * @param ec  .
   */
  public void attackEnemy(EnemyController ec) {
    playerModel.attack(ec.getEnemyModel());
  }
}
