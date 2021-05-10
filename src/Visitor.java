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
    private int mood;
    private int amountOfMoney=999999999;
    private Point position;
    private Point previous_position;
    public int numberOfvisited;
    public boolean is_visiting_right_now = false;
    public boolean walking_to_another = false;
    public long time_of_enter;
    public long time_of_walking;
    public long time_of_enter_the_park;

    public BufferedImage img;

    public Visitor(double tth){
        this.trashThrower = tth;
        this.position=new Point(665, 70);
        this.previous_position = new Point(1000,1000);
        this.mood=50;
        this.numberOfvisited=0;
        this.time_of_enter_the_park = System.currentTimeMillis();
        try {
            this.img = ImageIO.read(new File("./src/img/visitors2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void draw(Graphics g){
        if (!is_visiting_right_now)
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
    public void useBuildings(Buildings b ,Player p){
        if (b.capacity > b.visitors_inside_counter) {
            setMood(getMood() + b.getMoodImprovement());
            payTicket(b,p);
            this.is_visiting_right_now = true;
            this.time_of_enter = System.currentTimeMillis();
            b.visitors_inside_counter++;
        }

    }
    public void payTicket(Buildings b,Player p){
        amountOfMoney-=b.getTicketPrice();
        p.setAmountOfMoney((p.getamountOfMoney()+b.getTicketPrice()));
    }
    public void exit(){}

}
