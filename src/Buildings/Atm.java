package Buildings;

//import Buildings.Buildings;
import Point.Point;

import javax.swing.*;
import java.awt.*;

public class Atm extends Buildings {
    private int capacity;
    public Atm(String naming, int price, int tprice, Point size, Point pos, String src,int capacity){
        super(naming, price, tprice, size,pos,src);
        this.capacity=capacity;
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
