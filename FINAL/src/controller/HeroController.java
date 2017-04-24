package controller;

import enemy.Enemy;
import maincharacter.hero.Hero;

/**
 * Created by axelinate on 4/23/17.
 */
public class HeroController {
    private Hero HeroModel;

    public HeroController(Hero HeroModel) {
        this.HeroModel = HeroModel;
    }

    public Thread getModelThread() {
        return HeroModel.getHeroThread();
    }

    public String getModelName() {
        return HeroModel.getName();
    }

    public int getModelAttPower() {
        return HeroModel.getAttPower();
    }

    public int getModelLevel() {
        return HeroModel.getLevel();
    }

    public boolean getModelThereIsEbnemy() {
        return HeroModel.getThereIsEnemy();
    }

    public Hero getHeroModel() {
        return HeroModel;
    }

    public void setHeroModel(Hero HeroModel) {
        this.HeroModel = HeroModel;
    }

    public void setModelEnemy(Enemy enemy) {
        HeroModel.setEnemy(enemy);

    }

    public void startModel() {
        HeroModel.start();
    }

    public void setModelThreadNull() {
        HeroModel.setThreadNull();
    }

    public void modelLevelUp() {
        HeroModel.levelUp();
    }
}
