import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OnyxLandGUI {
    public GameEngine gameng;
    public JFrame menuframe;
    public JFrame gameFrame;
    public MenuPanel menupanel;
    public JLabel moneyOfPlayer;
    public JLabel nameGame;
    private Image background;
    private Field[][] cells;
    private Player player;

    public OnyxLandGUI(int i){
        if (i == 1) { //if we want to display start menu settings
            menuframe = new JFrame("OnyxLand");
            menuframe.setSize(500, 500);
            menuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBackground(menuframe);

            menupanel = new MenuPanel(1);
            menuframe.getContentPane().add(menupanel);
            menuframe.setVisible(true);

            //if (menupanel.newGameButton != null) {
                menupanel.newGameButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        menuframe.getContentPane().removeAll();
                        menuframe.getContentPane().repaint();

                        menuframe.setSize(500, 500);
                        menuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        menupanel = new MenuPanel(2);
                        menuframe.getContentPane().add(menupanel);

                        menupanel.startButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                gameng = new GameEngine();
                                System.out.println(1);
                                menuframe.setVisible(false);

                                OnyxLandGUI gui = new OnyxLandGUI(2);

                                //menuframe.getContentPane().removeAll();
                                //menuframe.getContentPane().repaint();
                            }
                        });

                        menuframe.setVisible(true);
                    }
                });
                menupanel.exitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        menuframe.dispose();
                    }
                });
                menupanel.rulesButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuframe.getContentPane().removeAll();
                        menuframe.getContentPane().repaint();

                        menuframe.setSize(500, 500);
                        menuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        menupanel = new MenuPanel(3);
                        menuframe.getContentPane().add(menupanel);

                        menuframe.setVisible(true);
                    }
                });

            //}
        }
        else if (i == 2) { //the second start window

            player = new Player();
            moneyOfPlayer = new JLabel();

            moneyOfPlayer.setText(String.valueOf(player.getamountOfMoney()));

            gameFrame = new JFrame("OnyxLand");
            gameFrame.setSize(800, 800);
            gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBackground2(gameFrame);


            JButton button = new JButton("Menu");
            JButton button2 = new JButton("Settings");

            gameFrame.getContentPane().add(button);
            gameFrame.getContentPane().add(button2);
            gameFrame.getContentPane().add(moneyOfPlayer);

            gameFrame.setVisible(true);
        }
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
    private void setBackground2(JFrame gameFrame) {
        //creating backgroung img
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/img/green-grass-textures.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(800, 800, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        gameFrame.setContentPane(new JLabel(imageIcon));
        gameFrame.getContentPane().setLayout(new BoxLayout(gameFrame.getContentPane(), BoxLayout.PAGE_AXIS));
    }



}
