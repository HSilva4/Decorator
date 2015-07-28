package frontend;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import backend.Circle;
import backend.Line;

import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;

import java.awt.Insets;

public class CreateRoom extends JFrame {

	private static final int DRAWING_SIZE = 600;
	private static final int SUBDIVISIONS = 15;
	private static final int SUBDIVISION_SIZE = DRAWING_SIZE / SUBDIVISIONS;

	private JToggleButton addLine = new JToggleButton("Add Line");

	private JToggleButton deleteLine = new JToggleButton("Delete Line");
	private JToggleButton editLine = new JToggleButton("Edit Line");

	private static ArrayList<Circle> circles = new ArrayList<Circle>();
	private static ArrayList<Line> lines = new ArrayList<Line>();

	private Color color = Color.GRAY;
	private Boolean hover = false;
	private int changeX;
	private int changeY;

	private Boolean first = true;

	private int firstClickX;
	private int firstClickY;

	Circle firstCircle;
	Circle secondCircle;

	private int secondClickX;
	private int secondClickY;

	private Boolean firstClick = true;

	private MouseAdapter mouseListener = new MouseAdapter() {

		@Override
		public void mouseMoved(MouseEvent e) {
			int mouseX = e.getX() - 100;
			int mouseY = e.getY() - 100;
			//			System.out.println(mouseX + " " + mouseY);

			for (Circle c : circles) {
				if ((mouseX >= c.getX() - 15 && mouseX <= c.getX() + 15) &&
						(mouseY >= c.getY() - 15 && mouseY <= c.getY() + 15) ) {
					color = Color.CYAN;
					//					highlightCircle(c.getX(), c.getY());
					hover = true;
					changeX = c.getX();
					changeY = c.getY();
					repaint();

				}

			}

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			int mouseX = e.getX() - 100;
			int mouseY = e.getY() - 100;

			if (addLine.isSelected()) {
				
				if (firstClick) {

					firstClickX = mouseX;
					firstClickY = mouseY;

					for (Circle c : circles) {
						if ((firstClickX >= c.getX() - 15 && firstClickX <= c.getX() + 15) &&
								(firstClickY >= c.getY() - 15 && firstClickY <= c.getY() + 15) ) {

							firstCircle = c;
							firstClick = false;
						}
					}
				} else {

					secondClickX = mouseX;
					secondClickY = mouseY;

					for (Circle c : circles) {
						if ((secondClickX >= c.getX() - 15 && secondClickX <= c.getX() + 15) &&
								(secondClickY >= c.getY() - 15 && secondClickY <= c.getY() + 15) ) {

							secondCircle = c;
							firstClick = true;
						}
					}
					Line l = new Line(firstCircle.getX(), firstCircle.getY(), secondCircle.getX(), secondCircle.getY());
					lines.add(l);

					repaint();
				}
			}
			else if (deleteLine.isSelected()) {

				int boxX = mouseX - 8;
				int boxY = mouseY - 8;

				int width = 16;
				int height = 16;

				Iterator<Line> i = lines.iterator();
				while (i.hasNext()) {
					Line l = i.next();
					if (l.intersects(boxX, boxY, width, height)) {
						i.remove();
						repaint();
					}
					
				}
				
				
//				for (Line l : lines) {
//					if (l.intersects(boxX, boxY, width, height)) {
////						l.setColor(Color.GREEN);
//						lines.remove(l);
//						repaint();
//					}
//				}


			}
		}

		public void highlightCircle(int mouseX, int mouseY) {
			Graphics g = getGraphics();
			Graphics2D g2 = (Graphics2D) g;

			for (int i = 1; i < SUBDIVISIONS; i++) {
				int x = i * SUBDIVISION_SIZE;

				for (int c = 1; c < SUBDIVISIONS; c++) {
					int y = c * SUBDIVISION_SIZE;
					if (x == mouseX && y == mouseY) {
						g2.setColor(color);
						mouseX = -1;
						mouseY = -1;
					} else {
						g2.setColor(Color.BLACK);
					}
					g2.fillOval(x + 3, y + 3, 6, 6);
				}
			}

		}

		public void drawLineHelper(int prevX, int prevY, int currX, int currY) {
			Graphics g = getGraphics();
			g.setColor(Color.RED);
			g.drawLine(prevX, prevY, currX, currY);

		}


	};
	/**
	 * Create the panel.
	 */
	public CreateRoom() {
		this.setTitle("Room Creator");

		setSize(800,800);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2 - getSize().width/2, dim.height/2 - getSize().height/2);
		setResizable(false);
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 0, 5, 0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		//		JLabel roomCreator = new JLabel("Room Creator");
		//		gbc.anchor = GridBagConstraints.SOUTH;
		//		roomCreator.setFont(new Font("Serif", Font.BOLD, 16));
		//		getContentPane().add(roomCreator, gbc);
		addLine.setSelected(true);

		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);

		JPanel panel = new JPanel() {

			@Override 
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				g2.setPaint(Color.GRAY);
				for (int i = 1; i < SUBDIVISIONS; i++) {
					int x = i * SUBDIVISION_SIZE;
					g2.drawLine(x, 0, x, getSize().height);

					for (int c = 1; c < SUBDIVISIONS; c++) {
						int y = c * SUBDIVISION_SIZE;
						if (hover && x == changeX && y == changeY) {
							g2.setPaint(color);
							hover = false;
							changeX = -1;
							changeY = -1;
						} else {
							g2.setPaint(Color.BLACK);
						}
						g2.fillOval(x - 3, y - 3, 6, 6);
						if (first) {
							Circle circ = new Circle(x, y);
							circles.add(circ);
						}
						g2.setPaint(Color.GRAY);
					}
				}

				for (int i = 1; i < SUBDIVISIONS; i++) {
					int y = i * SUBDIVISION_SIZE;
					g2.drawLine(0, y, getSize().width, y);

				}

				first = false;

				for (Line l : lines) {
					g2.setPaint(l.getColor());
					g2.setStroke(new BasicStroke(3));
					g2.drawLine(l.getFirstX(), l.getFirstY(), l.getSecondX(), l.getSecondY());

				}

			}   

			@Override
			public void update(Graphics g) {
				paint(g);
			}


		};
		panel.setPreferredSize(new Dimension(DRAWING_SIZE, DRAWING_SIZE));
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		gbc.gridy++;
		gbc.anchor = GridBagConstraints.CENTER;
		getContentPane().add(panel, gbc);

		ButtonGroup bg = new ButtonGroup();

		bg.add(addLine);
		bg.add(deleteLine);
		bg.add(editLine);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(addLine);
		buttonPanel.add(deleteLine);
		buttonPanel.add(editLine);
		getContentPane().add(buttonPanel);

		JButton btnSaveRoom = new JButton("Save Room");
		GridBagConstraints gbc_btnSaveRoom = new GridBagConstraints();
		gbc_btnSaveRoom.gridx = 0;
		gbc_btnSaveRoom.gridy = 3;
		getContentPane().add(btnSaveRoom, gbc_btnSaveRoom);

		//		JOptionPane.showMessageDialog(null, "the hell? " + circles.size());
		//		for (Circle c : circles) {
		//			JOptionPane.showMessageDialog(null, c.getX() + " " + c.getY());
		//		}



	}

}
