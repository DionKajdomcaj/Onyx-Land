import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import Point.Point;
public class Trash {
    public BufferedImage img;
    private Point position;

    public Trash() {
        try {
            this.img = ImageIO.read(new File("./src/img/trash.JPG"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void setPosition(Point p) {
        this.position = p;
    }
    public void draw(Graphics g){

        g.drawImage(img, (int) position.getX() + 7, (int) position.getY() + 7,20,20,null);//x=width, y=height

    }



}
