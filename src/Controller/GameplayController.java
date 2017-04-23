package Controller;


import maincharacter.hero.Hero;
import maincharacter.player.Player;
import world.KSWorld;

import java.io.FileNotFoundException;

/**
 * Created by axelinate on 4/23/17.
 */
public class GameplayController {
    private KSWorld worldModel;

    public GameplayController(KSWorld worldModel) {
        this.worldModel = worldModel;
    }

    public KSWorld getWorldModel() {
        return worldModel;
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
