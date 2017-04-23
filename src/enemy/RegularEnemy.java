package enemy;


/**
 * Created by Vincent Endrahadi on 4/22/17.
 */
public class RegularEnemy extends Enemy {
  /**
   * Konstruktor untuk regular Enemy.
   * @param max maxHealth dari enemy.
   * @param name nama dari enemy.
   */
  public RegularEnemy(int max, String name) {
    boss = false;
    maxHealth = max;
    curHealth = maxHealth;
    alive = true;
    this.name = name;
    moneyLoot = maxHealth;
  }

  /**
   * Getter Nama Boss.
   *
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
