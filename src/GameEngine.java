import Buildings.*;
import Buildings.Gargens.Gardens;
import Staff.*;
import Point.Point;
import CONSTANTS.CONSTANTS;
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
    ArrayList<Buildings> buildings;
    ArrayList<Path> paths;
    int[][] paths_matrix;
    ArrayList<Gardens>gardens;
    int number_of_visitors = 1;
    private Timer timer;
    boolean flag = false;
    Object temporary = null;
    boolean is_builded = false;
    int state = 0;

    public GameEngine(int row, int col) {
        super();
        player = new Player();
        visitors = new ArrayList<>();
        buildings = new ArrayList<>();
        paths = new ArrayList<>();
        gardens = new ArrayList<>();
        paths_matrix = new int[20][];
        for (int i = 0; i < 20; i++) {
            paths_matrix[i] = new int[20];
            for (int j = 0; j < 20; j++) {
                paths_matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < 1; i++) {
            visitors.add(new Visitor());
        }
        start();

        //START PATHS AND MARKING THEM IN MATRIX
        //paths.add(new Path(Integer.parseInt(CONSTANTS.DIRT_PATH_PRICE),new Point(665,70),"./src/img/entrance.jpg"));
        paths.add(new Path(Integer.parseInt(CONSTANTS.DIRT_PATH_PRICE),new Point(630,70),"./src/img/dirty-path.JPG"));
        paths_matrix[70/35][630/35] = 1;
        paths.add(new Path(Integer.parseInt(CONSTANTS.DIRT_PATH_PRICE),new Point(595,70),"./src/img/dirty-path.JPG"));
        paths_matrix[70/35][595/35] = 1;
        paths.add(new Path(Integer.parseInt(CONSTANTS.DIRT_PATH_PRICE),new Point(560,70),"./src/img/dirty-path.JPG"));
        paths_matrix[70/35][560/35] = 1;
        paths.add(new Path(Integer.parseInt(CONSTANTS.DIRT_PATH_PRICE),new Point(525,70),"./src/img/dirty-path.JPG"));
        paths_matrix[70/35][525/35] = 1;

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
        //every 3 new path number of visitors increases by 1 starting from 5
        if (paths.size() > 5) {
            flag = true;
            /*System.out.println(is_builded);
            System.out.println(paths.size() + "    " + number_of_visitors + "      " + (paths.size() - number_of_visitors)%3);*/
            if (paths.size() - number_of_visitors != 0 && paths.size()%3 == 0 && is_builded) {
                number_of_visitors++;
                visitors.add(new Visitor());
                is_builded = false;
            }
        }
        for (Visitor v: visitors) {
            v.draw(g);
        }
    }

    private Point ChooseDirectionToMove (Point visitor, Point previous) {
        /*
        #: we here
        -x- : between which do we choose

            x   x   x   x   x

        y   0   0  -1-  1   0
        y   0  -0-  #  -1-  1
        y   0   0  -1-  0   0
         */
        int direction1 = -1;
        Point d1 = null;
        int direction2 = -1;
        Point d2 = null;
        int direction3 = -1;
        Point d3 = null;
        int direction4 = -1;
        Point d4 = null;

        int prev = -1;

        try {
            direction1 = paths_matrix[visitor.y/35][(visitor.x)/35-1];
        } catch (IndexOutOfBoundsException e) {
            //direction1 = -1;
        }
        if (direction1 == 1) {
            d1 = new Point(-35, 0);
            //d1 = new Point((visitor.x)/35-1, visitor.y/35);
        }
        if (visitor.y/35 == previous.y/35 && (visitor.x)/35-1 == previous.x/35) {
            prev = 1;
        }
        //System.out.println(direction1);
        //System.out.println((visitor.x)/35-1 + " " + visitor.y/35);


        try {
            direction2 = paths_matrix[visitor.y/35][(visitor.x)/35+1];
        } catch (IndexOutOfBoundsException e) {
            //direction2 = -1;
        }
        if (direction2 == 1) {
            d2 = new Point(35, 0);

            //d2 = new Point((visitor.x)/35+1, visitor.y/35);
        }
        if (visitor.y/35 == previous.y/35 && (visitor.x)/35+1 == previous.x/35) {
            prev = 2;
        }
        //System.out.println(direction2);
        //System.out.println((visitor.x)/35+1 + " " + visitor.y/35);


        try {
            direction3 = paths_matrix[(visitor.y)/35-1][visitor.x/35];
        } catch (IndexOutOfBoundsException e) {
            //direction3 = -1;
        }
        if (direction3 == 1) {
            d3 = new Point(0, -35);

            //d3 = new Point(visitor.x/35, (visitor.y)/35-1);
        }
        //System.out.println(direction3);
        //System.out.println((visitor.x)/35 + " " + ((visitor.y)/35-1));
        if (visitor.y/35-1 == previous.y/35 && (visitor.x)/35 == previous.x/35) {
            prev = 3;
        }

        try {
            direction4 = paths_matrix[(visitor.y)/35+1][visitor.x/35];
        } catch (IndexOutOfBoundsException e) {
            //direction4 = -1;
        }
        if (direction4 == 1) {
            d4 = new Point(0, 35);

            //d4 = new Point(visitor.x/35, (visitor.y)/35+1);
        }
        if (visitor.y/35+1 == previous.y/35 && (visitor.x)/35 == previous.x/35) {
            prev = 4;
        }
        //System.out.println(direction4);
        //System.out.println((visitor.x)/35 + " " + ((visitor.y)/35+1));

        //System.out.println(prev);

        //System.out.println("---------");
        Point selected = null;
        if (direction1 + direction2 + direction3 + direction4 > 1) {
            switch (prev) {
                case 1:
                    while (selected == null) {
                        int a = (int) ( Math.random() * 4 );
                        switch (a) {
                            case 1 -> selected = d2;
                            case 2 -> selected = d3;
                            case 3 -> selected = d4;
                        }
                    }
                    break;
                case 2:
                    while (selected == null) {
                        int a = (int) ( Math.random() * 4 );
                        switch (a) {
                            case 0 -> selected = d1;
                            case 2 -> selected = d3;
                            case 3 -> selected = d4;
                        }
                    }
                    break;
                case 3:
                    while (selected == null) {
                        int a = (int) ( Math.random() * 4 );
                        switch (a) {
                            case 0 -> selected = d1;
                            case 1 -> selected = d2;
                            case 3 -> selected = d4;
                        }
                    }
                    break;
                case 4:
                    while (selected == null) {
                        int a = (int) ( Math.random() * 4 );
                        switch (a) {
                            case 0 -> selected = d1;
                            case 1 -> selected = d2;
                            case 2 -> selected = d3;
                        }
                    }
                    break;
            }

        } else {
            switch (prev){
                case 1 -> selected = d1;
                case 2 -> selected = d2;
                case 3 -> selected = d3;
                case 4 -> selected = d4;
            }
        }

        return selected;
    }
    public void start() {
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (flag) {
                    for (int i = 0; i < visitors.size(); i++) {
                        //setting new position to visitors
                        if (visitors.get(i).visitor_passed_2_cells > 2) {
                            Point p0 = visitors.get(i).getPosition();
                            visitors.get(i).directionToMove = ChooseDirectionToMove(p0, visitors.get(i).getPrevPosition());
                            Point p = new Point(visitors.get(i).getPosition().x + visitors.get(i).directionToMove.x, visitors.get(i).getPosition().y + visitors.get(i).directionToMove.y);
                            visitors.get(i).setPrevPosition(p0);
                            visitors.get(i).setPosition(p);
                        } else {
                            Point p0 = visitors.get(i).getPosition();
                            Point p = new Point(visitors.get(i).getPosition().x + visitors.get(i).directionToMove.x, visitors.get(i).getPosition().y + visitors.get(i).directionToMove.y);
                            visitors.get(i).setPrevPosition(p0);
                            visitors.get(i).setPosition(p);
                            visitors.get(i).visitor_passed_2_cells += 1;
                        }
                    }
                    repaint();
                }

            }

        });

        timer.start();
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

        System.out.println(state);

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
                //marking cell as path in matrix
                paths_matrix[xy[1]/35][xy[0]/35] = 1;
                if (paths.size() > 5) {
                    is_builded = true;
                }
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

}

