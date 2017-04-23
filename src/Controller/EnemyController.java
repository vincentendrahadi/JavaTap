package Controller;

import Enemy.Enemy;
import Enemy.BossEnemy;

/**
 * Created by axelinate on 4/23/17.
 */
public class EnemyController {
    private Enemy enemyModel;

    public EnemyController(Enemy enemyModel) {
        this.enemyModel = enemyModel;
    }

    public Enemy getEnemyModel() {
        return enemyModel;
    }

    public String getEnemyName() {
        return enemyModel.getName();
    }

    public int getModelHealth() {
        return enemyModel.getCurHealth();
    }

    public int getModelMoneyLoot() {
        return enemyModel.getMoneyLoot();
    }

    public boolean getModelIsAlive() {
        return enemyModel.isAlive();
    }

    public void getBossTimeLimit() {
        if(enemyModel.isBoss()) {
            ((BossEnemy) enemyModel).getTimeLimit();
        } else {
            System.out.println("Enemy is not a Boss!");
        }
    }

    public void resetBossHealth() {
        if (enemyModel.isBoss()) {
            ((BossEnemy) enemyModel).resetCurHealth();
        }
    }

    public void calculateModelHealth(int atttackIn) {
        enemyModel.calculateHealth(atttackIn);
    }



}
