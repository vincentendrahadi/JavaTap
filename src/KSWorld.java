import Enemy.Enemy;
import Enemy.BossEnemy;
import MainCharacter.Heroes.Hero;
import MainCharacter.Player.Player;

import java.io.FileNotFoundException;

/**
 * Created by Vincent Endrahadi on 4/22/17.
 */
public class KSWorld {
    private Enemy monster;
    private Player player;
    private Hero hero;
    private Stage stages;

    public KSWorld() throws FileNotFoundException{
        player = new Player("Dino");
        hero = new Hero("Noob");
        stages = new Stage();
        monster = stages.getCurEnemy();
    }

    public Enemy getMonster() {
        return monster;
    }

    public Stage getStages() {
        return stages;
    }

    public Player getPlayer() {
        return player;
    }

    public Hero getHero() {
        return hero;
    }

    public void setMonster() {
        monster = stages.getCurEnemy();
        player.setEnemy(monster);
        player.setThereIsEnemy(true);
        hero.setEnemy(monster);
        hero.setThereIsEnemy(true);
    }

    public void setThreadToNull() {
        hero.setThreadNull();
        player.setThreadNull();
    }

    public static void main(String[] args) throws FileNotFoundException {
        KSWorld world = new KSWorld();
        int cur = 0;
        while (world.getStages().getGameStage().get(cur) != null) {
            world.setMonster();
            world.getHero().start();
            world.getPlayer().start();
            synchronized (world.getHero().getHero()) {
                try {
                    world.getHero().getHero().wait();
                    world.getPlayer().setMoney(world.monster.getMoneyLoot());
                    System.out.println("Money : " + world.player.getMoney());
                    cur++;
                    world.getStages().setCurStage(cur);
                    world.getHero().getHero().sleep(10);
                } catch (InterruptedException e) {

                }
            }
            world.setThreadToNull();
        }
    }

}
