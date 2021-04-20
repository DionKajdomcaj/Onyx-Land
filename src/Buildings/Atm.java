package Buildings;

//import Buildings.Buildings;
import Point.Point;

import javax.swing.*;
import java.awt.*;

public class Atm extends Buildings {
    public Atm(String naming, int price, int tprice, Point size, Point pos, String src){
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
