package utils;

import java.util.Collection;
import java.util.HashSet;

public class Rectangle extends Figure implements Surfacable {
	private Point leftDownPoint;
	private int width;
	private int height;
	
	public Rectangle(Point point, int width, int height) {
		this(point, width, height, Color.getDefaultColor());
	}
	
	public Rectangle(Point point, int width, int height, Color color) {
		super(color);
		this.leftDownPoint = point.clone();
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Point getLeftDownPoint() {
		return leftDownPoint;
	}

	public void setLeftDownPoint(Point point) {
		this.leftDownPoint = point;
	}
	
	public Point getLeftUpPoint() {
		Point leftUpPoint = new Point(leftDownPoint.getX(), leftDownPoint.getY()+height);
		return leftUpPoint;
	}
	
	public Point getRightUpPoint() {
		Point rightUpPoint = new Point(leftDownPoint.getX()+width, leftDownPoint.getY()+height);
		return rightUpPoint;
	}
	
	public Point getRightDownPoint() {
		Point rightDownPoint = new Point(leftDownPoint.getX()+width, leftDownPoint.getY());
		return rightDownPoint;
	}
	

	protected String getType() {
		return "Rect";
	}

	@Override
	public String toString() {
		return getType() + ": " + leftDownPoint.toString() + getLeftUpPoint().toString() + getRightUpPoint().toString() + getRightDownPoint().toString() + ", Color : " + this.getColor().getCode();
	}
	
	public double getArea() {
		return getWidth() * getHeight();
	}

	@Override
	public Collection<Point> getPoints() {
		Collection<Point> points = new HashSet<>();
		points.add(getLeftDownPoint());
		points.add(getLeftUpPoint());
		points.add(getRightUpPoint());
		points.add(getRightDownPoint());
		return points;
	}

	@Override
	public int hashCode() {
		final int prime = 100;
		int result = 1;
		result = prime * result + leftDownPoint.getX();
		result = prime * result + leftDownPoint.getY();
		result = prime * result + height;
		result = prime * result + width;
		return result;
	}
	
	public boolean covers(Point point) {
		boolean xCoordIsInRect = point.getX()>=this.getLeftDownPoint().getX() && point.getX() <= this.getRightUpPoint().getX();
		boolean yCoordIsInRect = point.getY()>=this.getLeftDownPoint().getY() && point.getY() <= this.getRightUpPoint().getY();
		return xCoordIsInRect && yCoordIsInRect;
	}

	@Override
	public double originDistance() {
		return this.getLeftDownPoint().getDistance(new Point(0,0));
	}
}
