package utils;

import java.util.Collection;
import java.util.HashSet;

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
		return "Seg: " + start.toString() + " to " + getEndOfSegment();
	}

	@Override
	public Collection<Point> getPoints() {
		Collection<Point> points = new HashSet<>();
		points.add(getStart());
		points.add(getEndOfSegment());
		return points;
	}

	@Override
	public int hashCode() {
		final int prime = 100;
		int result = 1;
		result = prime * result + (isHorizontal ? 1 : 0);
		result = prime * result + start.getX();
		result = prime * result + start.getY();
		result = prime * result + width;
		return result;
	}
	
	public boolean covers(Point point) {
		if(this.isHorizontal) {
			boolean xCoordIsInSegment = point.getX()>=this.getStart().getX() && point.getX()<=this.getEndOfSegment().getX();
			return xCoordIsInSegment && point.getY() == this.getStart().getY();
		} else {
			boolean yCoordIsInSegment = point.getY()>=this.getStart().getY() && point.getY()<=this.getEndOfSegment().getY();
			return yCoordIsInSegment && point.getX() == this.getStart().getX();
		}
	}
	
}
