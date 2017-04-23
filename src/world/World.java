package world;

import enemy.Enemy;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import maincharacter.hero.Hero;
import maincharacter.player.Player;
import stage.Stage;


/**
 * Created by Vincent Endrahadi on 4/22/17.
 */
public class World {
  private Enemy monster;
  private Player player;
  private ArrayList<Hero> hero;
  private int countHero;
  private Stage stages;

  /**
   * Kosntruktor World.
   * @throws FileNotFoundException jika file tidak ketemu.
   */
  public World() throws FileNotFoundException {
    player = new Player("Dino");
    hero = new ArrayList<Hero>();
    countHero = 0;
    stages = new Stage();
    monster = stages.getCurEnemy();
  }

  /**
   * Getter Jumlah Hero
   * @return int.
   */
  public int getCountHero() {
    return countHero;
  }

  /**
   * Getter Stage dari game.
   * @return Stage.
   */
  public Stage getStages() {
    return stages;
  }

  /**
   * Getter Player.
   * @return Player.
   */
  public Player getPlayer() {
    return player;
  }

  /**
   * Getter Hero.
   * @param idx index untuk list hero.
   * @return Hero.
   */
  public Hero getHero(int idx) {
    return hero.get(idx);
  }

  /**
   * Menambah Hero ke List
   * @param h Hero yang akan dimasukkan.
   */
  public void addHero(Hero h) {
    hero.add(h);
    countHero++;
  }

  /**
   * Setter monster untuk player dan hero.
   */
  public void setMonster() {
    monster = stages.getCurEnemy();
    player.setEnemy(monster);
    for (int i = 0; i < countHero; i++) {
      hero.get(i).setEnemy(monster);
    }
  }

  /**
   * Setter semua thread menjadi null.
   */
  public void setAllThreadToNull() {
    for (int i = 0; i < countHero; i++) {
      hero.get(i).setThreadNull();
    }
    player.setThreadNull();
  }

  /**
   * Menjalankan game.
   * @throws FileNotFoundException jika file tidak ditemukan.
   */
  public void run() throws FileNotFoundException {
    World world = new World();
    Hero h = new Hero("haha", 4);
    world.addHero(h);
    int cur = 0;
    while (cur < world.getStages().getGameStage().size()) {
      world.setMonster();
      for (int i = 0; i < world.getCountHero(); i++) {
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
          System.out.println("World Interrupted");
        }
      }
      world.setAllThreadToNull();
    }
  }

}
