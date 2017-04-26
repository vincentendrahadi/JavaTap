package UnitTest.stageTest;

import enemy.Enemy;
import enemy.RegularEnemy;
import stage.Stage;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by stevannohero on 4/26/17.
 */
public class StageTest {
  @Test
  public void getCurStageTest() throws Exception {
    System.out.print("TESTING GET CURRENT STAGE... ");
    Stage x;
    x = new Stage("stage.txt");
    assertTrue(x.getCurStage() == 0);
    System.out.println("DONE!");
  }

  @Test
  public void getCurEnemy() throws Exception {
    RegularEnemy e = new RegularEnemy(100,"A");
    Stage x = new Stage("stage.txt");
    assertEquals(e.getMaxHealth(),x.getCurEnemy().getMaxHealth());
    assertEquals(e.getName(),x.getCurEnemy().getName());
  }
}
