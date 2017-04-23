import Controller.GameplayController;
import MainCharacter.Heroes.Hero;
import MainCharacter.Player.Player;
import World.KSWorld;

import java.io.FileNotFoundException;

/**
 * Created by axelinate on 4/23/17.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        KSWorld world = new KSWorld();
        Player p = new Player("Player");
        Hero h = new Hero ("Hero",4);
        GameplayController gc = new GameplayController(world);
        gc.runWorld();
    }
}
