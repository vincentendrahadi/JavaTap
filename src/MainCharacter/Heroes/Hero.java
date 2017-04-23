package MainCharacter.Heroes;

import Enemy.Enemy;
import Enemy.BossEnemy;
import MainCharacter.MainCharacter;

/**
 * <h2>hERO.java</h2>
 * Kelas hERO sebagai model dari HEROES.
 *
 * @author  Vincent Endrahadi
 * @since   2017-04-18
 */
public class Hero extends MainCharacter {
    private Thread hero;
    private String threadName;
    private Enemy enemy;
    private int attPower;
    private int level;
    private int priority;

    public Hero(String name, int prio) {
        threadName = name;
        level = 0;
        attPower = 5;
        thereIsEnemy = false ;
        priority = prio;
    }

    /**
     * Getter untuk thread hero.
     * @return Thread Mengembalikan Thread dari hero
     */
    public Thread getHeroThread() {
        return hero;
    }

    /**
     * Getter untuk level hero.
     * @return int Level dari hero.
     */
    @Override
    public int getLevel() {
        return level;
    }
    
    /**
     * Getter untuk attack power hero.
     * @return int Attack Power dari hero.
     */
    @Override
    public int getAttPower() {
        return attPower;
    }

    /**
     * Getter untuk mengetahui apakah terdapat musuh.
     * @return boolean Keberadaan enemy.
     */
    @Override
    public boolean getThereIsEnemy() {
        return thereIsEnemy;
    }

    /**
     * Setter untuk attack power
     * menambahkan attPower ke attPower yang telah ada.
     * @param attPower AttacK Power
     */
    @Override
    public void setAttPower(int attPower) {
        this.attPower = attPower;
    }

    /**
     * Setter untuk memberi keadaan keberadaan enemy.
     * @param thereIsEnemy apakah terdapat musuh
     */
    @Override
    public void setThereIsEnemy(boolean thereIsEnemy) {
        this.thereIsEnemy = thereIsEnemy;
    }

    /**
     * Setter untuk musuh dari yang sedang dihadapi.
     * @param enemy
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
                        long end = start + ((BossEnemy) enemy).getTimeLimit() * 1000 ;
                        while (System.currentTimeMillis() < end) {
                            if (enemy.getCurHealth() > 0) {
                                enemy.calculateHealth(10);
                                System.out.println("Enemy : " + enemy.getName());
                                System.out.println("Enemy : " + enemy.getCurHealth());
                                hero.sleep(2000);
                            } else {
                                thereIsEnemy = false;
                                notify();
                                break;

                            }
                        }
                        System.out.println("Your Time is Up, Please Try Again!");
                        ((BossEnemy) enemy).resetCurHealth();
                    } else {
                        if (enemy.getCurHealth() > 0) {
                            enemy.calculateHealth(10);
                            System.out.println("Enemy : " + enemy.getName());
                            System.out.println("Enemy : " + enemy.getCurHealth());
                            hero.sleep(2000);
                        } else thereIsEnemy = false;
                        notify();
                    }
                }
            }
        } catch (InterruptedException e) {

        }

    }
    
    /**
     * Override dari Thread.
     * Menginisiasi Thread yang awalnya null.
     */
    public void start() {
        if (hero == null) {
            hero = new Thread (this,threadName);
            hero.setPriority(priority);
            hero.start();
        }
    }

    /**
     * Menyerang musuh dengan attPower yang ada.
     * @return int Attack yang dihasilkan.
     */
    public int attack() {
        return attPower;
    }

    /**
     * Menaikkan level dari pemain sejumlah 1.
     */
    public void levelUp() {
        level++;
    }
}
