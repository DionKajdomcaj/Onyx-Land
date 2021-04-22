package Buildings;
import Point.Point;
import Buildings.Buildings;
import Staff.Staff;

import java.awt.*;
import java.util.ArrayList;

public class SecurityBuilding extends Buildings {
    protected ArrayList<Staff> securities;
    public SecurityBuilding(String naming, int price, int tprice, Point size, Point pos, String src){
        super(naming, price, tprice, size,pos,src);
        securities = new ArrayList<>();
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
