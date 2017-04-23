package MainCharacter.Player;

import Enemy.BossEnemy;
import Enemy.Enemy;
import MainCharacter.MainCharacter;

import java.util.Scanner;
/**
 * <h2>Player.java</h2>
 * Kelas Player sebagai model dari pemain.
 *
 * @author  Vincent Endrahadi
 * @since   2017-04-18
 */
public class Player extends MainCharacter {
    private Thread player;
    private String threadName;
    private Enemy enemy;
    private int attPower;
    private int level;
    private int money;

    /**
     * Konstruktor untuk kelas Player dengan parameter nama.
     * @param name Nama dari Player.
     */
    public Player(String name) {
        threadName = name;
        level = 0;
        money = 0;
        attPower = 5;
        thereIsEnemy = false ;
    }

    /**
     * Getter untuk thread player.
     * @return Thread Mengembalikan Thread dari Player
     */
    public Thread getPlayerThread() {
        return player;
    }

    /**
     * Getter untuk level player.
     * @return int Level dari player.
     */
    @Override
    public int getLevel() {
        return level;
    }

    /**
     * Getter untuk attack power player.
     * @return int Attack Power dari Player.
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
     * Getter untuk jumlah money yang dimiliki pemain.
     * @return int Money dari pemain.
     */
    public int getMoney() {
        return money;
    }

    /**
     * Setter untuk attack power
     * menambahkan attPower ke attPower yang telah ada.
     * @param attPower AttacK Power
     */
    @Override
    public void setAttPower(int attPower) {
        this.attPower += attPower;
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
     * Setter untuk money
     * Menambah jumlah money yang telah ada.
     * @param money
     */
    public void plusMoney(int money) {
        this.money += money;
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
     * Setter untuk thread player menjadi null.
     */
    public void setThreadNull() {
        player = null;
    }

    /**
     * Override dari kelas Thread.
     * Menjalankan thread
     * Player akan attack setiap ada Input dari user
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
                                    Scanner scan = new Scanner(System.in);
                                    char CC = scan.next().charAt(0);
                                    enemy.calculateHealth(100);
                                    plusMoney(100);
                                    System.out.println("Enemy : " + enemy.getName());
                                    System.out.println("Enemy : " + enemy.getCurHealth());
                                    player.sleep(10);
                                } else {
                                    thereIsEnemy = false;
                                    setThreadNull();
                                    notify();
                                    break;
                                }
                            }
                            if (enemy.isAlive()) {
                                System.out.println("Your Time is Up, Please Try Again!");
                                ((BossEnemy) enemy).resetCurHealth();
                            }
                        } else {
                            if (enemy.getCurHealth() > 0) {
                                Scanner scan = new Scanner(System.in);
                                char CC = scan.next().charAt(0);
                                enemy.calculateHealth(100);
                                System.out.println("Enemy : " + enemy.getName());
                                System.out.println("Enemy : " + enemy.getCurHealth());
                                player.sleep(100);
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
        if (player == null) {
           player = new Thread (this,threadName);
           player.setPriority(10);
           player.start();
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
