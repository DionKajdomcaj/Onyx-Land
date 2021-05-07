import Buildings.*;
import Point.Point;
import Staff.Staff;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Visitor {
    public int visitor_passed_2_cells = 0;
    public Point directionToMove = new Point(-35, 0);
    public double trashThrower = 0.0;
    private int moneyToSpend;
    private int mood;
    private Point position;
    private Point previous_position;
    public BufferedImage img;

    public Visitor(double tth){
        this.trashThrower = tth;
        this.position=new Point(665, 70);
        this.previous_position = new Point(1000,1000);
        this.moneyToSpend=1500;
        this.mood=50;

        try {
            this.img = ImageIO.read(new File("./src/img/visitors2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void draw(Graphics g){
        g.drawImage(img,position.getX(),position.getY(),35,35,null);//x=width, y=height
    }
    public int getMood(){
        return mood;
    }
    public void setMood(int mood1){
        mood=mood1;
    }
    public Point getPosition(){
        return position;
    }
    public void setPosition(Point pos){
        position=new Point(pos);
    }
    public Point getPrevPosition(){
        return previous_position;
    }
    public void setPrevPosition(Point pos){
        previous_position=new Point(pos);
    }
    public void useRestaurants(Restaurant r,int i){
        if(i==1){
            setMood(getMood() + r.getMoodImprovement());
        }
        else{
            setMood(getMood() - r.getMoodImprovement());
        }


    }
    public void payTicket(){}
    public void throwTrash(){}
    public void exit(){}
    public void callTheStaff(Staff staff){}


}
