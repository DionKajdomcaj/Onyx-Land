import java.nio.file.attribute.PosixFileAttributes;

public class Visitor {
    private int moneyToSpend;
    private int mood;
    private Point position;

    public Visitor(Point pos){
        this.position=new Point(pos);
        this.moneyToSpend=1500;
        this.mood=50;
    }
    public Point getPosition(){
        return position;
    }
    public void setPosition(Point pos){
        position=new Point(pos);
    }
    public void useBuilding(){}
    public void payTicket(){}
    public void throwTrash(){}
    public void exit(){}
    public void callTheStaff(Staff staff){}


}
