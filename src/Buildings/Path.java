package Buildings;
import DFS.Node;
import Point.Point;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Path {
    private int price;
    private final int size=1;
    public Point position;
    public ArrayList<Node> nodes;

    public BufferedImage img;
    public Path(int price, Point pos, String src){
        this.price=price;
        this.position = new Point(pos);
        try {
            this.img = ImageIO.read(new File(src));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g){

        g.drawImage(img,position.getX(),position.getY(),1*35,1*35,null);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public Point getPosition() {
        return position;
    }
}
