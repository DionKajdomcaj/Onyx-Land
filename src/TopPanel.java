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

    JPanel cashIcon;
    JPanel moodIcon;
    JPanel numberOfVisitorsIcon;

    TopPanel() {
        this.setLayout(new GridLayout(0, 8, 10, 0));

        moneyOfPlayer = new JLabel();
        moneyOfPlayer.setText("2000");
        moneyOfPlayer.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));

        numberOfVisitors = new JLabel();
        numberOfVisitors.setText("20");
        numberOfVisitors.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));

        averageMood = new JLabel();
        averageMood.setText("500");
        averageMood.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));

        cashIcon = new JPanel();
        moodIcon = new JPanel();
        numberOfVisitorsIcon = new JPanel();

        this.add(cashIcon);
        this.add(moneyOfPlayer);
        this.add(moodIcon);
        this.add(averageMood);
        this.add(numberOfVisitorsIcon);
        this.add(numberOfVisitors);

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
