
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

	Button NGButton, resetButton, UploadButton;
	puzzleCanvas[] parr = new puzzleCanvas[16];

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

		for (int i = 1; i <= 16; i++) {
			puzzleCanvas b = new puzzleCanvas();
			b.index = i;
			b.addKeyListener(b);
			parr[i - 1] = b;
			p1.add(parr[i - 1]);
		}
		parr[14].index = 0;

	}

	public void inithelper() {

	}

	public void actionPerformed(ActionEvent e) {
		/*
		 * if (e.getSource() == NGButton) { c.set(); } else if (e.getSource() ==
		 * resetButton) { c.clear(); } else if (e.getSource() == UploadButton) {
		 * c.toggle(); }
		 */
	}

	class puzzleCanvas extends Canvas implements MouseListener, KeyListener {
		// instance variables representing the game go here
		SlidingPuzzle parent;
		int n = 16;
		boolean[] square = new boolean[n];
		int index = 0;

		// draw the boxes
		public void paint(Graphics g) {
			Dimension d = getSize();
			g.setColor(new Color(200, 220, 255));
			int x = 0;
			int y = 0;
			g.fillRect(x, y, d.width, d.height);
			g.setColor(Color.black);
			g.drawRect(x, y, d.width, d.height);
			if (index != 0)
				g.drawString(Integer.toString(index), x + d.width / 2, y + d.height / 2);

		}

		// handle mouse events
		public void mousePressed(MouseEvent event) {
		}

		// methods called from the event handler of the main applet

		// need these also because we implement a MouseListener
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_UP) {
				parent.parr[1].index = 0;
				repaint();
			}

		}

		public void keyTyped(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
		}

		public void mouseReleased(MouseEvent event) {
		}

		public void mouseClicked(MouseEvent event) {
		}

		public void mouseEntered(MouseEvent event) {
		}

		public void mouseExited(MouseEvent event) {
		}
	}
}
