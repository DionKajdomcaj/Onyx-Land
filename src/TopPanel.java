import Buildings.Buildings;
import Staff.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TopPanel extends JPanel {
    JButton menuButton;
    JButton settingsButton;

    public JLabel moneyOfPlayer;
    public JLabel numberOfVisitors;
    public JLabel averageMood;
    public MenuPanel menupanel;
    public JFrame menuframe;
    JLabel moneyOfPlayer_icon;
    JLabel averageMoodIcon;
    JLabel numberOfVisitorsIcon;

    public TopPanel(GameEngine g) {
        this.setLayout(new GridLayout(0, 8, 10, 0));
        moneyOfPlayer = new JLabel();
        moneyOfPlayer.setText(String.valueOf(g.player.getamountOfMoney()));
        moneyOfPlayer.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
        //moneyOfPlayer.setBackground(Color.GREEN);
        //moneyOfPlayer.setOpaque(true);
       //moneyOfPlayer.setPreferredSize(new Dimension(10,10));
       //this.getContentPane().setLayout(new FlowLayout());
        //this.add(moneyOfPlayer);
       //this.setVisible(true);


        moneyOfPlayer_icon = new JLabel();
        moneyOfPlayer_icon.setIcon(new ImageIcon("src/img/money.png"));
        //moneyOfPlayer.setPreferredSize(new Dimension(20,20));

        numberOfVisitors = new JLabel();
        numberOfVisitors.setText(String.valueOf(g.visitors.size()));
        numberOfVisitors.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));

        numberOfVisitorsIcon = new JLabel();
        numberOfVisitorsIcon.setIcon(new ImageIcon("src/img/visitors.png"));

        averageMood = new JLabel();
        averageMood.setText("500");
        averageMood.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));

        averageMoodIcon = new JLabel();
        averageMoodIcon.setIcon(new ImageIcon("src/img/mood.png"));


        this.add(moneyOfPlayer_icon);
        this.add(moneyOfPlayer);
        this.add(numberOfVisitorsIcon);
        this.add(numberOfVisitors);
        this.add(averageMoodIcon);
        this.add(averageMood);


        menuButton = new JButton("Menu");
        menuButton.setFont(new Font("Bernard MT Condensed",Font.PLAIN,16));
        menuButton.setForeground(new Color(74, 59, 91));
        //menuButton.setPreferredSize(new Dimension(100,60));
        menuButton.setBackground(new Color(168, 111, 151));
        this.add(menuButton);
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu buildMenuFunction = new Menu(g,moneyOfPlayer);
//                JFrame f = new JFrame("Menu");
//                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                f.setSize(500,500);
//                //f.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
//                f.setLayout(new BorderLayout());
//                setBackground(f);
//
//                /*
//                GridBagConstraints constraints = new GridBagConstraints();
//                constraints.fill = GridBagConstraints.HORIZONTAL;
//                constraints.weightx = 0.5;
//
//
//
//                BufferedImage img = null;
//                try {
//                    img = ImageIO.read(this.getClass().getResource("img/RolerCoaster.JPG"));
//                } catch (IOException ioException) {
//                    ioException.printStackTrace();
//                }
//                Image dimg = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
//                ImageIcon imageIcon = new ImageIcon(dimg);
//                JLabel pic = new JLabel(imageIcon);
//                GridBagConstraints constraintsPic = new GridBagConstraints();
//                constraintsPic.fill = GridBagConstraints.HORIZONTAL;
//                constraintsPic.weightx = 0.5;
//                constraintsPic.weightx   = 1.0;
//                constraintsPic.anchor    = GridBagConstraints.PAGE_START;
//                constraintsPic.insets    = new Insets(10, 20, 20, 10);  // граница ячейки по Y
//                constraintsPic.gridwidth = 8;    // размер кнопки в две ячейки
//                constraintsPic.gridx = 0;      // нулевая ячейка таблицы по горизонтали
//                constraintsPic.gridy = 1;      // нулевая ячейка таблицы по горизонтали
//                container.add(pic, constraintsPic);
//
//                JLabel naming = new JLabel("Roler Coaster");
//                naming.setFont(new Font("Bernard MT Condensed",Font.PLAIN,35));
//                naming.setForeground(new Color(212, 210, 210));
//                constraints.gridwidth = 3;
//                constraints.gridx = 3;      // нулевая ячейка таблицы по горизонтали
//                constraints.gridy = 0;      // нулевая ячейка таблицы по горизонтали
//                container.add(naming, constraints);
//
//                constraints.gridwidth = 1;
//
//                JLabel price_icon = createIcon("img/money.png");
//                constraints.gridx = 3;      // нулевая ячейка таблицы по горизонтали
//                constraints.gridy = 2;      // нулевая ячейка таблицы по горизонтали
//                container.add(price_icon, constraints);
//                JLabel price = new JLabel("500");
//                constraints.gridx = 4;      // нулевая ячейка таблицы по горизонтали
//                constraints.gridy = 2;      // нулевая ячейка таблицы по горизонтали
//                container.add(price, constraints);
//
//                JLabel mood_icon = createIcon("img/moodImprove.png");
//                constraints.gridx = 0;      // нулевая ячейка таблицы по горизонтали
//                constraints.gridy = 3;      // нулевая ячейка таблицы по горизонтали
//                container.add(mood_icon, constraints);
//                JLabel moodImprovement = new JLabel("20");
//                constraints.gridx     = 1;    // нулевая ячейка по горизонтали
//                constraints.gridy     = 3;    // первая ячейка по вертикали
//                container.add(moodImprovement, constraints);
//
//                JLabel time_icon = createIcon("img/clock.png");
//                constraints.gridx = 2;      // нулевая ячейка таблицы по горизонтали
//                constraints.gridy = 3;      // нулевая ячейка таблицы по горизонтали
//                container.add(time_icon, constraints);
//                JLabel timeToBuild = new JLabel("2:40");
//                constraints.gridx     = 3;    // нулевая ячейка по горизонтали
//                constraints.gridy     = 3;    // первая ячейка по вертикали
//                container.add(timeToBuild, constraints);
//
//                JLabel ticket_icon = createIcon("img/ticket.png");
//                constraints.gridx = 4;      // нулевая ячейка таблицы по горизонтали
//                constraints.gridy = 3;      // нулевая ячейка таблицы по горизонтали
//                container.add(ticket_icon, constraints);
//                JLabel ticketCost = new JLabel("20");
//                constraints.gridx     = 5;    // нулевая ячейка по горизонтали
//                constraints.gridy     = 3;    // первая ячейка по вертикали
//                container.add(ticketCost, constraints);
//
//                JLabel service_icon = createIcon("img/service.png");
//                constraints.gridx = 6;      // нулевая ячейка таблицы по горизонтали
//                constraints.gridy = 3;      // нулевая ячейка таблицы по горизонтали
//                container.add(service_icon, constraints);
//                JLabel serviceCost = new JLabel("45");
//                constraints.gridx     = 7;    // нулевая ячейка по горизонтали
//                constraints.gridy     = 3;    // первая ячейка по вертикали
//                container.add(serviceCost, constraints);
//
//                JButton buy = new JButton("Buy");
//                constraints.gridx     = 3;    // нулевая ячейка по горизонтали
//                constraints.gridy     = 4;    // первая ячейка по вертикали
//                constraints.gridwidth = 2;    // размер кнопки в две ячейки
//                constraints.ipady     = 20;   // кнопка высокая
//                constraints.insets = new Insets(10, 0, 10, 0);  // граница ячейки по Y
//                container.add(buy, constraints);
//                container.setOpaque(false);
//
//                f.getContentPane().add(container, BorderLayout.CENTER);*/
//
//                /*showObjectProperties(container, f, "Roller Coaster", CONSTANTS.ROLER_COASTER_PRICE,
//                        CONSTANTS.ROLER_COASTER_MOODIMPROVE,
//                        CONSTANTS.ROLER_COASTER_TIME,
//                        CONSTANTS.ROLER_COASTER_TICKET,
//                        CONSTANTS.ROLER_COASTER_SERVICE);*/
//
//                //creating menu
//                JMenuBar menuBar = new JMenuBar();
//                JMenu amusements = new JMenu("Amusements");
//                JMenu paths = new JMenu("Paths");
//                JMenu foods = new JMenu("Food Courts");
//                JMenu gardens = new JMenu("Gardens");
//
//                String[] amusementsNames = {"Roller Coaster", "Swing", "Wooden Chute", "Trampoline" };//, "Labyrinth", "Stone Chute", "Football", "Jump Tower", "Carousel", "Bungee Jump", "Drop Tower", "Laugh room"};
//                for (String s: amusementsNames) {
//                    JMenuItem i = new JMenuItem(s);
//                    i.addActionListener(new ActionListener() {
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            JPanel container = new JPanel();
//                            container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
//                            container.setLayout(new GridBagLayout());
//
//                            f.getContentPane().removeAll();
//                            f.getContentPane().repaint();
//                            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                            //f.setSize(500,500);
//                            //f.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
//                            f.setLayout(new BorderLayout());
//                            setBackground(f);
//
//                            switch (s) {
//                                case "Roller Coaster":
//                                    showObjectProperties(container, f, s, CONSTANTS.ROLER_COASTER_URL,
//                                                                          CONSTANTS.ROLER_COASTER_PRICE,
//                                                                          CONSTANTS.ROLER_COASTER_MOODIMPROVE,
//                                                                          CONSTANTS.ROLER_COASTER_TIME,
//                                                                          CONSTANTS.ROLER_COASTER_TICKET,
//                                                                          CONSTANTS.ROLER_COASTER_SERVICE);
//                                    break;
//                                case "Swing":
//                                    showObjectProperties(container, f, s,
//                                            CONSTANTS.SWING_URL,
//                                            CONSTANTS.SWING_PRICE,
//                                            CONSTANTS.SWING_MOODIMPROVE,
//                                            CONSTANTS.SWING_TIME,
//                                            CONSTANTS.SWING_TICKET,
//                                            CONSTANTS.SWING_SERVICE);
//                                    break;
//
//                                case "Wooden Chute":
//                                    showObjectProperties(container, f, s,
//                                            CONSTANTS.CHUTE_URL,
//                                            CONSTANTS.CHUTE_PRICE,
//                                            CONSTANTS.CHUTE_MOODIMPROVE,
//                                            CONSTANTS.CHUTE_TIME,
//                                            CONSTANTS.CHUTE_TICKET,
//                                            CONSTANTS.CHUTE_SERVICE);
//                                    break;
//
//                                case "Trampoline":
//                                    showObjectProperties(container, f, s,
//                                            CONSTANTS.TRAMPOLINE_URL,
//                                            CONSTANTS.TRAMPOLINE_PRICE,
//                                            CONSTANTS.TRAMPOLINE_MOODIMPROVE,
//                                            CONSTANTS.TRAMPOLINE_TIME,
//                                            CONSTANTS.TRAMPOLINE_TICKET,
//                                            CONSTANTS.TRAMPOLINE_SERVICE);
//                                    break;
//                            }
//
//                            f.setVisible(true);
//                        }
//                    });
//                    amusements.add(i);
//                }
//
//                String[] pathsNames = {"Dirt Path", "Stone Path", "Decorative path", "Golden Path"};
//                for (String s: pathsNames) {
//                    JMenuItem i = new JMenuItem(s);
//                    paths.add(i);
//                }
//
//                String[] foodsNames = {"Drinking Fountain", "Snack Bar", "Restaurant", "Cafe", "Hot-Dogs"};
//                for (String s: foodsNames) {
//                    JMenuItem i = new JMenuItem(s);
//                    foods.add(i);
//                }
//
//                String[] gardenNames = {"Palm Tree", "Grass", "Flowers Shrub", "Mini Forest"};//, "Tall tree", "Thick tree"};
//                for (String s: foodsNames) {
//                    JMenuItem i = new JMenuItem(s);
//                    gardens.add(i);
//                }
//
//                menuBar.add(amusements);
//                menuBar.add(paths);
//                menuBar.add(foods);
//                menuBar.add(gardens);
//
//                f.setJMenuBar(menuBar);
//
//                /*JPanel popupmenu = new JPanel();
//                popupmenu.setLayout(new BoxLayout(popupmenu,BoxLayout.X_AXIS));
//                JButton building = new JButton("Building");
//                building.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        JFrame restaurants= new JFrame("Restaurants");
//                        //restaurants.getContentPane().setLayout(new BoxLayout(f,BoxLayout.Y_AXIS));
//                        restaurants.setSize(500,500);
//                        JPanel sidePop = new JPanel();
//                        setBackground(restaurants);
//                        sidePop.setLayout(new BoxLayout(sidePop,BoxLayout.X_AXIS));
//
//                        JButton securityBuilding = new JButton("Security Building");
//                        JButton Hotdog = new JButton("Hot Dog");
//                        JButton sweetShop = new JButton("Candy Shop");
//                        JButton IceCreamShop= new JButton("Ice Cream Shop");
//                        JButton atm = new JButton("ATM");
//                        JButton backbutton = new JButton("Back");
//                        backbutton.addActionListener(new ActionListener() {
//                            @Override
//                            public void actionPerformed(ActionEvent e) {
//                                restaurants.setVisible(false);
//                                f.setVisible(true);
//                            }
//                        });
//                        JPanel bottom=new JPanel();
//                        bottom.setLayout(new BoxLayout(bottom,BoxLayout.X_AXIS));
//
//                        //sidePop.add(backbutton);
//                        sidePop.add(atm);
//                        sidePop.add(securityBuilding);
//                        sidePop.add(Hotdog);
//                        sidePop.add(IceCreamShop);
//                        sidePop.add(sweetShop);
//                        bottom.add(backbutton);
//
//                       // f.getContentPane().removeAll();
//                       // f.getContentPane().add(sidePop);
//
//                        restaurants.getContentPane().add(sidePop);
//                        restaurants.getContentPane().add(bottom);
//
//                        f.setVisible(false);
//                        restaurants.setVisible(true);
//                        restaurants.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//                        restaurants.pack();
//                    }
//                });
//                JButton garden = new JButton("Garden");
//                garden.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        JFrame gardens= new JFrame("Garden");
//
//                        JPanel sidepop = new JPanel();
//                        setBackground(gardens);
//                        sidepop.setLayout(new BoxLayout(sidepop,BoxLayout.X_AXIS));
//                        JButton tree = new JButton("Tree");
//                        JButton grass = new JButton("Grass");
//                        JButton shrubs = new JButton("Shrubs");
//                        JPanel bottom = new JPanel();
//                        bottom.setLayout(new BoxLayout(bottom,BoxLayout.X_AXIS));
//                        JButton back = new JButton("Back");
//                        back.addActionListener(new ActionListener() {
//                            @Override
//                            public void actionPerformed(ActionEvent e) {
//                                gardens.setVisible(false);
//                                f.setVisible(true);
//                            }
//                        });
//                        bottom.add(back);
//                        sidepop.add(tree);
//                        sidepop.add(grass);
//                        sidepop.add(shrubs);
//                        gardens.getContentPane().add(sidepop);
//                        gardens.getContentPane().add(bottom);
//                        f.setVisible(false);
//                        gardens.setVisible(true);
//                        gardens.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                        gardens.pack();
//
//
//
//                    }
//                });
//                JButton staff = new JButton("Staff");
//                staff.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        JFrame staffHire= new JFrame("Staff");
//
//                        JPanel sidepop = new JPanel();
//                        setBackground(staffHire);
//                        sidepop.setLayout(new BoxLayout(sidepop,BoxLayout.X_AXIS));
//                        JButton cleanerB = new JButton("Cleaner");
//                        JButton repairmanB = new JButton("Repairman");
//                        JButton securityB = new JButton("Security");
//                        JPanel bottom = new JPanel();
//                        bottom.setLayout(new BoxLayout(bottom,BoxLayout.X_AXIS));
//                        JButton back = new JButton("Back");
//                        back.addActionListener(new ActionListener() {
//                            @Override
//                            public void actionPerformed(ActionEvent e) {
//                                staffHire.setVisible(false);
//                                f.setVisible(true);
//                            }
//                        });
//                        bottom.add(back);
//                        sidepop.add(cleanerB);
//                        sidepop.add(repairmanB);
//                        sidepop.add(securityB);
//                        staffHire.getContentPane().add(sidepop);
//                        staffHire.getContentPane().add(bottom);
//                        f.setVisible(false);
//                        staffHire.setVisible(true);
//                        staffHire.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                        staffHire.pack();
//
//                    }
//                });
//                JButton pathB = new JButton("Path");
//
//                popupmenu.add(building);
//                popupmenu.add(garden);
//                popupmenu.add(staff);
//                popupmenu.add(pathB);
//
//                f.getContentPane().add(popupmenu);*/
//
//                f.setVisible(true);
//                f.pack();
            }
        });

        settingsButton = new JButton("Settings");
        settingsButton.setFont(new Font("Bernard MT Condensed",Font.PLAIN,16));
        settingsButton.setForeground(new Color(74, 59, 91));
        //settingsButton.setPreferredSize(new Dimension(100,60));
        settingsButton.setBackground(new Color(168, 111, 151));
        this.add(settingsButton);
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame("PopupMenu ");
                f.setSize(400,400);
                f.setLayout(new BoxLayout(f,BoxLayout.Y_AXIS));
                JPanel popupmenu = new JPanel();
                popupmenu.setLayout(new BoxLayout(popupmenu,BoxLayout.X_AXIS));
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setBackground(f);
                JButton Audio = new JButton("Audio");
                Audio.setFont(new Font("Bernard MT Condensed",Font.PLAIN,16));
                Audio.setForeground(new Color(38, 35, 37));
                Audio.setPreferredSize(new Dimension(150,50));
                Audio.setBackground(new Color(168, 111, 151));

                Audio.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JPanel sidePop = new JPanel();
                        sidePop.setLayout(new BoxLayout(sidePop,BoxLayout.Y_AXIS));
                        JButton Hotdog = new JButton("Hot Dog");
                        JButton sweetShop = new JButton("Candy Shop");
                        sidePop.add(Hotdog);
                        sidePop.add(sweetShop);
                        f.getContentPane().add(sidePop);

                    }
                });
                JButton video = new JButton("Video");
                video.setFont(new Font("Bernard MT Condensed",Font.PLAIN,16));
                video.setForeground(new Color(38, 35, 37));
                video.setPreferredSize(new Dimension(150,50));
                video.setBackground(new Color(168, 111, 151));

                JButton rulesButton = new JButton("Rules");
                rulesButton.setFont(new Font("Bernard MT Condensed",Font.PLAIN,16));
                rulesButton.setForeground(new Color(38, 35, 37));
                rulesButton.setPreferredSize(new Dimension(150,50));
                rulesButton.setBackground(new Color(168, 111, 151));


                rulesButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        menupanel = new MenuPanel(3);
                        menuframe.getContentPane().add(menupanel);

                    }
                });

                popupmenu.add(Audio);
                popupmenu.add(video);
                popupmenu.add(rulesButton);
                f.getContentPane().add(popupmenu);
                f.setVisible(true);
                f.pack();
            }
        });
    }
    private void setBackground(JFrame menuframe) {
        //creating backgroung img
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/img/background3.jpg"));
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
            img = ImageIO.read(this.getClass().getResource(src));
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
        System.out.println(object_naming);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;

        BufferedImage img = null;
        try {
            img = ImageIO.read(this.getClass().getResource(object_pic_url));
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

        JLabel price_icon = createIcon("img/money.png");
        constraints.gridx = 3;      // нулевая ячейка таблицы по горизонтали
        constraints.gridy = 2;      // нулевая ячейка таблицы по горизонтали
        container.add(price_icon, constraints);
        JLabel price = new JLabel(object_price);
        price.setFont(new Font("Bernard MT Condensed",Font.PLAIN,16));
        price.setForeground(new Color(38, 35, 37));
        constraints.gridx = 4;      // нулевая ячейка таблицы по горизонтали
        constraints.gridy = 2;      // нулевая ячейка таблицы по горизонтали
        container.add(price, constraints);

        JLabel mood_icon = createIcon("img/moodImprove.png");
        constraints.gridx = 0;      // нулевая ячейка таблицы по горизонтали
        constraints.gridy = 3;      // нулевая ячейка таблицы по горизонтали
        container.add(mood_icon, constraints);
        JLabel moodImprovement = new JLabel(object_mood_improvement);
        moodImprovement.setFont(new Font("Bernard MT Condensed",Font.PLAIN,16));
        moodImprovement.setForeground(new Color(38, 35, 37));
        constraints.gridx     = 1;    // нулевая ячейка по горизонтали
        constraints.gridy     = 3;    // первая ячейка по вертикали
        container.add(moodImprovement, constraints);

        JLabel time_icon = createIcon("img/clock.png");
        constraints.gridx = 2;      // нулевая ячейка таблицы по горизонтали
        constraints.gridy = 3;      // нулевая ячейка таблицы по горизонтали
        container.add(time_icon, constraints);
        JLabel timeToBuild = new JLabel(object_time_to_build);
        timeToBuild.setFont(new Font("Bernard MT Condensed",Font.PLAIN,16));
        timeToBuild.setForeground(new Color(38, 35, 37));
        constraints.gridx     = 3;    // нулевая ячейка по горизонтали
        constraints.gridy     = 3;    // первая ячейка по вертикали
        container.add(timeToBuild, constraints);

        JLabel ticket_icon = createIcon("img/ticket.png");
        constraints.gridx = 4;      // нулевая ячейка таблицы по горизонтали
        constraints.gridy = 3;      // нулевая ячейка таблицы по горизонтали
        container.add(ticket_icon, constraints);
        JLabel ticketCost = new JLabel(object_ticket_cost);
        ticketCost.setFont(new Font("Bernard MT Condensed",Font.PLAIN,16));
        ticketCost.setForeground(new Color(38, 35, 37));
        constraints.gridx     = 5;    // нулевая ячейка по горизонтали
        constraints.gridy     = 3;    // первая ячейка по вертикали
        container.add(ticketCost, constraints);

        JLabel service_icon = createIcon("img/service.png");
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

                /*switch (object_naming)
                {

                }*/

                //ge.state = 1;
                //ge.repaint();
            }
        });

        container.add(buy, constraints);
        container.setOpaque(false);

        f.getContentPane().add(container, BorderLayout.CENTER);
    }
}
