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

    Sperm()
    {
        x = y = 20;
        setSize(122,124);
        setLocation(x, y);
        setBackground(Color.white);
        left  = new ImageIcon("sperm.gif");
        right = new ImageIcon("sperm_right.gif");
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
        super.paintComponent(e);
    }

}
