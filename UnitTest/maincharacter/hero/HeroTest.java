package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import enemy.Enemy;
import enemy.RegularEnemy;
import maincharacter.hero.Hero;
import org.junit.jupiter.api.Test;

/**
 * Created by Vincent Endrahadi on 4/26/17.
 */
public class HeroTest {
  @Test
  public void getThreadName() throws Exception {
    Hero h = new Hero("Nama", 5, 10);
    assertEquals("Nama", h.getThreadName());
  }
  
  @Test
  public void getLevel() throws Exception{
    Hero h = new Hero("asd", 5, 10);
    assertEquals(0,h.getLevel());
    h.levelUp();
    assertEquals(1, h.getLevel());
  }
  
  @Test
  public void getAttPower() throws Exception{
    Hero h = new Hero("asd", 10 ,12);
    assertEquals(10,h.getAttPower());
    h.levelUp();
    assertEquals(15, h.getAttPower());
  }
  
  @Test
  public void getThereIsEnemy() {
    Hero h = new Hero("hero", 5, 10);
    RegularEnemy e = new RegularEnemy(10,"adfsa");
    assertEquals(false, h.getThereIsEnemy());
    h.setEnemy(e);
    assertEquals(true,h.getThereIsEnemy());
  }
  
  @Test
  public void attackEnemy() {
    RegularEnemy e = new RegularEnemy(100,"aaa");
    Hero h = new Hero("AAA", 10, 10);
    
    h.attack(e);
    assertEquals(90,e.getCurHealth());
  }
  
  @Test
  public void threadHero() throws Exception {
    RegularEnemy e = new RegularEnemy(30,"Godzilla");
    Hero h = new Hero("Superman", 10,10);
    h.setEnemy(e);
    h.run();
    assertEquals(0,e.getCurHealth());
  }
}
