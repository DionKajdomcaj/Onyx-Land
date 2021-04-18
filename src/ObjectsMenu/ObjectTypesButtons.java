package ObjectsMenu;

import javax.swing.*;
import java.awt.*;

public class ObjectTypesButtons extends JPanel {
    JPanel buttons;
    public ObjectTypesButtons() {
        buttons = new JPanel(new FlowLayout());

        buttons.setLayout (new FlowLayout(FlowLayout.CENTER));
        // добавляем компоненты

        JButton paths = new JButton("Paths");
        JButton amusements = new JButton("Amusements");
        JButton foods = new JButton("Foods");
        JButton gardens = new JButton("Gardens");
        JPanel pics = new JPanel();

        buttons.add(paths);
        buttons.add(amusements);
        buttons.add(foods);
        buttons.add(gardens);
        buttons.add(pics);

    }

}
