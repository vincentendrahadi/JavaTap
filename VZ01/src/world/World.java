package world;

import enemy.BossEnemy;
import enemy.Enemy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import enemy.RegularEnemy;
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
  public World(Player p, ArrayList<Hero> list, Stage stages) throws FileNotFoundException {
    Hero h;
    player = p;
    hero = list;
    this.stages = stages;
    countHero = 0;
    Scanner file = new Scanner (new File("hero.txt"));
    String line;
    int power;
    double speed;
    String name;

    while (file.hasNextLine()) {
      line = file.nextLine();
      String[] temp = line.split(" ");
      name = temp[0];
      power = Integer.parseInt(temp[1]);
      speed = Double.parseDouble(temp[2]);
      h = new Hero(name, power, speed);
      list.add(h);
    }

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
  public void addHero() {
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
    int cur = 0;
    while (cur < getStages().getGameStage().size()) {
      setMonster();
      for (int i = 0; i < getCountHero(); i++) {
        getHero(i).start();
      }
      getPlayer().start();

      synchronized (getHero(0).getHeroThread()) {
        try {
          getHero(0).getHeroThread().wait();
          getPlayer().plusMoney(monster.getMoneyLoot());
          System.out.println("Money : " + getPlayer().getMoney());
          cur++;
          getStages().setCurStage(cur);
          getHero(0).getHeroThread().sleep(10);
        } catch (InterruptedException e) {
          System.out.println("World Interrupted");
        }
      }
      setAllThreadToNull();
    }
  }

}
