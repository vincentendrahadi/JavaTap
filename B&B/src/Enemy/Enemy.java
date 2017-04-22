package Enemy;

/**
 * Created by Vincent Endrahadi on 4/22/17.
 */
public abstract class Enemy  {
    protected String name;
    protected int curHealth;
    protected int maxHealth;
    protected boolean alive;
    protected boolean boss;
    protected int moneyLoot;

    public abstract String getName();

    public abstract int getCurHealth();

    public abstract int getMaxHealth();

    public abstract boolean isAlive();

    public abstract int getMoneyLoot();

    public abstract boolean isBoss();

    public abstract void calculateHealth (int attackIn);
}
