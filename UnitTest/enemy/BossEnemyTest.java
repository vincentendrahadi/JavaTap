package UnitTest.enemyTest;

import org.junit.Test;
import enemy.BossEnemy;

import static org.junit.Assert.*;

/**
 * Created by stevannohero on 4/26/17.
 */
public class BossEnemyTest {
  @Test
  public void testingBoss() {
    BossEnemy x;

    System.out.print("TESTING CTOR OF BOSSENEMY... ");
    x = new BossEnemy(100,"Boombayah");
    assertTrue(x.getName() == "Boombayah");
    assertTrue(x.isAlive() == true);
    assertTrue(x.getCurHealth() == 100);
    assertTrue(x.getMaxHealth() == 100);
    assertTrue(x.getMoneyLoot() == 100);
    assertTrue(x.isBoss() == true);
    assertTrue(x.getTimeLimit() == 10);
    System.out.println("DONE!");

    System.out.print("TESTING RESET BOSSENEMY CURRENT HEALTH... ");
    x.calculateHealth(50);
    x.resetCurHealth();
    assertTrue(x.getCurHealth() == 100);
    System.out.println("DONE!");

    System.out.print("TESTING CALCULATE BOSSENEMY HEALTH... ");
    x.calculateHealth(50);
    assertTrue(x.getCurHealth() == 50);
    x.resetCurHealth();
    x.calculateHealth(110);
    assertTrue(x.getCurHealth() == 0);
    assertTrue(x.isAlive() == false);
    System.out.println("DONE!");
  }
}
