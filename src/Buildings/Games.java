package Buildings;
import Buildings.Buildings;
import Point.Point;

public class Games extends Buildings {
    private int maxVisitors;
    private int timeToBuild;
    private int moodImprovement;
    public Games(String naming, int price, int tprice, int size, int moodImpr, Point pos){
        super(naming,price,tprice,size,pos);
        this.moodImprovement=moodImpr;
        maxVisitors=10;
        timeToBuild=40;
    }
    public String GetInfo(){
        return "test";
    }
    public int getMaxVisitors(){
        return maxVisitors;
    }
    public int getMoodImprovement(){
        return moodImprovement;
    }
    public int getTimeToBuild(){
        return timeToBuild;
    }
    public void UpgradeTheLevel(){}
    public  void Delete(){}
    public  void Built(){}
    public  void Repair(){}
    public  void Clean(){}
}
