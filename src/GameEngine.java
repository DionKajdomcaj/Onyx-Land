import Buildings.*;
import Staff.Staff;
import Staff.Policeman;
import Staff.Repairman;
import Staff.Security;
import Staff.Cleaner;
import Staff.Thief;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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

        int count = 0 ; // use to give a name to each box so that you can refer to them later
        setLayout(new GridLayout(row, col));
        setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

        addMouseListener(this);

        /*for (int i = 1; i <= (row * col); i++) {
            JPanel pan = new JPanel();

            pan.setEnabled(true);
            pan.setBackground(Color.WHITE);
            pan.setPreferredSize(new Dimension(10, 10));
            pan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            pan.addMouseListener(new MouseInput());
            pan.setName(count+"");
            ++count;
            add(pan);
        }*/
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        BufferedImage img = null;
        BufferedImage img2 = null;

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


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (state == 1) {

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



    /*
        JLabel[] myPanels = new JLabel[300];
        for (int x = 0;x<myPanels.length;x++){

            myPanels[x]=new JLabel("");
            myPanels[x].setOpaque(true);
            myPanels[x].setBackground(Color.BLUE);
            myPanels[x].setBorder(BorderFactory.createLineBorder(Color.black));
        }
    //Add all the squares (JLabels)
        for (int x = 0;x<myPanels.length;x++)
            add(myPanels[x]);
    }
    */
}

