package utils;

public class Segment extends Figure {
	
	private Point start;
	private int width;
	private boolean isHorizontal;
	
	public Segment(Point start, int width, boolean isHorizontal) {
		this.start = start.clone();
		this.width = width;
		this.isHorizontal = isHorizontal;
	}
	
	public Point getStart() {
		return this.start;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public boolean isHorizontal() {
		return this.isHorizontal;
	}
	
	public Point getEndOfSegment() {
		if(isHorizontal()) {
			return new Point(start.getX() + getWidth(), start.getY());
		} else {
			return new Point(start.getX(), start.getY() + getWidth());
		}
	}
	
	public String toString() {
		return "Seg \t : " + start.toString() + " to " + getEndOfSegment();
	}

	@Override
	public Point[] getPoints() {
		Point[] points = {getStart(), getEndOfSegment()};
		return points;
	}
}
