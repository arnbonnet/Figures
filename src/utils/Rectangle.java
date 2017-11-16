package utils;

public class Rectangle extends Figure implements Surfacable {
	private Point leftDownPoint;
	private int width;
	private int height;
	
	public Rectangle(Point point, int width, int height) {
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
		return getType() + "\t : " + leftDownPoint.toString() + getLeftUpPoint().toString() + getRightUpPoint().toString() + getRightDownPoint().toString();
	}
	
	public double getArea() {
		return getWidth() * getHeight();
	}

	@Override
	public Point[] getPoints() {
		Point[] points = {getLeftDownPoint(), getLeftUpPoint(), getRightUpPoint(), getRightDownPoint()};
		return points;
	}
	
}
