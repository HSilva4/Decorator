package backend;

public class Circle {

	private final double diameter = 4.0;
	private int x;
	private int y;
	
	/**
	 * @param x the x coordinate location
	 * @param y the y coordinate location
	 */
	public Circle(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getDiameter() {
		return diameter;
	}
	
	
}
