import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;

public class MenuPanel extends JPanel{
    protected JButton newGameButton;
    protected JButton rulesButton;
    protected JButton exitButton;
    protected JButton startButton;
    protected JTextField playerName;
    protected JTextField parkName;
    protected JLabel nameGame;
    protected JPanel rulesContainer;
    protected JLabel rules;

    public GameEngine gameng;

    public MenuPanel(int i) { // int i - we will have 3 start windows, this i represents number of each one
                             //i = 1 => newgame/rules/exit; i = 2 => player's name/park name/start; i = 3 => game rules

        switch (i) {
            case 1:
                window1();
                break;
            case 2:
                window2();
                break;
            case 3:
                window3();
                break;
        }
    }
    private void window1() {
       // this.setLayout(new BorderLayout(100,100));
       // this.setLayout(new FlowLayout());
        //background=new ImageIcon("images/menuFrameBcg.jpg").getImage();

        nameGame = new JLabel("Onyx Land");
        nameGame.setFont(new Font("Bernard MT Condensed",Font.PLAIN,35));
        nameGame.setForeground(new Color(212, 210, 210));

        newGameButton=new JButton("New Game");
        newGameButton.setFont(new Font("Bernard MT Condensed",Font.PLAIN,16));
        newGameButton.setForeground(new Color(38, 35, 37));
        newGameButton.setPreferredSize(new Dimension(150,50));
        newGameButton.setBackground(new Color(168, 111, 151));

        rulesButton=new JButton("Rules");
        rulesButton.setFont(new Font("Bernard MT Condensed",Font.PLAIN,16));
        rulesButton.setForeground(new Color(38, 35, 37));
        rulesButton.setPreferredSize(new Dimension(150,50));
        rulesButton.setBackground(new Color(168, 111, 151));

        exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(150,50));
        exitButton.setFont(new Font("Bernard MT Condensed",Font.PLAIN,16));
        exitButton.setForeground(new Color(38, 35, 37));
        exitButton.setBackground(new Color(168, 111, 151));


        //this.add(newGameButton,BorderLayout.G);
       // this.add(rulesButton,BorderLayout.CENTER);
        //this.add(exitButton,BorderLayout.SOUTH);

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5,0, 2, 0);

        GridBagConstraints gbc0 = new GridBagConstraints();
        gbc0.gridwidth = GridBagConstraints.REMAINDER;
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.insets = new Insets(0,0, 100, 0);

        add(nameGame, gbc0);
        add(newGameButton, gbc);
        add(rulesButton, gbc);
        add(exitButton, gbc);

        this.setOpaque(false);


    }
    private void window2() {
        nameGame = new JLabel("Onyx Land");
        nameGame.setFont(new Font("Bernard MT Condensed",Font.PLAIN,35));
        nameGame.setForeground(new Color(212, 210, 210));

        playerName = new JTextField("Player1");
        playerName.setFont(new Font("Berlin Sans FB",Font.PLAIN,20));
        playerName.setBackground(new Color(108, 61, 92));
        playerName.setForeground(new Color(203, 189, 197));
        playerName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        parkName = new JTextField("Disneyland-2");
        parkName.setFont(new Font("Berlin Sans FB",Font.PLAIN,20));
        parkName.setBackground(new Color(108, 61, 92));
        parkName.setForeground(new Color(203, 189, 197));
        parkName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        startButton = new JButton("START");
        startButton.setPreferredSize(new Dimension(150,50));
        startButton.setFont(new Font("Bernard MT Condensed",Font.PLAIN,20));
        startButton.setForeground(new Color(38, 35, 37));
        startButton.setBackground(new Color(168, 111, 151));

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5,0, 4, 0);

        GridBagConstraints gbc0 = new GridBagConstraints();
        gbc0.gridwidth = GridBagConstraints.REMAINDER;
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.insets = new Insets(0,0, 100, 0);

        add(nameGame, gbc0);
        add(playerName, gbc);
        add(parkName, gbc);
        add(startButton, gbc);

        this.setOpaque(false);



    }
    private void window3() {
        String rulesText = "<html><h1 style=\"text-align: center;\"> Onyx Land Rules </h1><br> <p style=\"color:red;font-size:10px;text-align: center;\"> Press New Game to start building your land after typing your name and the name of your magical land. </p> <p style=\"color:red;font-size:10px;text-align: center;\"> You can also exit the Game from the exit button . As you are here you know already how to enter the Rules of the game .</p> \n" +
                "<p style=\"color:red;font-size:10px;text-align: center;\">A player has a pocket money appeared in the top left corner as well as number of visitors , also the average mood of the visitors . </p>\n" +
                "<br>\n" +
                "<br>\n" +
                "<p style=\"font-size:10px;\"> To play the game probably please read the instructions below : </p>\n" +
                "<h3 style=\"color:red;\" > 1) As a player : </h3><ul><li>Build (Restaurants, games, gardens, ATMs ) from the Menu button that appears in the top right corner.</li> <br><li> The player can also build paths which are the only way to reach the buildings by visitors. A player can only place a building in free space.</li><br><li>Choose the entry price for the visitors , As well as any entry fee for each building including the food and drinks prices by pressing the Menu button .</li><br><li>A player can start the game after open the entrance </li><br><li>Optional : choosing number of visitors, Thieves or make it randomly selected by the game from the Menu button</li><br><li>A player can enjoy the game by customizing the ( Audio , video ) for the game , It can be reachable by the settings button.</li></ul><h3 style=\"color:red;\"> 2) As a real-time simulation game : </h3><ul><li>Visitors will be walking only through the paths. Below characteristic will be controlled by the game :<ol> <li>Pocket money</li><li> Average mood</li> <li>Choice for games or food</li> <li> choice for throwing the waste</li></ol> </li><br><li>Staff.Staff (Staff.Staff.Cleaner, Staff.Staff.Repairman) also controlled by the game in specific conditions . <ul><li> Cleaners can clean the paths if there will be waste more than specific level </li><li> Repairmen can repair games if they are broken.</li></ul></li><br><li> Number of thieves and thier skills controlled by the game  </li><br><li>The average mood of the visitors can be controlled by the game depends on : <ol> <li>The cleanness level of the land</li> <li> Any experience for a robbery</li> <li> The quality of food, games and drinks</li> </ol> </li></ul><p style=\"color:red;\"> * The player loses the game if he/she does not have any money left or there are no more visitors </p><br><h2 style=\"font-size:24px;text-align:center;\" > GOOD LUCK <h2>\n" +
                "</html>\n" +
                "\n";

        JFrame newRules = new JFrame();
        newRules.setTitle("Onyx Land Rules");
        JLabel rules = new JLabel(rulesText);
        rules.setLabelFor(rules);
        JScrollPane scroller = new JScrollPane(rules, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        newRules.add(scroller);
        newRules.setSize(1000,1000);
        newRules.setVisible(true);

// We don't need to another window . I create separate Jframe to handle the rules.
//        JButton rulesContainerButton = new JButton("Back");
//        rulesContainerButton.setFont(new Font("Bernard MT Condensed",Font.PLAIN,16));
//        rulesContainerButton.setForeground(new Color(38, 35, 37));
//        rulesContainerButton.setPreferredSize(new Dimension(150,50));
//        rulesContainerButton.setBackground(new Color(168, 111, 151));
//
//
//        rulesContainer = new JPanel();
//        rules = new JLabel(rulesText);
//        rules.setFont(new Font("Berlin Sans FB",Font.PLAIN,20));
//        rules.setForeground(new Color(38, 35, 37));
//        rules.setBackground(new Color(208, 158, 170));
//        rules.setLabelFor(rules);
//
//        rulesContainer.add(rules);
//
//        nameGame = new JLabel("Onyx Land");
//        nameGame.setFont(new Font("Bernard MT Condensed",Font.PLAIN,35));
//        nameGame.setForeground(new Color(212, 210, 210));
//
//        this.setLayout(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridwidth = GridBagConstraints.REMAINDER;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.insets = new Insets(100,0, 100, 0);
//
//        GridBagConstraints gbc0 = new GridBagConstraints();
//        gbc0.gridwidth = GridBagConstraints.REMAINDER;
//        gbc0.fill = GridBagConstraints.HORIZONTAL;
//        gbc0.insets = new Insets(0,0, 100, 0);
//
//        nameGame.setHorizontalAlignment(SwingConstants.CENTER);
//        add(nameGame, gbc0);
//        add(rulesContainerButton, gbc);
//        this.setOpaque(false);
    }
}
