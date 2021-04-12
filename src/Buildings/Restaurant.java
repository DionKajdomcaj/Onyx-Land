package Buildings;
import Point.Point;
import Buildings.Buildings;

public class Restaurant extends Buildings {
    private int moodImprovement;
    public Restaurant(String naming, int price, int tprice, int size, int moodImpr, Point pos) {
        super(naming, price, tprice, size,pos);
        this.moodImprovement=moodImpr;

    }
    public  String GetInfo(){
        return "test";
    }
    public void UpgradeTheLevel(){}
    public  void Delete(){}
    public  void Built(){}
    public  void Repair(){}
    public  void Clean(){}
    public int getMoodImprovement(){
        return moodImprovement;
    }
}


