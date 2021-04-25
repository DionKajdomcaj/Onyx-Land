import Point.Point;
import Staff.Staff;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Visitor {
    private int moneyToSpend;
    private int mood;
    private Point position;
    public BufferedImage img;
    public Visitor(){
        this.position=new Point(665, 70);
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
    public void useBuilding(){}
    public void payTicket(){}
    public void throwTrash(){}
    public void exit(){}
    public void callTheStaff(Staff staff){}


}
