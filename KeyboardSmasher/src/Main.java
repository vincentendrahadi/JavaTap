import controller.GameplayController;
import maincharacter.hero.Hero;
import maincharacter.player.Player;
import stage.Stage;
import world.World;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by axelinate on 4/23/17.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Player p = new Player("Player");
        Hero h = new Hero ("Hero",10,0.5);
        Stage stages = new Stage();
        ArrayList<Hero> hero = new ArrayList<>();
        World world = new World(p,hero,stages);
        world.addHero(h);
        GameplayController gc = new GameplayController(world);
        gc.runWorld();
    }
}
