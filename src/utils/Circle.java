package utils;

public class Circle extends Figure implements Surfacable {
	private Point center;
	private int radius;
	
	public Circle(Point center, int radius) {
		this.center = center.clone();
		this.radius = radius;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle \t : [" + center + ", " + radius + "]";
	}

	public double getArea() {
		return Math.PI * getRadius() * getRadius();
	}

	@Override
	public Point[] getPoints() {
		Point[] points = {this.center};
		return points;
	}
	
	
	
}
