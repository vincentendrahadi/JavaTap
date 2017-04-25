package controller;

import enemy.Enemy;
import maincharacter.hero.Hero;

/**
 * <h2>HeroController.java</h2>
 * Kelas HeroController sebagai control dari HERO.
 *
 * @author axelinate
 * @since 2017-04-23
 */
public class HeroController {
  private Hero heroModel;

  /**
   * Konstruktor untuk HeroController.
   * @param heroModel entitas model yang dimiliki hero.
   */
  public HeroController(Hero heroModel) {
    this.heroModel = heroModel;
  }

  /**
   * Getter Thread yang berurusan dengan entitas hero.
   * @return Thread.
   */
  public Thread getModelThread() {
    return heroModel.getHeroThread();
  }

  /**
   * Getter nama hero.
   * @return String.
   */
  public String getModelName() {
    return heroModel.getName();
  }

  /**
   * Getter attack power dari hero.
   * @return int.
   */
  public int getModelAttPower() {
    return heroModel.getAttPower();
  }

  /**
   * Getter level dari hero.
   * @return int.
   */
  public int getModelLevel() {
    return heroModel.getLevel();
  }

  /**
   * Getter status ada atau tidaknya enemy.
   * @return boolean.
   */
  public boolean getModelThereIsEnemy() {
    return heroModel.getThereIsEnemy();
  }

  /**
   * Getter entitas hero.
   * @return Hero.
   */
  public Hero getHeroModel() {
    return heroModel;
  }

  /**
   * Setter entitas Hero.
   * @param heroModel .
   */
  public void setHeroModel(Hero heroModel) {
    this.heroModel = heroModel;
  }

  /**
   * Setter entitas enemy.
   * @param enemy .
   */
  public void setModelEnemy(Enemy enemy) {
    heroModel.setEnemy(enemy);
  }

  /**
   * memulai prosedur start.
   */
  public void startModel() {
    heroModel.start();
  }

  /**
   * Setter thread hero menjadi null.
   */
  public void setModelThreadNull() {
    heroModel.setThreadNull();
  }

  /**
   * Menambah level pada hero.
   */
  public void modelLevelUp() {
    heroModel.levelUp();
  }
}