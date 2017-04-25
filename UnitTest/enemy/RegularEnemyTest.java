package UnitTest.enemyTest;

import enemy.RegularEnemy;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by stevannohero on 4/26/17.
 */
public class RegularEnemyTest {
  @Test
  public void TestingRegEnemy() {
    RegularEnemy x;

    System.out.print("TESTING CTOR OF REGULAR ENEMY... ");
    x = new RegularEnemy(100,"Boombayah");
    assertTrue(x.getName() == "Boombayah");
    assertTrue(x.isAlive() == true);
    assertTrue(x.getCurHealth() == 100);
    assertTrue(x.getMaxHealth() == 100);
    assertTrue(x.getMoneyLoot() == 100);
    assertTrue(x.isBoss() == false);
    System.out.println("DONE!");

    System.out.print("TESTING CALCULATE REGULAR ENEMY'S HEALTH... ");
    x.calculateHealth(50);
    assertTrue(x.getCurHealth() == 50);
    x.setCurHealth(100);
    x.calculateHealth(110);
    assertTrue(x.getCurHealth() == 0);
    assertTrue(x.isAlive() == false);
    System.out.println("DONE!");
  }
}
