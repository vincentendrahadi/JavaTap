import Enemy.BossEnemy;
import Enemy.RegularEnemy;
import Enemy.Enemy;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Vincent Endrahadi on 4/22/17.
 */
public class Stage {
    private ArrayList<Enemy> gameStage;
    private int curStage;

    public Stage() throws FileNotFoundException{
        String line;
        String name;
        int max;
        boolean boss;
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

    public int getCurStage() {
        return curStage;
    }

    public void setCurStage(int curStage) {
        this.curStage = curStage;
    }

    public ArrayList<Enemy> getGameStage() {
        return gameStage;
    }

    public Enemy getCurEnemy() {
        return gameStage.get(curStage);
    }
}
