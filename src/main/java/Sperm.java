/**
 * Created by w181496 on 2015/1/9.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sperm extends JPanel{
    int uid;
    int x, y;
    JLabel label;
    //JTextField txt;
    ImageIcon left;
    ImageIcon right;
    ImageIcon up;
    ImageIcon down;
    ImageIcon leftup;
    ImageIcon leftdown;
    ImageIcon rightup;
    ImageIcon rightdown;

    Sperm()
    {
        x = y = 20;
        setSize(122,124);
        setLocation(x, y);
        setBackground(new Color(0, 0, 0, 0));
        setOpaque(false);

        left        = new ImageIcon("sperm_left.gif");
        right       = new ImageIcon("sperm_right.gif");
        up          = new ImageIcon("sperm_up.gif");
        down        = new ImageIcon("sperm_down.gif");
        leftup      = new ImageIcon("sperm_leftup.gif");
        leftdown    = new ImageIcon("sperm_leftdown.gif");
        rightup     = new ImageIcon("sperm_rightup.gif");
        rightdown   = new ImageIcon("sperm_rightdown.gif");

        label = new JLabel(right);
        //txt.setText("");
        //add(txt);
        add(label);
    }

    void changeToRight()
    {
        this.label.setIcon(right);
    }

    void changeToLeft()
    {
        this.label.setIcon(left);
    }

    void changeToUp()
    {
        this.label.setIcon(up);
    }

    void changeToDown()
    {
        this.label.setIcon(down);
    }

    void changeToLeftUp()
    {
        this.label.setIcon(leftup);
    }

    void changeToLeftDown()
    {
        this.label.setIcon(leftdown);
    }

    void changeToRightUp()
    {
        this.label.setIcon(rightup);
    }

    void changeToRightDown()
    {
        this.label.setIcon(rightdown);
    }

    int getXX()
    {
        return this.x;
    }

    int getYY()
    {
        return this.y;
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
