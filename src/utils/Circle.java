package utils;

import java.util.Collection;
import java.util.HashSet;

public class Circle extends Figure implements Surfacable {
	private Point center;
	private int radius;

	public Circle(Point center, int radius) {
		this(center, radius, Color.getDefaultColor());
	}

	public Circle(Point center, int radius, Color color) {
		super(color);
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
		return "Circle: [" + center + ", " + radius + ", Color : " + this.getColor().getCode() + "]";
	}

	public double getArea() {
		return Math.PI * getRadius() * getRadius();
	}

	@Override
	public Collection<Point> getPoints() {
		Collection<Point> points = new HashSet<>();
		points.add(this.center);
		return points;
	}

	@Override
	public int hashCode() {
		final int prime = 100;
		int result = 1;
		result = prime * result + center.getX();
		result = prime * result + center.getY();
		result = prime * result + radius;
		return result;
	}

	public boolean covers(Point point) {
		return this.center.getDistance(point) <= this.radius;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			boolean areRadiusEqual = this.getRadius() == ((Circle) obj).getRadius();
			boolean areCentersEqual = this.getCenter().equals(((Circle) obj).getCenter());
			boolean areColorsEqual = this.getColor().getCode() == ((Circle)obj).getColor().getCode();
			return areRadiusEqual && areCentersEqual && areColorsEqual;
		} else {
			return false;
		}
	}

	@Override
	public double originDistance() {
		double centerDistance = this.getCenter().getDistance(new Point(0, 0));
		double circleDistance = centerDistance - this.getRadius();

		return circleDistance;
	}

}
