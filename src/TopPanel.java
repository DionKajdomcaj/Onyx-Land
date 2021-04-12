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
    Player player;
    ArrayList<Visitor> visitors;
    Policeman policeman;
    Thief thief;
    Repairman repairman;
    Security security;
    Cleaner cleaner;
    ArrayList<Buildings> buildings;
    ArrayList<Staff>staff;
    JButton menuButton;
    JButton settingsButton;

    JLabel moneyOfPlayer;
    JLabel numberOfVisitors;
    JLabel averageMood;
    JLabel moneyOfPlayer_icon;
    JLabel averageMoodIcon;
    JLabel numberOfVisitorsIcon;

    TopPanel() {
        this.setLayout(new GridLayout(0, 8, 10, 0));

        moneyOfPlayer = new JLabel();
        moneyOfPlayer.setText("2000");
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
        numberOfVisitors.setText("20");
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
        this.add(menuButton);
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame("PopupMenu ");
                f.setSize(400,400);
                f.setLayout(new BoxLayout(f,BoxLayout.Y_AXIS));
                JPanel popupmenu = new JPanel();
                popupmenu.setLayout(new BoxLayout(popupmenu,BoxLayout.X_AXIS));
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setBackground(f);
                JButton building = new JButton("Building");
                building.addActionListener(new ActionListener() {
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
                JButton garden = new JButton("Garden");
                JButton staff = new JButton("Staff");
                popupmenu.add(building);
                popupmenu.add(garden);
                popupmenu.add(staff);
                f.getContentPane().add(popupmenu);
                f.setVisible(true);
                f.pack();
            }
        });


        settingsButton = new JButton("Settings");
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
                JButton building = new JButton("Audio");
                building.addActionListener(new ActionListener() {
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
                JButton garden = new JButton("Video");
                JButton staff = new JButton("Rules");
                popupmenu.add(building);
                popupmenu.add(garden);
                popupmenu.add(staff);
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
            img = ImageIO.read(new File("src/img/background2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        menuframe.setContentPane(new JLabel(imageIcon));
        menuframe.getContentPane().setLayout(new BoxLayout(menuframe.getContentPane(), BoxLayout.PAGE_AXIS));
    }

}
