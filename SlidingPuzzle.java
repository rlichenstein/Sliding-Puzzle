//CS201
//
// SlidingPuzzle.java
// Robert Lichenstein & Hamza Kiyani
// A Sliding Puzzle Game to test you or something.
// 	

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")

public class SlidingPuzzle extends Applet implements ActionListener {

    BoxCanvas c;
    Button setButton, clearButton, toggleButton;
    
    public void init () {
        setLayout(new BorderLayout());
        setButton = new Button("Set");
        setButton.setBackground(Color.white);
        setButton.addActionListener(this);
        clearButton = new Button("Clear");
        clearButton.setBackground(Color.white);
        clearButton.addActionListener(this);
        toggleButton = new Button("Toggle");
        toggleButton.setBackground(Color.white);
        toggleButton.addActionListener(this);
        Panel p = new Panel();
        p.setBackground(Color.black);
        p.add(setButton);
        p.add(clearButton);
        p.add(toggleButton);
        add("North", p);
        c = new BoxCanvas();
        c.setBackground(Color.yellow);
        c.addMouseListener(c);
        add("Center", c);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == setButton) {
            c.set();
        } else if (e.getSource() == clearButton) {
            c.clear();
        } else if (e.getSource() == toggleButton) {
            c.toggle();
        }
    }
}

@SuppressWarnings("serial")

class BoxCanvas extends Canvas implements MouseListener  {

    // instance variables representing the game go here
    int n = 7;
    boolean[] box = new boolean[n];
    int size = 80;
    int border = 20;
    

    // draw the boxes
    public void paint(Graphics g) {
        for (int i = 0; i < n; i++) {
            if (box[i])
                g.setColor(Color.red);
            else
                g.setColor(Color.green);
            int x = i * size + border;
            int y = border;
            g.fillRect(x, y, size, size);
            g.setColor(Color.black);
            g.drawRect(x, y, size, size);
        }
    }

    // handle mouse events
    public void mousePressed(MouseEvent event) {
        Point p = event.getPoint();

        // check if clicked in box area

        int x = p.x - border;
        int y = p.y - border;

        if (x >= 0 && x < n*size &&
            y >= 0 && y < size) {

            int k = x / size;
            //System.out.println(k);
            box[k] = ! box[k];
        }
        repaint();
    }

    // methods called from the event handler of the main applet

    public void set() {
        for (int i = 0; i < n; i++)
            box[i] = true;
        repaint();
    }

    public void clear() {
        for (int i = 0; i < n; i++)
            box[i] = false;
        repaint();
    }

    public void toggle() {
        for (int i = 0; i < n; i++)
            box[i] = ! box[i];
        repaint();
    }

    // need these also because we implement a MouseListener
    public void mouseReleased(MouseEvent event) { }
    public void mouseClicked(MouseEvent event) { }
    public void mouseEntered(MouseEvent event) { }
    public void mouseExited(MouseEvent event) { }
}