package World;

import Enemy.Enemy;
import MainCharacter.Heroes.Hero;
import MainCharacter.Player.Player;
import Stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by Vincent Endrahadi on 4/22/17.
 */
public class KSWorld {
    private Enemy monster;
    private Player player;
    private ArrayList<Hero> hero;
    private int countHero;
    private Stage stages;

    public KSWorld() throws FileNotFoundException{
        player = new Player("Dino");
        hero = new ArrayList<Hero>();
        countHero = 0;
        stages = new Stage();
        monster = stages.getCurEnemy();
    }

    public int getCountHero() {
        return countHero;
    }

    public Stage getStages() {
        return stages;
    }

    public Player getPlayer() {
        return player;
    }

    public Hero getHero(int idx) {
        return hero.get(idx);
    }

    public void addHero (Hero h) {
        hero.add(h);
        countHero++;
    }

    public void setMonster() {
        monster = stages.getCurEnemy();
        player.setEnemy(monster);
        for(int i = 0 ; i < countHero; i++) {
            hero.get(i).setEnemy(monster);
        }
    }

    public void setAllThreadToNull() {
        for(int i = 0 ; i < countHero; i++) {
            hero.get(i).setThreadNull();
        }
        player.setThreadNull();
    }

    public void run() throws FileNotFoundException {
        KSWorld world = new KSWorld();
        Hero h = new Hero("haha",4);
        world.addHero(h);
        int cur = 0;
        while (cur < world.getStages().getGameStage().size()) {
            world.setMonster();
            for(int i = 0 ; i < world.getCountHero(); i++) {
                world.getHero(i).start();
            }
            world.getPlayer().start();

            synchronized (world.getHero(0).getHeroThread()) {
                try {
                    world.getHero(0).getHeroThread().wait();
                    world.getPlayer().plusMoney(world.monster.getMoneyLoot());
                    System.out.println("Money : " + world.player.getMoney());
                    cur++;
                    world.getStages().setCurStage(cur);
                    world.getHero(0).getHeroThread().sleep(10);
                } catch (InterruptedException e) {

                }
            }
            world.setAllThreadToNull();
        }
    }

}
