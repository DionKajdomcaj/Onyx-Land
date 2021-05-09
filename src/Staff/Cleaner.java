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
    public boolean is_work = false;
    public boolean is_move = false;
    public ArrayList<Path> the_way = null;
    private int paths_passed = 0;
    public boolean time_to_clean = false;

    public Cleaner(Point pos){
        super(pos);
        this.position = new Point(665, 70);
        setSalaryPerDay(30);

        try {
            this.img = ImageIO.read(new File("./src/img/cleaner2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics g){
        g.drawImage(img,position.getX(),position.getY(),20,35,null);//x=width, y=height
    }

    public void updatePosition() {

        if (is_move) {
            position.setX(the_way.get(paths_passed).getPosition().x);
            position.setY(the_way.get(paths_passed).getPosition().y);
            paths_passed++;
        }

        if (the_way != null) {
            if (paths_passed == the_way.size()) {
                is_move = false;
                time_to_clean = true;
            }
        }


    }

    public void freeToWork() {
        time_to_clean = false;
        the_way = null;
        paths_passed = 0;
        is_work = false;
    }

    public void doTheJob(){}

}
