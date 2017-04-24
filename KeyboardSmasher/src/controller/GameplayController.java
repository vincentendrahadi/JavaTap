package controller;


import enemy.Enemy;
import maincharacter.hero.Hero;
import maincharacter.player.Player;
import stage.Stage;
import world.World;

import java.io.FileNotFoundException;

/**
 * Created by axelinate on 4/23/17.
 */
public class GameplayController {
    private World worldModel;

    public GameplayController(World worldModel) {
        this.worldModel = worldModel;
    }

    public int getWorldHeroCount() {
        return worldModel.getCountHero();
    }

    public Player getWorldPlayer() {
        return worldModel.getPlayer();
    }

    public Hero getWorldHero(int idx) {
        return worldModel.getHero(idx);
    }

    public Stage getWorldStage() {
        return worldModel.getStages();
    }

    public Enemy getWorldCurEnemy() {
        return worldModel.getStages().getCurEnemy();
    }
    public void addWorldHero(Hero h) {
        worldModel.addHero(h);
    }

    public void setWorldMonster() {
        worldModel.setMonster();
    }

    public void setWorldThreadToNull() {
        worldModel.setAllThreadToNull();
    }

    public void runWorld() throws FileNotFoundException {
        worldModel.run();
    }
}