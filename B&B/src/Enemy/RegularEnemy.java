package Enemy;



/**
 * Created by Vincent Endrahadi on 4/22/17.
 */
public class RegularEnemy extends Enemy {

    public RegularEnemy(int max, String name) {
        boss = false;
        maxHealth = max;
        curHealth = maxHealth;
        alive = true;
        this.name = name;
        moneyLoot = maxHealth;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isAlive() {
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

    @Override
    public void calculateHealth(int attackIn) {
        curHealth -= attackIn;
        if (curHealth <= 0) {
            alive = false;
        }
    }


}
