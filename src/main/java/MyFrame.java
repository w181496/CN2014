/**
 * Created by w181496 on 2015/1/9.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class MyFrame extends JFrame{

    private Sperm s;
    private Sperm s2;
    private Egg egg;
    private JTextField text;
    private String input;
    private int shift = 20;
    private int direction = 4;   //up: 1 down: 2 left: 3 right: 4 leftup: 5 leftdown: 6 rightup: 7 rightdown: 8

    MyFrame() {
        s = new Sperm();
        egg = new Egg();
        //s2 = new Sperm();
        setSize(700, 400);
        setTitle("生命的起源");
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        text = new JTextField("");
        input = new String("");
        add(s);
        add(egg);
        //add(s2);
        KeyListener listener = new Key_listener();
        addKeyListener(listener);
        setVisible(true);
    }

    void setter()
    {
        text.setLocation(s.getXX() + 30, s.getYY() + 100);
        text.setText(input);
        if(input == "") text.setSize(0, 0);
        else text.setSize(input.length() * 6 + 12,22);
        repaint();
    }

    public class DateTask extends TimerTask {
        @Override
        public void run() {
            input = "";
            setter();
            cancel();
        }
    }

    class Key_listener implements KeyListener {
        public void keyPressed(KeyEvent e) {

            if(e.getKeyCode() == KeyEvent.VK_NUMPAD7) {
                if(direction != 5) s.changeToLeftUp();
                direction = 5;
                s.setLocation(s.getXX() - shift, s.getYY() - shift);
                s.x -= shift;
                s.y -= shift;
                setter();
            }
            else if(e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
                if(direction != 6) s.changeToLeftDown();
                direction = 6;
                s.setLocation(s.getXX() - shift, s.getYY() + shift);
                s.x -= shift;
                s.y += shift;
                setter();
            }
            else if(e.getKeyCode() == KeyEvent.VK_NUMPAD9) {
                if(direction != 7) s.changeToRightUp();
                direction = 7;
                s.setLocation(s.getXX() + shift, s.getYY() - shift);
                s.x += shift;
                s.y -= shift;
                setter();
            }
            else if(e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
                if (direction != 8) s.changeToRightDown();
                direction = 8;
                s.setLocation(s.getXX() + shift, s.getYY() + shift);
                s.x += shift;
                s.y += shift;
                setter();
            }
            else if(e.getKeyCode() == KeyEvent.VK_NUMPAD6) {
                if(direction != 4) s.changeToRight();
                direction = 4;
                s.setLocation(s.getXX() + shift, s.getYY());
                s.x += shift;
                setter();
            }
            else if(e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
                if(direction != 3) s.changeToLeft();
                direction = 3;
                s.setLocation(s.getXX() - shift, s.getYY());
                s.x -= shift;
                setter();
            }
            else if(e.getKeyCode() == KeyEvent.VK_NUMPAD8) {
                if(direction != 1) s.changeToUp();
                direction = 1;
                s.setLocation(s.getXX(), s.getYY() - shift);
                s.y -= shift;
                setter();
            }
            else if(e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
                if(direction != 2) s.changeToDown();
                direction = 2;
                s.setLocation(s.getXX(), s.getYY() + shift);
                s.y += shift;
                setter();
            }
            else if(e.getKeyCode() == KeyEvent.VK_T) {
                input = JOptionPane.showInputDialog("說：");
                Timer timer = new Timer();
                timer.schedule(new DateTask(), 4000);
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
