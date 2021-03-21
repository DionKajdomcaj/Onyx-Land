import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                final JFrame f = new JFrame("PopupMenu Example");
                final JPopupMenu popupmenu = new JPopupMenu("Edit");
                JMenuItem building = new JMenuItem("Building");
                popupmenu.add(building);
            }
        });


        settingsButton = new JButton("Settings");
        this.add(settingsButton);
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
