package Buildings;
import Point.Point;

public abstract class Buildings {
    public String naming;
    protected int price;
    protected int ticketPrice;
    protected int sizeOfBuilding; //for example "3x6", "8x2"
    public Point position;
    //protected int moodImprovement;
    //protected int maxVisitors;
    //protected int level;
    public boolean is_builted = false; //is it under construction or was builted and can work

    public Buildings(String n, int p, int tp, int s, Point pos){
        this.naming=n;
        this.price = p;
        this.ticketPrice = tp;
        this.sizeOfBuilding = s;
        this.position=new Point(pos);
       // this.moodImprovement = mi;
       // this.maxVisitors = mv;
       // this.level = l;
    }

    public abstract String GetInfo();
    public abstract void UpgradeTheLevel();
    public abstract void Delete();
    public abstract void Built();
    public abstract void Repair();
    public abstract void Clean();

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    /* public String RotatedSize() {
            String[] temp = this.getSizeOfBuilding().split("x");
            return temp[1] + "x" + temp[0];
        }

        */
    public int getSizeOfBuilding() {
        return this.sizeOfBuilding;
    }
    public int getPrice() {
        return this.price;
    }
    public int getTicketPrice() {
        return this.ticketPrice;
    }
    /*
    public int getMoodImprovement() {
        return this.moodImprovement;
    }

     */
    //public int getMaxVisitors() {return this.maxVisitors;}
   // public int getCurrentLevel() {return this.level;}


}
