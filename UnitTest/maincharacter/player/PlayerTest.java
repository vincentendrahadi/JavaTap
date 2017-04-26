package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import enemy.RegularEnemy;
import maincharacter.player.Player;
import org.junit.jupiter.api.Test;

/**
 * Created by Vincent Endrahadi on 4/26/17.
 */
public class PlayerTest {
  
  @Test
  public void getLevel() throws Exception {
    Player h = new Player("asd");
    assertEquals(0, h.getLevel());
    h.levelUp();
    assertEquals(1, h.getLevel());
  }
  
  @Test
  public void getAttPower() throws Exception {
    Player h = new Player("asd");
    assertEquals(5, h.getAttPower());
    h.levelUp();
    assertEquals(20, h.getAttPower());
  }
  
  @Test
  public void getThereIsEnemy() {
    Player h = new Player("Player");
    RegularEnemy e = new RegularEnemy(10, "adfsa");
    assertEquals(false, h.getThereIsEnemy());
    h.setEnemy(e);
    assertEquals(true, h.getThereIsEnemy());
  }
  
  @Test
  public void attackEnemy() {
    RegularEnemy e = new RegularEnemy(100, "aaa");
    Player h = new Player("AAA");
    h.attack(e);
    assertEquals(95, e.getCurHealth());
  }
  
}
