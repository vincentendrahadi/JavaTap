package Enemy;

/**
 * Created by Vincent Endrahadi on 4/22/17.
 */
public class BossEnemy extends Enemy {
    private int timeLimit;
    private boolean boss = true;

    public BossEnemy(int max, String name) {
        alive = true;
        this.name = name;
        maxHealth = max;
        curHealth = maxHealth;
        moneyLoot = maxHealth;
        timeLimit = 10;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isAlive() {
        if(alive == false) {
            System.out.println("TOD");
        }
        return alive;
    }

    @Override
    public int getCurHealth() {
        return curHealth;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public int getMoneyLoot() {
        return moneyLoot;
    }

    @Override
    public boolean isBoss() {
        return boss;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void resetCurHealth() {
        curHealth = maxHealth;
    }

    @Override
    public void calculateHealth(int attackIn) {
        curHealth -= attackIn;
        if (curHealth <= 0) {
            alive = false;
            System.out.println("JING");
        }
    }

}
