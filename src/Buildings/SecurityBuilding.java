package Buildings;
import Point.Point;
import Buildings.Buildings;

public class SecurityBuilding extends Buildings {
    public SecurityBuilding(String naming, int price, int tprice, int size, Point pos){
        super(naming, price, tprice, size,pos);
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