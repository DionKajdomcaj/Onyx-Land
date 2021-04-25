import Buildings.*;
import Buildings.Gargens.Gardens;
import Staff.*;
import Point.Point;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameEngine extends JPanel implements MouseListener {
    Player player;
    JPanel top;
    ArrayList<Visitor> visitors;
    Policeman policeman;
    Thief thief;
    JLabel moneyOfPlayer;
    Repairman repairman;
    Security security;
    Cleaner cleaner;
    ArrayList<Buildings> buildings;
    ArrayList<Staff>staff;
    ArrayList<Path> paths;
    ArrayList<Gardens>gardens;
    JButton menuButton;
    JButton settingsButton;
    JLabel numberOfVisitors;
    JLabel averageMood;

    Object temporary = null;

    int state = 0;

    public GameEngine(int row, int col) {
        super();
        player = new Player();
        visitors = new ArrayList<>();
        buildings = new ArrayList<>();
        paths = new ArrayList<>();
        gardens = new ArrayList<>();



        addMouseListener(this);

    }

    public int averageMood(){
        int sum=0;
        for(Visitor v : visitors){
            sum+=v.getMood();
        }
        return sum/visitors.size();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        BufferedImage img = null;
        BufferedImage img2 = null;
        /*for(Buildings b : buildings){
            for(Buildings b2 : buildings){
                if(b.collides(b2) && !b.equals(b2)){
                    b.draw(g2);
                }
            }
        }*/



        try {
           //img = ImageIO.read(new File("src/img/ground2.jpg"));
           img = ImageIO.read(new File("src/img/ground2-700.png"));
           img2 = ImageIO.read(new File("src/img/ground2-700-grid.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (state == 0) {
            //Image dimg = img.getScaledInstance(800, 800, Image.	SCALE_DEFAULT);
            g.drawImage(img, 0, 0, null);
        } else {
            g.drawImage(img2, 0, 0, null);
        }

        for(Buildings b2 : buildings){
            b2.draw(g);
        }
        for(Path p : paths){
            p.draw(g);
        }
        for(Gardens garden : gardens){
            garden.draw(g);
        }


    }

    private int[] transform_eXeY_to_CellXCellY(int x, int y) {
        /*function_that_will_transform_eX_and_eY_to_the_CellX_and_CellY(e.getX(),e.getY());
            7/35 = 0 => 0th column by X coordinate axis
            41/35 = 1.333 => 1th column by Y coordinate

            0, 35 */

        int cx = x/35 * 35;
        int cy = y/35 * 35;
        return new int[]{cx, cy};
    }
    private boolean EnoughPlace(int[] xy, int sizeX, int sizeY) {

        int a_x = xy[0] / 35;
        int a_y = xy[1] / 35;
        Rectangle rect0 = new Rectangle(a_x, a_y, sizeX, sizeY);

        if (state == 1) {

            if (buildings.size() > 1) {

                for (int i = 0; i < buildings.size() - 1; i++) {
                    int b_x = buildings.get(i).position.x / 35;
                    int b_y = buildings.get(i).position.y / 35;

                    Rectangle rect1 = new Rectangle(b_x, b_y, buildings.get(i).getSize().x, buildings.get(i).getSize().y);

                    if (rect0.intersects(rect1)) {
                        System.out.println("intersects");
                        return false;
                    }
                }
            }

            for (int i = 0; i < paths.size() - 1; i++) {
                int b_x = paths.get(i).position.x / 35;
                int b_y = paths.get(i).position.y / 35;

                Rectangle rect1 = new Rectangle(b_x, b_y, paths.get(i).getSize(), paths.get(i).getSize());

                if (rect0.intersects(rect1)) {
                    System.out.println("intersects");
                    return false;
                }
            }

            for (int i = 0; i < gardens.size() - 1; i++) {
                int b_x = gardens.get(i).position.x / 35;
                int b_y = gardens.get(i).position.y / 35;

                Rectangle rect1 = new Rectangle(b_x, b_y, gardens.get(i).getSize().x, gardens.get(i).getSize().y);

                if (rect0.intersects(rect1)) {
                    System.out.println("intersects");
                    return false;
                }
            }
        }
        if (state == 2) {

            if (paths.size() > 1) {

                for (int i = 0; i < paths.size() - 1; i++) {
                    int b_x = paths.get(i).position.x / 35;
                    int b_y = paths.get(i).position.y / 35;

                    Rectangle rect1 = new Rectangle(b_x, b_y, paths.get(i).getSize(), paths.get(i).getSize());

                    if (rect0.intersects(rect1)) {
                        System.out.println("intersects");
                        return false;
                    }
                }
            }

            for (int i = 0; i < buildings.size() - 1; i++) {
                int b_x = buildings.get(i).position.x / 35;
                int b_y = buildings.get(i).position.y / 35;

                Rectangle rect1 = new Rectangle(b_x, b_y, buildings.get(i).getSize().x, buildings.get(i).getSize().y);

                if (rect0.intersects(rect1)) {
                    System.out.println("intersects");
                    return false;
                }
            }

            for (int i = 0; i < gardens.size() - 1; i++) {
                int b_x = gardens.get(i).position.x / 35;
                int b_y = gardens.get(i).position.y / 35;

                Rectangle rect1 = new Rectangle(b_x, b_y, gardens.get(i).getSize().x, gardens.get(i).getSize().y);

                if (rect0.intersects(rect1)) {
                    System.out.println("intersects");
                    return false;
                }
            }
        }
        if (state == 3) {

            if (gardens.size() > 1) {

                for (int i = 0; i < gardens.size() - 1; i++) {
                    int b_x = gardens.get(i).position.x / 35;
                    int b_y = gardens.get(i).position.y / 35;

                    Rectangle rect1 = new Rectangle(b_x, b_y, gardens.get(i).getSize().x, gardens.get(i).getSize().y);

                    if (rect0.intersects(rect1)) {
                        System.out.println("intersects");
                        return false;
                    }
                }
            }

            for (int i = 0; i < buildings.size() - 1; i++) {
                int b_x = buildings.get(i).position.x / 35;
                int b_y = buildings.get(i).position.y / 35;

                Rectangle rect1 = new Rectangle(b_x, b_y, buildings.get(i).getSize().x, buildings.get(i).getSize().y);

                if (rect0.intersects(rect1)) {
                    System.out.println("intersects");
                    return false;
                }
            }

            for (int i = 0; i < paths.size() - 1; i++) {
                int b_x = paths.get(i).position.x / 35;
                int b_y = paths.get(i).position.y / 35;

                Rectangle rect1 = new Rectangle(b_x, b_y, paths.get(i).getSize(), paths.get(i).getSize());

                if (rect0.intersects(rect1)) {
                    System.out.println("intersects");
                    return false;
                }
            }
        }

        return true;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int[] xy = transform_eXeY_to_CellXCellY(e.getX(), e.getY());

        if (state == 1) {
            if (EnoughPlace(xy, buildings.get(buildings.size()-1).getSize().x, buildings.get(buildings.size()-1).getSize().y)) {
                state = 0;
                buildings.get(buildings.size()-1).position = new Point(xy[0], xy[1]);
                repaint();
                player.setAmountOfMoney(player.getamountOfMoney()-buildings.get(buildings.size()-1).getPrice());
            }
        }
        else if(state == 2){
            if (EnoughPlace(xy, paths.get(paths.size()-1).getSize(), paths.get(paths.size()-1).getSize())) {
                state = 0;
                paths.get(paths.size()-1).position = new Point(xy[0], xy[1]);
                repaint();
                player.setAmountOfMoney(player.getamountOfMoney()-paths.get(paths.size()-1).getPrice());
            }
        }
        else if(state == 3){
            if (EnoughPlace(xy, gardens.get(gardens.size()-1).getSize().x, gardens.get(gardens.size()-1).getSize().y)) {
                state = 0;
                gardens.get(gardens.size()-1).position = new Point(xy[0], xy[1]);
                repaint();
                player.setAmountOfMoney(player.getamountOfMoney()-gardens.get(gardens.size()-1).getPrice());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }



    class NewFrameListener implements ActionListener {
        public void actionPerformed(ActionEvent ae){





        }

    }
}

