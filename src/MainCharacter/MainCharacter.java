package MainCharacter;
/**
 * <h2>Player.java</h2>
 * Abstrak kelas MainCharacter sebagai referensi Hero dan Player/
 *
 * @author  Vincent Endrahadi
 * @since   2017-04-18
 */
public abstract class MainCharacter extends Thread {
    protected int attPower;
    protected int level;
    protected boolean thereIsEnemy;

    /**
     * Getter untuk mengetahui apakah terdapat musuh.
     * @return boolean Keberadaan enemy.
     */
    public abstract boolean getThereIsEnemy();

    /**
     * Setter untuk memberi keadaan keberadaan enemy.
     * @param thereIsEnemy apakah terdapat musuh
     */
    public abstract void setThereIsEnemy(boolean thereIsEnemy);

    /**
     * Getter untuk attack power player.
     * @return int Attack Power dari Player.
     */
    public abstract int getAttPower();

    /**
     * Setter untuk attack power
     * menambahkan attPower ke attPower yang telah ada.
     * @param attPower AttacK Power
     */
    public abstract void setAttPower(int attPower);

    /**
     * Getter untuk level player.
     * @return int Level dari player.
     */
    public abstract int getLevel();

    /**
     * Menyerang musuh dengan attPower yang ada.
     * @return int Attack yang dihasilkan.
     */
    public abstract int attack();

    /**
     * Menaikkan level dari pemain sejumlah 1.
     */
    public abstract void levelUp();
}
