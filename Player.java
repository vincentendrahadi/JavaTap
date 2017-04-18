/**
 * Created by Vincent Endrahadi on 4/18/17.
 */
public class Player implements AttGenerator, LevelUpdater {
    private int attPower;
    private int level;
    private int money;

    public getLevel() {
        return level;
    }

    public getMoney() {
        return money;
    }

    public getAttPower() {
        return attPower;
    }

    public void setAttPower(int attPower) {
        this.attPower = attPower;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public int attack() {
        return attPower;
    }

    @Override
    public void levelUp() {
        level++;
    }
}
