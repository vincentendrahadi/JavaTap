package controller;

import enemy.Enemy;

import java.io.FileNotFoundException;

import maincharacter.hero.Hero;
import maincharacter.player.Player;
import stage.Stage;
import world.World;

/**
 * <h2>GameplayController.java</h2>
 * Kelas GameplayController sebagai control dari Entitas-entitas.
 *
 * @author axelinate
 * @since 2017-04-23
 */
public class GameplayController {
  private World worldModel;

  /**
   * Konstruktor untuk GameplayController.
   * @param worldModel entitas model yang dimiliki world.
   */
  public GameplayController(World worldModel) {
    this.worldModel = worldModel;
  }

  /**
   * Getter jumlah hero yang ada.
   * @return int.
   */
  public int getWorldHeroCount() {
    return worldModel.getCountHero();
  }

  /**
   * Getter entitas player.
   * @return Player.
   */
  public Player getWorldPlayer() {
    return worldModel.getPlayer();
  }

  /**
   * Getter entitas hero.
   * @param idx indeks.
   * @return Hero.
   */
  public Hero getWorldHero(int idx) {
    return worldModel.getHero(idx);
  }

  /**
   * Getter entitas stage.
   * @return Stage.
   */
  public Stage getWorldStage() {
    return worldModel.getStages();
  }

  /**
   * Getter entitas enemy.
   * @return Enemy.
   */
  public Enemy getWorldCurEnemy() {
    return worldModel.getStages().getCurEnemy();
  }

  /**
   * Menambah Hero ke entitas world.
   */
  public void addWorldHero() {
    worldModel.addHero();
  }

  /**
   * Setter entitas enemy.
   */
  public void setWorldMonster() {
    worldModel.setMonster();
  }

  /**
   * Setter value thread menjadi null.
   */
  public void setWorldThreadToNull() {
    worldModel.setAllThreadToNull();
  }

  /**
   * menjalankan world.
   * @throws FileNotFoundException jika file tidak ditemukan.
   */
  public void runWorld() throws FileNotFoundException {
    worldModel.run();
  }
}