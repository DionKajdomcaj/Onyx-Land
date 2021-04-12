package Staff;

import javax.swing.text.Position;
import Point.Point;

public class Thief {
    private int skillLevel;
    private final int moneyStolen;
    public Point position;

    public Thief(int skillLevel, Point pos){
        this.position=new Point(pos);
        this.skillLevel=skillLevel;
        moneyStolen=0;
    }



    public void steal(){}
    public void run(){}

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public int getMoneyStolen() {
        return moneyStolen;
    }


}
