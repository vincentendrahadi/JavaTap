public class Hero implements AttGenerator, LevelUpdater{
  private int attack;
  private int level;

  //getter & setter
  public int getAttack(){
    return attack;
  }

  public void setAttack(int _attack){
    this.attack = _attack;
  }

  public int getLevel(){
    return level;
  }

  public void setLevel(int _level){
    this.level = _level;
  }

  @Override
  public int attack(){
  	return attack;
  }

  @Override
  public void levelUp(){
  	level++;
  }
}