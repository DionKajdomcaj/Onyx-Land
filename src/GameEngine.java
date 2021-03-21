import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


    public GameEngine(){
        super();
        player=new Player();
        this.setLayout(new GridBagLayout());

        moneyOfPlayer = new JLabel();
        moneyOfPlayer.setText(String.valueOf(player.getamountOfMoney()));


        /*GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = Grid
        gbc.insets = new Insets(5,0, 2, 0);*/




        JButton Menu = new JButton("Menu");
        Menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFrame f= new JFrame("PopupMenu Example");
                final JPopupMenu popupmenu = new JPopupMenu("Edit");
                JMenuItem building = new JMenuItem("Building");
                popupmenu.add(building);
            }
        });


        JButton Settings = new JButton("Settings");
        Settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JPanel container = new JPanel();
        BorderLayout b = new BorderLayout();
        container.add(Menu, b.SOUTH);
        container.add(Settings, b.SOUTH);


        /*
        add(Menu,gbc);
        add(Settings,gbc);
        System.out.println(3);*/



    }


}
