/**
 * Created by w181496 on 2015/1/9.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame{

    private Sperm s;
    private Sperm s2;
    private JTextField text;
    private String input;
    private int shift = 20;
    private int direction = 4;   //up: 1 down: 2 left: 3 right: 4

    MyFrame() {
        s = new Sperm();
        //s2 = new Sperm();
        setSize(700, 400);
        setTitle("Sperm chatroom");
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        text = new JTextField("");
        input = new String("");
        add(s);
        //add(s2);
        KeyListener listener = new Key_listener();
        addKeyListener(listener);
        setVisible(true);
    }

    void setter()
    {
        text.setLocation(s.getXX() + 30, s.getYY() + 100);
        text.setSize(input.length() * 6 + 11,22);
        text.setText(input);
    }

    class Key_listener implements KeyListener {
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if(direction != 4) s.changeToRight();
                direction = 4;
                s.setLocation(s.getXX() + shift, s.getYY());
                s.x += shift;
                setter();
                repaint();
            }
            else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                if(direction != 3) s.changeToLeft();
                direction = 3;
                s.setLocation(s.getXX() - shift, s.getYY());
                s.x -= shift;
                setter();
                repaint();
            }
            else if(e.getKeyCode() == KeyEvent.VK_UP) {
                direction = 1;
                s.setLocation(s.getXX(), s.getYY() - shift);
                s.y -= shift;
                setter();
                repaint();
            }
            else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                direction = 2;
                s.setLocation(s.getXX(), s.getYY() + shift);
                s.y += shift;
                setter();
                repaint();
            }
            else if(e.getKeyCode() == KeyEvent.VK_T) {
                input = JOptionPane.showInputDialog("說：");
                setter();
                getContentPane().add(text);

            }
        }

        public void keyReleased(KeyEvent e) {
        }

        public void keyTyped(KeyEvent e) {
        }
    }
}
