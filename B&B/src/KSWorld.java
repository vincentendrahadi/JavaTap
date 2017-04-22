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
            System.out.println("test");
            world.setMonster();
            if (world.getMonster().isBoss()) {
                while (world.getMonster().isAlive()) {
                    System.out.println("alive");
                    long start = System.currentTimeMillis();
                    long end = start + ((BossEnemy) world.getMonster()).getTimeLimit() * 1000 ;
                    boolean endwhile = true;
                    while (endwhile && System.currentTimeMillis() < end) {
                        if (world.getMonster().isAlive()) {
                            try {
                                System.out.println("A");
                                world.getPlayer().setMoney(world.getMonster().getMoneyLoot());
                                System.out.println(world.getPlayer().getMoney());
                                world.setThreadToNull();
                                endwhile = false;
                            } catch (Exception e) {

                            }
                        }
                        world.getHero().start();
                        world.getPlayer().start();
                    }
                    if (world.getMonster().isAlive()){
                        System.out.println("Your Time is Up, Please Try Again or Buy PowerUp From Shop");
                        ((BossEnemy) world.getMonster()).resetCurHealth();
                    } else {
                        cur++;
                        world.getStages().setCurStage(cur);
                        world.setThreadToNull();
                        System.out.println("die");
                    }
                }
            } else {
                world.getHero().start();
                world.getPlayer().start();
                synchronized (world.getHero().getHero()) {
                    try {
                        world.getHero().getHero().wait();
                        world.getPlayer().setMoney(world.monster.getMoneyLoot());
                        System.out.println(world.player.getMoney());
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
}
