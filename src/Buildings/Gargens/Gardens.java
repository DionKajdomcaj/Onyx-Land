package Buildings.Gargens;
import Buildings.Buildings;
import Point.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Gardens {
    protected int price;
    private String name;
    public BufferedImage img;
    protected int moodImprovement;
    protected Point size;
    public Point position;
    public Gardens(String naming,int price, int moodImprovement, Point pos,Point size,String src){
        this.name=naming;
        this.price=price;
        this.moodImprovement=moodImprovement;
        this.position=new Point(pos);
        this.size=new Point(size);
        try {
            this.img = ImageIO.read(new File(src));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void draw(Graphics g){
        g.drawImage(img,position.getX(),position.getY(),size.getX()*35,size.getY()*35,null);//x=width, y=height
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMoodImprovement() {
        return moodImprovement;
    }

    public void setMoodImprovement(int moodImprovement) {
        this.moodImprovement = moodImprovement;
    }

    public Point getPosition() {
        return position;
    }
    public Point getSize() {
        return size;
    }

}
