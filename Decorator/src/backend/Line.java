package backend;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;

public class Line extends Polygon{

	private int firstX;
	private int firstY;
	private int secondX;
	private int secondY;
	private Color color;
	
	
	public Line(int x1, int y1, int x2, int y2) {
		this.firstX = x1;
		this.firstY = y1;
		this.secondX = x2;
		this.secondY = y2;
		this.addPoint(x1, y1);
		this.addPoint(x2, y2);
		color = color.RED;
		
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public int getFirstX() {
		return firstX;
	}


	public void setFirstX(int firstX) {
		this.firstX = firstX;
	}


	public int getFirstY() {
		return firstY;
	}


	public void setFirstY(int firstY) {
		this.firstY = firstY;
	}


	public int getSecondX() {
		return secondX;
	}


	public void setSecondX(int secondX) {
		this.secondX = secondX;
	}


	public int getSecondY() {
		return secondY;
	}


	public void setSecondY(int secondY) {
		this.secondY = secondY;
	}
}
