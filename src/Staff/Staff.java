package Staff;
import Point.Point;

public abstract class Staff {
    private int salaryPerDay  ;
    public Point position;
    public Staff(Point pos){
        this.position=new Point(pos);
    }
    public abstract void doTheJob();
    public int getSalaryPerDay(){
        return salaryPerDay;
    }
    public void setSalaryPerDay(int salary){
        this.salaryPerDay=salary;
    }

}
