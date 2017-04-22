package MainCharacter;

/**
 * Created by Vincent Endrahadi on 4/22/17.
 */
public abstract class MainCharacter extends Thread {
    protected int attPower;
    protected int level;
    protected boolean thereIsEnemy;

    public abstract boolean getThereIsEnemy();
    public abstract void setThereIsEnemy(boolean thereIsEnemy);

    public abstract int getAttPower();
    public abstract void setAttPower(int attPower);

    public abstract int getLevel();
    public abstract void setLevel(int level);

    public abstract int attack();
    public abstract void levelUp();
}
