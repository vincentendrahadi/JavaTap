package controller;

import enemy.BossEnemy;
import enemy.Enemy;

/**
 * <h2>EnemyController.java</h2>
 * Kelas EnemyController sebagai control dari ENEMY.
 *
 * @author axelinate
 * @since 2017-04-17
 */
public class EnemyController {
  private Enemy enemyModel;

  /**
   * Konstruktor untuk EnemyController.
   * @param enemyModel entitas model yang dimiliki Enemy.
   */
  public EnemyController(Enemy enemyModel) {
    this.enemyModel = enemyModel;
  }

  /**
   * Getter Model Enemy.
   * @return Enemy.
   */
  public Enemy getEnemyModel() {
    return enemyModel;
  }

  /**
   * Setter untuk menetapkan entitas enemy.
   * @param enemyModel entitas enemy
   */
  public void setEnemyModel(Enemy enemyModel) {
    this.enemyModel = enemyModel;
  }

  /**
   * Getter Nama Enemy.
   * @return String.
   */
  public String getEnemyName() {
    return enemyModel.getName();
  }

  /**
   * Getter Health dari model enemy.
   * @return int.
   */
  public int getModelHealth() {
    return enemyModel.getCurHealth();
  }

  /**
   * Getter jumlah loot money dari model enemy.
   * @return int.
   */
  public int getModelMoneyLoot() {
    return enemyModel.getMoneyLoot();
  }

  /**
   * Getter status enemy apakah masih hidup atau tidak.
   * @return boolean.
   */
  public boolean getModelIsAlive() {
    return enemyModel.isAlive();
  }

  /**
   * Getter time limit dari entitas boss.
   */
  public void getBossTimeLimit() {
    if (enemyModel.isBoss()) {
      ((BossEnemy) enemyModel).getTimeLimit();
    } else {
      System.out.println("Enemy is not a Boss!");
    }
  }

  /**
   * Dipanggil setelah time limit habis.
   * Mereset CurHealth kembali menjadi maxHealth.
   */
  public void resetBossHealth() {
    if (enemyModel.isBoss()) {
      ((BossEnemy) enemyModel).resetCurHealth();
    }
  }

  /**.
   * Mengkalkulasi health yang dari model yang terkena attack.
   */
  public void calculateModelHealth(int atttackIn) {
    enemyModel.calculateHealth(atttackIn);
  }
}
