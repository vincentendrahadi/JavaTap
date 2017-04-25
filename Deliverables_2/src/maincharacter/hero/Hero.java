package maincharacter.hero;

import enemy.BossEnemy;
import enemy.Enemy;
import maincharacter.MainCharacter;

/**
 * <h2>Hero.java</h2>
 * Kelas Hero sebagai model dari HEROES.
 *
 * @author Vincent Endrahadi
 * @since 2017-04-18
 */
public class Hero extends MainCharacter {
  private Thread hero;
  private String threadName;
  private Enemy enemy;
  private int attPower;
  private int level;
  private double attSpeed;

  /**
   * Konstruktor Hero dengan parameter nama dan prioritas dari thread.
   * @param name Nama dari Hero.
   * @param attSpeed Kecepatan hero dalam menyerang musuh.
   */
  public Hero(String name, int attPower, double attSpeed) {
    threadName = name;
    level = 0;
    this.attPower = attPower;
    thereIsEnemy = false;
    this.attSpeed = attSpeed;
  }

  public String getThreadName() {
    return threadName;
  }

  /**
   * Getter untuk thread hero.
   *
   * @return Thread Mengembalikan Thread dari hero
   */
  public Thread getHeroThread() {
    return hero;
  }

  /**
   * Getter untuk level hero.
   *
   * @return int Level dari hero.
   */
  @Override
  public int getLevel() {
    return level;
  }

  /**
   * Getter untuk attack power hero.
   *
   * @return int Attack Power dari hero.
   */
  @Override
  public int getAttPower() {
    return attPower;
  }

  /**
   * Getter untuk mengetahui apakah terdapat musuh.
   *
   * @return boolean Keberadaan enemy.
   */
  @Override
  public boolean getThereIsEnemy() {
    return thereIsEnemy;
  }

  /**
   * Setter untuk attack power
   * menambahkan attPower ke attPower yang telah ada.
   *
   * @param attPower AttacK Power
   */
  @Override
  public void setAttPower(int attPower) {
    this.attPower = attPower;
  }

  /**
   * Setter untuk memberi keadaan keberadaan enemy.
   *
   * @param thereIsEnemy apakah terdapat musuh
   */
  @Override
  public void setThereIsEnemy(boolean thereIsEnemy) {
    this.thereIsEnemy = thereIsEnemy;
  }

  /**
   * Setter untuk musuh dari yang sedang dihadapi.
   *
   * @param enemy enemy yang sedang dihadapi.
   */
  public void setEnemy(Enemy enemy) {
    this.enemy = enemy;
    thereIsEnemy = true;
  }

  /**
   * Setter untuk thread hero menjadi null.
   */
  public void setThreadNull() {
    hero = null;
  }

  /**
   * Override dari kelas Thread.
   * Menjalankan thread
   * Hero akan attack setiap beberapa waktu.
   */
  public void run() {
    try {
      synchronized (this) {
        while (thereIsEnemy) {
          if (enemy.isBoss()) {
            long start = System.currentTimeMillis();
            long end = start + ((BossEnemy) enemy).getTimeLimit() * 1000;
            while (System.currentTimeMillis() < end) {
              if (enemy.getCurHealth() > 0) {
                enemy.calculateHealth(attPower);
              } else {
                thereIsEnemy = false;
                notify();
                break;
              }
              hero.sleep(500);
            }
            System.out.println("Your Time is Up, Please Try Again!");
            ((BossEnemy) enemy).resetCurHealth();
          } else {
            long start = System.currentTimeMillis();
            long end = start + 30 * 1000;
            while (System.currentTimeMillis() < end) {
              if (enemy.getCurHealth() > 0) {
                enemy.calculateHealth(attPower);
              } else {
                thereIsEnemy = false;
                notify();
                break;
              }
              hero.sleep(500);
            }
          }
        }
      }
    } catch (InterruptedException e) {
      System.out.println("Hero Interrupted");
    }
  }

  /**
   * Override dari Thread.
   * Menginisiasi Thread yang awalnya null.
   */
  public void start() {
    if (hero == null) {
      hero = new Thread(this, threadName);
      hero.start();
    }
  }

  /**
   * Menyerang musuh dengan attPower yang ada.
   */
  public void attack(Enemy e) {
    e.calculateHealth(attPower);
  }

  /**
   * Menaikkan level dari pemain sejumlah 1.
   */
  public void levelUp() {
    level++;
  }
}
