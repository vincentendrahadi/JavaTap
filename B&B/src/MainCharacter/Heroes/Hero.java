package MainCharacter.Heroes;

import Enemy.Enemy;
import MainCharacter.MainCharacter;

import java.util.Scanner;

/**
 * Created by Vincent Endrahadi on 4/22/17.
 */
public class Hero extends MainCharacter {
    private Thread hero;
    private String threadName;
    private Enemy enemy;
    private int attPower;
    private int level;

    public Hero(String name) {
        threadName = name;
        level = 0;
        attPower = 5;
        thereIsEnemy = false ;
    }

    public Thread getHero() {
        return hero;
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

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void setThreadNull() {
        hero = null;
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {
            synchronized (this) {
                while (thereIsEnemy) {
                    if (enemy.getCurHealth() > 0) {
                        enemy.calculateHealth(10);
                        System.out.println("Enemy : " + enemy.getName());
                        System.out.println("Enemy : " + enemy.getCurHealth());
                        hero.sleep(2000);
                    } else thereIsEnemy = false;
                }
                notify();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }

        System.out.println("Thread " +  threadName + " exiting.");

    }

    public void start() {
        if (hero == null) {
            hero = new Thread (this,threadName);
            hero.start();
        }
    }

    public int attack() {
        return attPower;
    }

    public void levelUp() {
        level++;
    }
}
