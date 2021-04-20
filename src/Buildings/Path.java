package Buildings;
import Point.Point;

import javax.swing.*;
import java.awt.*;

public class Path {
    private int price;
    private final int size=1;
    public Point position;
    public Image img = new ImageIcon("img/path.png").getImage();
    public Path(int price, Point pos){
        this.price=price;
        this.position = new Point(pos);
    }
    public void build(){

    }
    public void draw(Graphics g){
        g.drawImage(img,position.getX(),position.getY(),1,1,null);
    }
}
