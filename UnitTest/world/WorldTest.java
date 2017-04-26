package UnitTest.worldTest;

import maincharacter.hero.Hero;
import maincharacter.player.Player;
import org.junit.Test;

import static org.junit.Assert.*;

import stage.Stage;
import world.World;
import maincharacter.hero.Hero;
import maincharacter.player.Player;

import java.util.ArrayList;

/**
 * Created by stevannohero on 4/26/17.
 */
public class WorldTest {
  @Test
  public void getterTest()throws Exception {
    World w;
    Hero h = new Hero("Joy",0,0.5);
    Player p = new Player(":asda");
    ArrayList<Hero> ar = new ArrayList<>();
    Stage stages = new Stage("stage.txt");
    w = new World(p, ar, stages);
    assertTrue(w.getCountHero() == 0);
    assertTrue(w.getPlayer() == p);
    assertEquals(w.getHero(0),h);
    w.addHero();
    assertEquals(1,w.getCountHero());
    w.setAllThreadToNull();
    assertTrue(w.getHero(0) == null);
    assertTrue(w.getPlayer() == null);
  }
}
