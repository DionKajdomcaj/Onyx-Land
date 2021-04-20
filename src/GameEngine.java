import Buildings.*;
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
    ArrayList<Visitor> visitors;
    Policeman policeman;
    Thief thief;
    JLabel moneyOfPlayer;
    Repairman repairman;
    Security security;
    Cleaner cleaner;
    ArrayList<Buildings> buildings;
    ArrayList<Staff>staff;
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
        //Restaurant hotdog = new Restaurant("Hot-Dog",100,5,new Point(3,2),20,new Point(5,15),"src/img/hot-dogs.jpg");
        //hotdog.draw(g);


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (state == 1) {
            System.out.println(e.getX() + " "+ e.getY());
            buildings.get(buildings.size()-1).position = new Point(e.getX(), e.getY());
            repaint();
            player.setAmountOfMoney(player.getamountOfMoney()-buildings.get(buildings.size()-1).getPrice());
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
            repaint(new Rectangle());




        }

    }
}

