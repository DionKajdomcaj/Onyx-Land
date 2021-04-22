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

    Buildings builds = null;

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
    private boolean NOTenoughPlace(int[] xy, int sizeX, int sizeY) {

        int right_top_X4 = xy[0] + sizeX;
        int right_top_Y4 = xy[1];
        int left_bottom_X3 = xy[0];
        int left_bottom_Y3 = xy[1] + sizeY;
        System.out.println("entered");
        System.out.println(buildings.size());

        for (int i = 0; i < buildings.size()-1; i++) {
            int right_top_X2 = buildings.get(i).getPosition().x + buildings.get(i).getSize().x;
            int right_top_Y2 = buildings.get(i).getPosition().y;
            int left_bottom_X1 = buildings.get(i).getPosition().x;
            int left_bottom_Y1 = buildings.get(i).getPosition().y + buildings.get(i).getSize().y;

            if (left_bottom_X3 > right_top_X2 || left_bottom_Y3 > right_top_Y2 || left_bottom_X1 > right_top_X4 || left_bottom_Y1 > right_top_Y4) {
                return true;
            }
            System.out.println(i);

        }
        for (int i = 0; i < gardens.size()-1; i++) {
            int right_top_X2 = gardens.get(i).getPosition().x + gardens.get(i).getSize().x;
            int right_top_Y2 = gardens.get(i).getPosition().y;
            int left_bottom_X1 = gardens.get(i).getPosition().x;
            int left_bottom_Y1 = gardens.get(i).getPosition().y + gardens.get(i).getSize().y;

            if (left_bottom_X3 > right_top_X2 || left_bottom_Y3 > right_top_Y2 || left_bottom_X1 > right_top_X4 || left_bottom_Y1 > right_top_Y4) {
                return true;
            }
        }
        for (int i = 0; i < paths.size()-1; i++) {
            int right_top_X2 = paths.get(i).getPosition().x + paths.get(i).getSize();
            int right_top_Y2 = paths.get(i).getPosition().y;
            int left_bottom_X1 = paths.get(i).getPosition().x;
            int left_bottom_Y1 = paths.get(i).getPosition().y + paths.get(i).getSize();

            if (left_bottom_X3 > right_top_X2 || left_bottom_Y3 > right_top_Y2 || left_bottom_X1 > right_top_X4 || left_bottom_Y1 > right_top_Y4) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int[] xy = transform_eXeY_to_CellXCellY(e.getX(), e.getY());

        if (state == 1) {
//            if (NOTenoughPlace(xy, buildings.get(buildings.size()-1).getSize().x, buildings.get(buildings.size()-1).getSize().y)) {
//                /*buildings.remove(buildings.size() - 1);
//                state = 0;*/
//                return;
//            }
            buildings.get(buildings.size()-1).position = new Point(xy[0], xy[1]);
            repaint();
            player.setAmountOfMoney(player.getamountOfMoney()-buildings.get(buildings.size()-1).getPrice());
        }
        else if(state == 2){
//            if (NOTenoughPlace(xy, paths.get(paths.size()-1).getSize(), paths.get(paths.size()-1).getSize())) {
//                /*paths.remove(paths.size() - 1);
//                state = 0;*/
//                return;
//            }
            paths.get(paths.size()-1).position = new Point(xy[0], xy[1]);
            repaint();
            player.setAmountOfMoney(player.getamountOfMoney()-paths.get(paths.size()-1).getPrice());
        }
        else if(state == 3){
//            if (NOTenoughPlace(xy, gardens.get(gardens.size()-1).getSize().x, gardens.get(gardens.size()-1).getSize().y)) {
//                /*gardens.remove(gardens.size() - 1);
//                state = 0;*/
//                return;
//            }
            gardens.get(gardens.size()-1).position = new Point(xy[0], xy[1]);
            repaint();
            player.setAmountOfMoney(player.getamountOfMoney()-gardens.get(gardens.size()-1).getPrice());
        }
        state = 0;

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

