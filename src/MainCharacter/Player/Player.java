package MainCharacter.Player;

import Enemy.RegularEnemy;
import Enemy.Enemy;
import MainCharacter.MainCharacter;

import java.util.Scanner;
/**
 * Created by Vincent Endrahadi on 4/18/17.
 */
public class Player extends MainCharacter {
    private Thread player;
    private String threadName;
    private Enemy enemy;
    private int attPower;
    private int level;
    private int money;

    public Player(String name) {
        threadName = name;
        level = 0;
        money = 0;
        attPower = 5;
        thereIsEnemy = false ;
    }

    public Thread getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getAttPower() {
        return attPower;
    }

    @Override
    public boolean getThereIsEnemy() {
        return thereIsEnemy;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public void setAttPower(int attPower) {
        this.attPower = attPower;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void setThereIsEnemy(boolean thereIsEnemy) {
        this.thereIsEnemy = thereIsEnemy;
    }

    public void setMoney(int money) {
        this.money += money;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void setThreadNull() {
        player = null;
    }

    public void run() {
            try {
                while (thereIsEnemy) {
                    if (enemy.getCurHealth() > 0) {
                        Scanner scan = new Scanner(System.in);
                        char CC = scan.next().charAt(0);
                        enemy.calculateHealth(100);
                        setMoney(100);
                        System.out.println("Enemy : " + enemy.getName());
                        System.out.println("Enemy : " + enemy.getCurHealth());
                        player.sleep(100);
                    } else thereIsEnemy = false;
                }
            } catch (InterruptedException e) {

            }
    }

    public void start() {
        if (player == null) {
           player = new Thread (this,threadName);
           player.setPriority(10);
           player.start();
        }
    }

    public int attack() {
        return attPower;
    }

    public void levelUp() {
        level++;
    }
}
