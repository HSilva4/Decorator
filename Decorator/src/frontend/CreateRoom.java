package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import backend.Circle;

import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CreateRoom extends JFrame {

	private static final int DRAWING_SIZE = 600;
	private static final int SUBDIVISIONS = 15;
	private static final int SUBDIVISION_SIZE = DRAWING_SIZE / SUBDIVISIONS;

	private static ArrayList<Circle> circles = new ArrayList<Circle>();
	private int pushes = 0;
	
	private Color color = Color.GRAY;
	private Boolean hover = false;
	private double changeX;
	private double changeY;
	
	private MouseAdapter mouseListener = new MouseAdapter() {

		@Override
		public void mouseMoved(MouseEvent e) {
			int mouseX = e.getX();
			int mouseY = e.getY();
			
			
			for (Circle c : circles) {
//				if (c.getX() == mouseX && c.getY() == mouseY) {
//					JOptionPane.showMessageDialog(null, "hellooo");
//
//
//				}
				if ((mouseX >= c.getX() - 6 && mouseX <= c.getX() + 6) &&
						(mouseY >= c.getY() - 6 && mouseY <= c.getY() + 6) ) {
					color = Color.CYAN;
					hover = true;
					changeX = c.getX();
					changeY = c.getY();
					repaint();
//					Rectangle r = new Rectangle(c.getX(), c.getY());
					
//					pushes++;
//					System.out.println("you moved " + pushes + " times.");
					
					
				}

			}
		}

	};
	/**
	 * Create the panel.
	 */
	public CreateRoom() {
		setSize(800,800);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2 - getSize().width/2, dim.height/2 - getSize().height/2);
		setResizable(false);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		//		gbc.weightx = 1.0;
		//		gbc.weighty = 1.0;
		//		gbc.gridx = 0;
		//		gbc.gridy = 0;
		//		gbc.anchor = GridBagConstraints.SOUTH;
		//		add(gbc);

		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);

		JPanel panel = new JPanel() {
			@Override public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				g2.setPaint(Color.GRAY);
				circles.clear();
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
						Circle circ = new Circle(x, y);
						circles.add(circ);
						//						System.out.println(circ.getX());

						g2.setPaint(Color.GRAY);
						//						break;
					}
				}
				for (int i = 1; i < SUBDIVISIONS; i++) {
					int y = i * SUBDIVISION_SIZE;
					g2.drawLine(0, y, getSize().width, y);

				}

//				for (Circle c : circles) {
//					System.out.println(c.getX() + " " + c.getY());
//				}

			}   



		};
		panel.setPreferredSize(new Dimension(DRAWING_SIZE, DRAWING_SIZE));
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		gbc.gridy++;
		gbc.anchor = GridBagConstraints.CENTER;
		add(panel, gbc);

		//		JOptionPane.showMessageDialog(null, "the hell? " + circles.size());
		//		for (Circle c : circles) {
		//			JOptionPane.showMessageDialog(null, c.getX() + " " + c.getY());
		//		}



	}

}
