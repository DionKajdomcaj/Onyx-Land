package Buildings;
import Point.Point;
import Buildings.Buildings;

import java.awt.*;

public class Restaurant extends Buildings {
    private int moodImprovement;
    public Restaurant(String naming, int price, int tprice, Point size, int moodImpr, Point pos, String img) {
        super(naming, price, tprice, size,pos,img);
        this.moodImprovement=moodImpr;

    }
    public  String GetInfo(){
        return "test";
    }
    public void UpgradeTheLevel(){}
    public  void Delete(){}
    public  void Built(){


    }
    public  void Repair(){}
    public  void Clean(){}
    public int getMoodImprovement(){
        return moodImprovement;
    }
}


