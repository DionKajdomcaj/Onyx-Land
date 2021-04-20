package Buildings;
import Point.Point;
import org.w3c.dom.css.Rect;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public abstract class Buildings {
    public String naming;
    protected int price;
    protected int ticketPrice;
    protected Point sizeOfBuilding; //for example "3x6", "8x2"
    public Point position;
    //protected int moodImprovement;
    //protected int maxVisitors;
    public BufferedImage img;
    public boolean is_builted = false; //is it under construction or was builted and can work

    public Buildings(String n, int p, int tp, Point size, Point pos,String src){
        this.naming=n;
        this.price = p;
        this.ticketPrice = tp;
        this.sizeOfBuilding = new Point(size);
        this.position=new Point(pos);

        try {
            this.img = ImageIO.read(new File(src));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // this.img=img;
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

    public Point getSizeOfBuilding() {
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
    public boolean collides(Buildings other){
        Rectangle current = new Rectangle(this.position.getX(),this.position.getY(),this.sizeOfBuilding.getX(),this.sizeOfBuilding.getY());
        Rectangle notCurrent = new Rectangle(other.position.getX(),other.position.getY(),other.sizeOfBuilding.getX(),other.sizeOfBuilding.getY());
        return current.intersects(notCurrent);
    }
    public void draw(Graphics g){
        g.drawImage(img,position.getX(),position.getY(),sizeOfBuilding.getX()*35,sizeOfBuilding.getY()*35,null);//x=width, y=height
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Buildings)) return false;
        Buildings buildings = (Buildings) o;
        return Objects.equals(getPosition(), buildings.getPosition());
    }

}
