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

	puzzleCanvas c;
	Button NGButton, resetButton, UploadButton;

	public void init() {
		setLayout(new BorderLayout());

		NGButton = new Button("Set");
		NGButton.setBackground(Color.white);
		NGButton.addActionListener(this);
		resetButton = new Button("Clear");
		resetButton.setBackground(Color.white);
		resetButton.addActionListener(this);
		UploadButton = new Button("Toggle");
		UploadButton.setBackground(Color.white);
		UploadButton.addActionListener(this);
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(4, 4));
		add("Center", p1);
		c = new puzzleCanvas();
		c.setBackground(Color.yellow);
		c.addMouseListener(c);
		// add("Center", c);
		
		for (int i=0; i<16;i++){
			p1.add(c);
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == NGButton) {
			c.set();
		} else if (e.getSource() == resetButton) {
			c.clear();
		} else if (e.getSource() == UploadButton) {
			c.toggle();
		}
	}
}

@SuppressWarnings("serial")

class puzzleCanvas extends Canvas implements MouseListener {

	// instance variables representing the game go here
	int n = 16;
	boolean[] box = new boolean[n];
	int size = 80;
	int border = 20;

	// draw the boxes
	public void paint(Graphics g) {
		g.setColor(Color.green);
		int x = size + border;
		int y = border;
		g.fillRect(x, y, size, size);
		g.setColor(Color.black);
		g.drawRect(x, y, size, size);
	}


	// handle mouse events
	public void mousePressed(MouseEvent event) {
		Point p = event.getPoint();

		// check if clicked in box area

		int x = p.x - border;
		int y = p.y - border;

		if (x >= 0 && x < n * size && y >= 0 && y < size) {

			int k = x / size;
			// System.out.println(k);
			box[k] = !box[k];
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
			box[i] = !box[i];
		repaint();
	}

	// need these also because we implement a MouseListener
	public void mouseReleased(MouseEvent event) {
	}

	public void mouseClicked(MouseEvent event) {
	}

	public void mouseEntered(MouseEvent event) {
	}

	public void mouseExited(MouseEvent event) {
	}
}
