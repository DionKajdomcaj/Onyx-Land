import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import Point.Point;

import Buildings.Restaurant;
import CONSTANTS.CONSTANTS;

public class Menu extends JFrame {
    GameEngine ge = null;

    public Menu(GameEngine g) {
        this.ge = g;
        JFrame f = new JFrame("What do you want to build?");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(500,500);
        //f.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        f.setLayout(new BorderLayout());
        setBackground(f);

        //creating menu
        JMenuBar menuBar = new JMenuBar();
        JMenu amusements = new JMenu("Amusements");
        JMenu paths = new JMenu("Paths");
        JMenu foods = new JMenu("Food Courts");
        JMenu gardens = new JMenu("Gardens");

        String[] amusementsNames = {"Roller Coaster", "Swing", "Wooden Chute", "Trampoline" };//, "Labyrinth", "Stone Chute", "Football", "Jump Tower", "Carousel", "Bungee Jump", "Drop Tower", "Laugh room"};
        for (String s: amusementsNames) {
            JMenuItem i = new JMenuItem(s);
            i.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JPanel container = new JPanel();
                    container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                    container.setLayout(new GridBagLayout());

                    f.getContentPane().removeAll();
                    f.getContentPane().repaint();
                    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    //f.setSize(500,500);
                    //f.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                    f.setLayout(new BorderLayout());
                    setBackground(f);

                    switch (s) {
                        case "Roller Coaster":
                            showObjectProperties(container, f, s, CONSTANTS.ROLER_COASTER_URL,
                                    CONSTANTS.ROLER_COASTER_PRICE,
                                    CONSTANTS.ROLER_COASTER_MOODIMPROVE,
                                    CONSTANTS.ROLER_COASTER_TIME,
                                    CONSTANTS.ROLER_COASTER_TICKET,
                                    CONSTANTS.ROLER_COASTER_SERVICE);
                            break;
                        case "Swing":
                            showObjectProperties(container, f, s,
                                    CONSTANTS.SWING_URL,
                                    CONSTANTS.SWING_PRICE,
                                    CONSTANTS.SWING_MOODIMPROVE,
                                    CONSTANTS.SWING_TIME,
                                    CONSTANTS.SWING_TICKET,
                                    CONSTANTS.SWING_SERVICE);
                            break;

                        case "Wooden Chute":
                            showObjectProperties(container, f, s,
                                    CONSTANTS.CHUTE_URL,
                                    CONSTANTS.CHUTE_PRICE,
                                    CONSTANTS.CHUTE_MOODIMPROVE,
                                    CONSTANTS.CHUTE_TIME,
                                    CONSTANTS.CHUTE_TICKET,
                                    CONSTANTS.CHUTE_SERVICE);
                            break;

                        case "Trampoline":
                            showObjectProperties(container, f, s,
                                    CONSTANTS.TRAMPOLINE_URL,
                                    CONSTANTS.TRAMPOLINE_PRICE,
                                    CONSTANTS.TRAMPOLINE_MOODIMPROVE,
                                    CONSTANTS.TRAMPOLINE_TIME,
                                    CONSTANTS.TRAMPOLINE_TICKET,
                                    CONSTANTS.TRAMPOLINE_SERVICE);
                            break;
                    }

                    f.setVisible(true);
                }
            });
            amusements.add(i);
        }

        String[] pathsNames = {"Dirt Path", "Stone Path", "Decorative path", "Golden Path"};
        for (String s: pathsNames) {
            JMenuItem i = new JMenuItem(s);
            i.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JPanel container = new JPanel();
                    container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                    container.setLayout(new GridBagLayout());

                    f.getContentPane().removeAll();
                    f.getContentPane().repaint();
                    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    //f.setSize(500,500);
                    //f.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                    f.setLayout(new BorderLayout());
                    setBackground(f);

                    switch (s) {
                        case "Dirt Path":
                            showObjectProperties(container, f, s, CONSTANTS.DIRT_PATH_URL,
                                    CONSTANTS.DIRT_PATH_PRICE,
                                    CONSTANTS.DIRT_PATH_MOODIMPROVE,
                                    CONSTANTS.DIRT_PATH_TIME,
                                    CONSTANTS.DIRT_PATH_TICKET,
                                    CONSTANTS.DIRT_PATH_SERVICE);
                            break;
                        case "Stone Path":
                            showObjectProperties(container, f, s,
                                    CONSTANTS.STONE_PATH_URL,
                                    CONSTANTS.STONE_PATH_PRICE,
                                    CONSTANTS.STONE_PATH_MOODIMPROVE,
                                    CONSTANTS.STONE_PATH_TIME,
                                    CONSTANTS.STONE_PATH_TICKET,
                                    CONSTANTS.STONE_PATH_SERVICE);
                            break;

                        case "Decorative path":
                            showObjectProperties(container, f, s,
                                    CONSTANTS.DECORATIVE_PATH_URL,
                                    CONSTANTS.DECORATIVE_PATH_PRICE,
                                    CONSTANTS.DECORATIVE_PATH_MOODIMPROVE,
                                    CONSTANTS.DECORATIVE_PATH_TIME,
                                    CONSTANTS.DECORATIVE_PATH_TICKET,
                                    CONSTANTS.DECORATIVE_PATH_SERVICE);
                            break;

                        case "Golden Path":
                            showObjectProperties(container, f, s,
                                    CONSTANTS.GOLDEN_PATH_URL,
                                    CONSTANTS.GOLDEN_PATH_PRICE,
                                    CONSTANTS.GOLDEN_PATH_MOODIMPROVE,
                                    CONSTANTS.GOLDEN_PATH_TIME,
                                    CONSTANTS.GOLDEN_PATH_TICKET,
                                    CONSTANTS.GOLDEN_PATH_SERVICE);
                            break;
                    }

                    f.setVisible(true);
                }
            });
            paths.add(i);
        }

        String[] foodsNames = {"Drinking Fountain", "Snack Bar", "Restaurant", "Cafe", "Hot-Dogs"};
        for (String s: foodsNames) {
            JMenuItem i = new JMenuItem(s);
            i.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JPanel container = new JPanel();
                    container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                    container.setLayout(new GridBagLayout());

                    f.getContentPane().removeAll();
                    f.getContentPane().repaint();
                    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    //f.setSize(500,500);
                    //f.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                    f.setLayout(new BorderLayout());
                    setBackground(f);

                    switch (s) {
                        case "Drinking Fountain":
                            showObjectProperties(container, f, s,
                                    CONSTANTS.DRINKING_FOUNTAIN_URL,
                                    CONSTANTS.DRINKING_FOUNTAIN_PRICE,
                                    CONSTANTS.DRINKING_FOUNTAIN_MOODIMPROVE,
                                    CONSTANTS.DRINKING_FOUNTAIN_TIME,
                                    CONSTANTS.DRINKING_FOUNTAIN_TICKET,
                                    CONSTANTS.DRINKING_FOUNTAIN_SERVICE);
                            break;
                        case "Snack Bar":
                            showObjectProperties(container, f, s,
                                    CONSTANTS.SNACK_BAR_URL,
                                    CONSTANTS.SNACK_BAR_PRICE,
                                    CONSTANTS.SNACK_BAR_MOODIMPROVE,
                                    CONSTANTS.SNACK_BAR_TIME,
                                    CONSTANTS.SNACK_BAR_TICKET,
                                    CONSTANTS.SNACK_BAR_SERVICE);
                            break;

                        case "Restaurant":
                            showObjectProperties(container, f, s,
                                    CONSTANTS.RESTAURANT_URL,
                                    CONSTANTS.RESTAURANT_PRICE,
                                    CONSTANTS.RESTAURANT_MOODIMPROVE,
                                    CONSTANTS.RESTAURANT_TIME,
                                    CONSTANTS.RESTAURANT_TICKET,
                                    CONSTANTS.RESTAURANT_SERVICE);
                            break;

                        case "Hot-Dogs":
                            showObjectProperties(container, f, s,
                                    CONSTANTS.HOT_DOGS_URL,
                                    CONSTANTS.HOT_DOGS_PRICE,
                                    CONSTANTS.HOT_DOGS_MOODIMPROVE,
                                    CONSTANTS.HOT_DOGS_TIME,
                                    CONSTANTS.HOT_DOGS_TICKET,
                                    CONSTANTS.HOT_DOGS_SERVICE);
                            break;

                        case "Cafe":
                            showObjectProperties(container, f, s,
                                    CONSTANTS.CAFE_URL,
                                    CONSTANTS.CAFE_PRICE,
                                    CONSTANTS.CAFE_MOODIMPROVE,
                                    CONSTANTS.CAFE_TIME,
                                    CONSTANTS.CAFE_TICKET,
                                    CONSTANTS.CAFE_SERVICE);
                            break;
                    }

                    f.setVisible(true);
                }
            });
            foods.add(i);
        }

        String[] gardenNames = {"Palm Tree", "Grass", "Flowers Shrub", "Mini Forest"};//, "Tall tree", "Thick tree"};
        for (String s: foodsNames) {
            JMenuItem i = new JMenuItem(s);
            gardens.add(i);
        }

        menuBar.add(amusements);
        menuBar.add(paths);
        menuBar.add(foods);
        menuBar.add(gardens);

        f.setJMenuBar(menuBar);
        f.setVisible(true);
        f.pack();
    }

    private void setBackground(JFrame menuframe) {
        //creating backgroung img
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./src/img/background3.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        menuframe.setContentPane(new JLabel(imageIcon));
        menuframe.getContentPane().setLayout(new BoxLayout(menuframe.getContentPane(), BoxLayout.PAGE_AXIS));
    }

    private JLabel createIcon(String src) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(src));

            //img = ImageIO.read(this.getClass().getResource(src));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Image dimg = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        JLabel l = new JLabel(imageIcon);

        return l;
    }

    private void showObjectProperties(JPanel container, JFrame f, String object_naming,
                                      String object_pic_url,
                                      String object_price,
                                      String object_mood_improvement,
                                      String object_time_to_build,
                                      String object_ticket_cost,
                                      String object_service) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;

        BufferedImage img = null;
        try {
            object_pic_url = "./src/" + object_pic_url;
            System.out.println(object_pic_url);
            img = ImageIO.read(new File(object_pic_url));
            //img = ImageIO.read(this.getClass().getResource(object_pic_url));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Image dimg = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        JLabel pic = new JLabel(imageIcon);
        GridBagConstraints constraintsPic = new GridBagConstraints();
        constraintsPic.fill = GridBagConstraints.HORIZONTAL;
        constraintsPic.weightx = 0.5;
        constraintsPic.weightx   = 1.0;
        constraintsPic.anchor    = GridBagConstraints.PAGE_START;
        constraintsPic.insets    = new Insets(10, 20, 20, 10);  // граница ячейки по Y
        constraintsPic.gridwidth = 8;    // размер кнопки в две ячейки
        constraintsPic.gridx = 0;      // нулевая ячейка таблицы по горизонтали
        constraintsPic.gridy = 1;      // нулевая ячейка таблицы по горизонтали
        container.add(pic, constraintsPic);

        JLabel naming = new JLabel(object_naming);
        naming.setFont(new Font("Bernard MT Condensed",Font.PLAIN,35));
        naming.setForeground(new Color(103, 78, 107));
        constraints.gridwidth = 3;
        constraints.gridx = 3;      // нулевая ячейка таблицы по горизонтали
        constraints.gridy = 0;      // нулевая ячейка таблицы по горизонтали
        container.add(naming, constraints);

        constraints.gridwidth = 1;

        JLabel price_icon = createIcon("./src/img/money.png");
        constraints.gridx = 3;      // нулевая ячейка таблицы по горизонтали
        constraints.gridy = 2;      // нулевая ячейка таблицы по горизонтали
        container.add(price_icon, constraints);
        JLabel price = new JLabel(object_price);
        price.setFont(new Font("Bernard MT Condensed",Font.PLAIN,16));
        price.setForeground(new Color(38, 35, 37));
        constraints.gridx = 4;      // нулевая ячейка таблицы по горизонтали
        constraints.gridy = 2;      // нулевая ячейка таблицы по горизонтали
        container.add(price, constraints);

        JLabel mood_icon = createIcon("./src/img/moodImprove.png");
        constraints.gridx = 0;      // нулевая ячейка таблицы по горизонтали
        constraints.gridy = 3;      // нулевая ячейка таблицы по горизонтали
        container.add(mood_icon, constraints);
        JLabel moodImprovement = new JLabel(object_mood_improvement);
        moodImprovement.setFont(new Font("Bernard MT Condensed",Font.PLAIN,16));
        moodImprovement.setForeground(new Color(38, 35, 37));
        constraints.gridx     = 1;    // нулевая ячейка по горизонтали
        constraints.gridy     = 3;    // первая ячейка по вертикали
        container.add(moodImprovement, constraints);

        JLabel time_icon = createIcon("./src/img/clock.png");
        constraints.gridx = 2;      // нулевая ячейка таблицы по горизонтали
        constraints.gridy = 3;      // нулевая ячейка таблицы по горизонтали
        container.add(time_icon, constraints);
        JLabel timeToBuild = new JLabel(object_time_to_build);
        timeToBuild.setFont(new Font("Bernard MT Condensed",Font.PLAIN,16));
        timeToBuild.setForeground(new Color(38, 35, 37));
        constraints.gridx     = 3;    // нулевая ячейка по горизонтали
        constraints.gridy     = 3;    // первая ячейка по вертикали
        container.add(timeToBuild, constraints);

        JLabel ticket_icon = createIcon("./src/img/ticket.png");
        constraints.gridx = 4;      // нулевая ячейка таблицы по горизонтали
        constraints.gridy = 3;      // нулевая ячейка таблицы по горизонтали
        container.add(ticket_icon, constraints);
        JLabel ticketCost = new JLabel(object_ticket_cost);
        ticketCost.setFont(new Font("Bernard MT Condensed",Font.PLAIN,16));
        ticketCost.setForeground(new Color(38, 35, 37));
        constraints.gridx     = 5;    // нулевая ячейка по горизонтали
        constraints.gridy     = 3;    // первая ячейка по вертикали
        container.add(ticketCost, constraints);

        JLabel service_icon = createIcon("./src/img/service.png");
        constraints.gridx = 6;      // нулевая ячейка таблицы по горизонтали
        constraints.gridy = 3;      // нулевая ячейка таблицы по горизонтали
        container.add(service_icon, constraints);
        JLabel serviceCost = new JLabel(object_service);
        serviceCost.setFont(new Font("Bernard MT Condensed",Font.PLAIN,16));
        serviceCost.setForeground(new Color(38, 35, 37));
        constraints.gridx     = 7;    // нулевая ячейка по горизонтали
        constraints.gridy     = 3;    // первая ячейка по вертикали
        container.add(serviceCost, constraints);

        JButton buy = new JButton("BUY");
        constraints.gridx     = 3;    // нулевая ячейка по горизонтали
        constraints.gridy     = 4;    // первая ячейка по вертикали
        constraints.gridwidth = 2;    // размер кнопки в две ячейки
        constraints.ipady     = 20;   // кнопка высокая
        constraints.insets = new Insets(10, 0, 10, 0);  // граница ячейки по Y
        buy.setFont(new Font("Bernard MT Condensed",Font.PLAIN,16));
        buy.setForeground(new Color(74, 59, 91));
        buy.setPreferredSize(new Dimension(100,60));
        buy.setBackground(new Color(168, 111, 151));

        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();

                switch(object_naming)
                {
                    case "Hot-Dogs":
                        Restaurant hotdog = new Restaurant(object_naming,100,5,new Point(2,1),20,new Point(0,0),"src/img/hot-dogs.jpg");
                        System.out.println(hotdog.img);

                        ge.buildings.add(hotdog);
                        //ge.repaint();
                        System.out.println(100);
                        break;
                    default:
                        System.out.println(50);
                        break;

                }

                ge.state = 1;
                //ge.repaint();
            }
        });

        container.add(buy, constraints);
        container.setOpaque(false);

        f.getContentPane().add(container, BorderLayout.CENTER);
    }
}