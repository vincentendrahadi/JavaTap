package enemy;

/**
 * Created by Vincent Endrahadi on 4/22/17.
 */
public abstract class Enemy {
  protected String name;
  protected int curHealth;
  protected int maxHealth;
  protected boolean alive;
  protected boolean boss;
  protected int moneyLoot;

  /**
   * Getter Nama Boss.
   * @return String.
   */
  public abstract String getName();

  /**
   * Getter Current Health.
   * @return int.
   */
  public abstract int getCurHealth();

  /**
   * Getter Health Maximum.
   * @return int.
   */
  public abstract int getMaxHealth();

  /**
   * Getter apakah Boss masih hidup.
   * @return Boolean.
   */
  public abstract boolean isAlive();

  /**
   * Getter Uang yand dibawa Boss.
   * @return int.
   */
  public abstract int getMoneyLoot();

  /**
   * Getter Apakah Merupakan Boss.
   * @return boolean.
   */
  public abstract boolean isBoss();

  /**
   * Menghitung darah tersisa setelah terdapat attack yang masuk.
   * @param attackIn jumlah attack yang masuk.
   */
  public abstract void calculateHealth(int attackIn);
}
