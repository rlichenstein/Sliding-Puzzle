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

		NGButton = new Button("New Game");
		NGButton.setBackground(Color.white);
		NGButton.addActionListener(this);
		resetButton = new Button("Reset");
		resetButton.setBackground(Color.white);
		resetButton.addActionListener(this);
		UploadButton = new Button("Upload");
		UploadButton.setBackground(Color.white);
		UploadButton.addActionListener(this);
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(4, 4));
		p1.setBackground(Color.black);
		add("Center", p1);
		//c = new puzzleCanvas();
		//c.setBackground(Color.yellow);
		//c.addMouseListener(c);
		// add("Center", c);
		
		for (int i=1; i<=16;i++){
			p1.add(new puzzleCanvas());
		}

	}
	public void inithelper() {
		
	}

	/*public void actionPerformed(ActionEvent e) {
		if (e.getSource() == NGButton) {
			c.set();
		} else if (e.getSource() == resetButton) {
			c.clear();
		} else if (e.getSource() == UploadButton) {
			c.toggle();
		}
	}
}*/

@SuppressWarnings("serial")

class puzzleCanvas extends Canvas implements MouseListener {

	// instance variables representing the game go here
	int n = 16;
	boolean[] square = new boolean[n];
	int size = 80;
	int border = 20;

	// draw the boxes
	public void paint(Graphics g) {
		Dimension d = getSize();
		g.setColor(new Color(200,220,255));
		int x = 0;
		int y = 0;
		g.fillRect(x, y, d.width, d.height);
		g.setColor(Color.black);
		g.drawRect(x, y, d.width, d.height);
	}


	// handle mouse events
	public void mousePressed(MouseEvent event) {
	}

	// methods called from the event handler of the main applet

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
