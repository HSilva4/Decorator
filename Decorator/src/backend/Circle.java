package backend;

public class Circle {

	private final double diameter = 4.0;
	private double x;
	private double y;
	
	/**
	 * @param x the x coordinate location
	 * @param y the y coordinate location
	 */
	public Circle(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getDiameter() {
		return diameter;
	}
	
	
}
