package ObjectsMenu;

import javax.swing.*;

public class Menu extends JFrame {
    JFrame f;
    public Menu() {
        f = new JFrame("What do you wanna built?");
        f.setSize(500, 500);
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        //ObjectTypesButtons otp = new ObjectTypesButtons();
        //f.getContentPane().add(otp);
        f.setVisible(true);
        /*super("What do you wanna built?");
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setSize(500, 500);
        // Панель содержимого
        Container container = getContentPane();
        container.setLayout (new FlowLayout(FlowLayout.CENTER));
        // добавляем компоненты

        JButton paths = new JButton("Paths");
        JButton amusements = new JButton("Amusements");
        JButton foods = new JButton("Foods");
        JButton gardens = new JButton("Gardens");
        JPanel pics = new JPanel();

        pics.setSize(300,300);
        pics.setBackground(Color.white);
        container.add(paths);
        container.add(amusements);
        container.add(foods);
        container.add(gardens);
        container.add(pics);
        // Открываем окно
        setVisible(true);*/

        /*
        f = new JFrame("What do you wanna built?");
        f.setSize(400,400);
        f.setLayout(new BoxLayout(f,BoxLayout.Y_AXIS));

        JPanel popupmenu = new JPanel();
        popupmenu.setLayout(new BoxLayout(popupmenu,BoxLayout.X_AXIS));
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setBackground(f);

        JButton paths = new JButton("Paths");
        JButton amusements = new JButton("Amusements");
        JButton foods = new JButton("Foods");
        JButton gardens = new JButton("Gardens");

        popupmenu.add(paths);
        popupmenu.add(amusements);
        popupmenu.add(foods);
        popupmenu.add(gardens);

        paths.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Paths but press");
                JPanel sidePop = new JPanel();
                sidePop.setLayout(new BoxLayout(sidePop,BoxLayout.Y_AXIS));
                JButton Hotdog = new JButton("Hot Dog");
                JButton sweetShop = new JButton("Candy Shop");
                sidePop.add(Hotdog);
                sidePop.add(sweetShop);
                f.getContentPane().add(sidePop);

            }
        });

        f.getContentPane().add(popupmenu);
        f.setVisible(true);*/
        //f.pack();
    }

}
