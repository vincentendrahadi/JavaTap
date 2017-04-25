package enemy;

import enemy.Enemy;

/**
 * Created by Vincent Endrahadi on 4/22/17.
 */
public class BossEnemy extends Enemy {
  private int timeLimit;
  private boolean boss = true;

  /**
   * Konstruktor untuk BossEnemy.
   * @param max MaxHealth yang dimiliki Boss.
   * @param name nama dari Boss.
   */
  public BossEnemy(int max, String name) {
    alive = true;
    this.name = name;
    maxHealth = max;
    curHealth = maxHealth;
    moneyLoot = maxHealth;
    timeLimit = 10;
  }

  /**
   * Getter Nama Boss.
   * @return String.
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Getter apakah Boss masih hidup.
   * @return Boolean.
   */
  @Override
  public boolean isAlive() {
    return alive;
  }

  /**
   * Getter Current Health.
   * @return int.
   */
  @Override
  public int getCurHealth() {
    return curHealth;
  }

  /**
   * Getter Health Maximum.
   * @return int.
   */
  @Override
  public int getMaxHealth() {
    return maxHealth;
  }

  /**
   * Getter Uang yand dibawa Boss.
   * @return int.
   */
  @Override
  public int getMoneyLoot() {
    return moneyLoot;
  }

  /**
   * Getter Apakah Merupakan Boss.
   * @return boolean.
   */
  @Override
  public boolean isBoss() {
    return boss;
  }

  /**
   * Getter untuk time limit dalam menghadapi boss.
   * @return int.
   */
  public int getTimeLimit() {
    return timeLimit;
  }

  /**
   * Dipanggil setelah time limit habis
   * Mereset CurHealth kembali menjadi maxHealth.
   */
  public void resetCurHealth() {
    curHealth = maxHealth;
  }

  /**
   * Menghitung darah tersisa setelah terdapat attack yang masuk.
   * @param attackIn jumlah attack yang masuk.
   */
  @Override
  public void calculateHealth(int attackIn) {
    curHealth -= attackIn;
    if (curHealth <= 0) {
      curHealth = 0;
      alive = false;
    }
  }

}
