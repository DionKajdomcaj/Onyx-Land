package Buildings;
//import Buildings.Buildings;
import Point.Point;

import java.awt.*;

public class Games extends Buildings {
    private int maxVisitors;
    private int timeToBuild;
    private int moodImprovement;
    public Games(String naming, int price, int tprice, Point size, int moodImpr, Point pos, String src){
        super(naming,price,tprice,size,pos,src);
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
