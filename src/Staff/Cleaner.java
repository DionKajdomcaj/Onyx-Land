package Staff;
import Buildings.Path;
import Point.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Cleaner extends Staff {
    public BufferedImage img;
    private Point start_position = new Point(665, 70);
    public boolean is_work = false;
    public ArrayList<Path> the_way = null;
    public Cleaner(Point pos){
        super(pos);
        setSalaryPerDay(30);

        try {
            this.img = ImageIO.read(new File("./src/img/cleaner2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void doTheJob(){}
    public void draw(Graphics g){
        g.drawImage(img,position.getX(),position.getY(),35,35,null);//x=width, y=height
    }


}
