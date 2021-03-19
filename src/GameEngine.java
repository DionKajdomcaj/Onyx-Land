import javax.swing.*;
import java.util.ArrayList;

public class GameEngine extends JPanel {
    Player player;
    ArrayList<Visitor> visitors;
    Policeman policeman;
    Thief thief;
    Repairman repairman;
    Security security;
    Cleaner cleaner;
    ArrayList<Buildings> buildings;
    ArrayList<Staff>staff;


    public GameEngine(){
        super();
        player=new Player();



    }


}
