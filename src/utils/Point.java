package utils;

public class Point {
	private int x, y;

	private int INIT_X = 25;
	private int INIT_Y = 25;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
		this.x = INIT_X;
		this.y = INIT_Y;
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

	@Override
	public String toString() {
		return "[" + x + ";" + y + "]";
	}

	@Override
	public Point clone() {
		return new Point(x, y);
	}

	public boolean equals(Object object) {
		if(object instanceof Point) {
			return this.x == ((Point)object).getX() && this.y == ((Point)object).getY();			
		} else {
			return false;
		}
	}
}
