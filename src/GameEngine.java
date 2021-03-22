import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameEngine extends JPanel {
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



    public GameEngine(int row, int col) {
        super();
        player = new Player();
        visitors = new ArrayList<>();

        int count = 0 ; // use to give a name to each box so that you can refer to them later
        setLayout(new GridLayout(row, col));
        setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

        for (int i = 1; i <= (row * col); i++) {
            JPanel pan = new JPanel();

            pan.setEnabled(true);
            pan.setBackground(Color.WHITE);
            pan.setPreferredSize(new Dimension(3, 3));
            pan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            pan.addMouseListener(new MouseInput());
            pan.setName(count+"");
            ++count;
            add(pan);
        }
    }



//        JLabel[] myPanels = new JLabel[300];
//        for (int x = 0;x<myPanels.length;x++){
//
//            myPanels[x]=new JLabel("");
//            myPanels[x].setOpaque(true);
//            myPanels[x].setBackground(Color.BLUE);
//            myPanels[x].setBorder(BorderFactory.createLineBorder(Color.black));
//        }
////Add all the squares (JLabels)
//        for (int x = 0;x<myPanels.length;x++)
//            add(myPanels[x]);
//    }


    //setBackground2(this);
/*
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage img = null;
       try {
           img = ImageIO.read(new File("src/img/green-grass-textures.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
      }
        Image dimg = img.getScaledInstance(800, 800, Image.SCALE_SMOOTH);
        g.drawImage(dimg, 0, 0, null);
    }
    s
 */
}

