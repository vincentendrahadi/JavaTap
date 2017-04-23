package Stage;

import Enemy.BossEnemy;
import Enemy.RegularEnemy;
import Enemy.Enemy;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * <h2>Stage.Stage.java</h2>
 * Kelas Stage.Stage sebagai container dari stages yang akan dilalui pemain.
 *
 * @author  Vincent Endrahadi
 * @since   2017-04-22
 */
public class Stage {
    private ArrayList<Enemy> gameStage;
    private int curStage;

    /**
     * Konstruktor untuk stage
     * Membaca file eksternal stage.txt
     * @throws FileNotFoundException
     * @see FileNotFoundException
     */
    public Stage() throws FileNotFoundException{
        String line;
        String name;
        int max;
        Enemy E;
        Scanner file = new Scanner(new File("stage.txt"));
        gameStage = new ArrayList<Enemy>();
        while (file.hasNextLine()) {
            line = file.nextLine();
            String temp[] = line.split(" ");
            max = Integer.parseInt(temp[0]);
            name = temp[1];
            if (temp[2].equals("1")) {
                 E = new BossEnemy(max,name);
            } else E = new RegularEnemy(max,name);
            gameStage.add(E);

        }
        curStage = 0;
    }

    /**
     * Getter untuk index current stage yang akan dihadapi pemain.
     * @return curStage int sebagai index dari curStage.
     */
    public int getCurStage() {
        return curStage;
    }

    /**
     * Setter untuk index current stage yang akan dihadapi pemain.
     * @param curStage integer sebagai currentstage
     */
    public void setCurStage(int curStage) {
        this.curStage = curStage;
    }

    /**
     * Getter dari gameStage
     * @return gameStage List dari gameStage.
     */
    public ArrayList<Enemy> getGameStage() {
        return gameStage;
    }

    /**
     * Getter untuk current enemy
     * Diambil dari list berindex curStage
     * @return Enemy
     */
    public Enemy getCurEnemy() {
        return gameStage.get(curStage);
    }
}
