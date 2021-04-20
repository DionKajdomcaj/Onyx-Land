package Buildings;
import Point.Point;
import Buildings.Buildings;

import java.awt.*;

public class SecurityBuilding extends Buildings {
    public SecurityBuilding(String naming, int price, int tprice, Point size, Point pos, String src){
        super(naming, price, tprice, size,pos,src);
    }
    public String GetInfo(){
        return "test";
    }
    public void UpgradeTheLevel(){}
    public  void Delete(){}
    public  void Built(){}
    public  void Repair(){}
    public  void Clean(){}
}
