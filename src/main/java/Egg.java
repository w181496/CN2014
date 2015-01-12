/**
 * Created by w181496 on 2015/1/12.
 */
import javax.swing.*;
import java.awt.*;

public class Egg extends JPanel{
    int uid;
    int x, y;
    JLabel label;
    ImageIcon image;

    Egg()
    {
        image = new ImageIcon("egg.gif");
        label = new JLabel(image);
        x = 500;
        y = 80;
        setLocation(x, y);
        setBackground(new Color(0, 0, 0, 0));
        setOpaque(false);
        setSize(image.getIconWidth(),image.getIconHeight() + 10);
        add(label);
    }

    @Override
    public void paintComponent(Graphics e)
    {
        e.setColor(getBackground());
        Rectangle r = e.getClipBounds();
        e.fillRect(r.x, r.y, r.width, r.height);
        super.paintComponent(e);
    }
}
