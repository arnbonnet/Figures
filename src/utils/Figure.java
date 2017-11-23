package utils;

import java.util.Collection;

public abstract class Figure implements Comparable<Figure> {

	private Color color;
	
	public Figure(Color color) {
		this.color = color;
	}
	
	public abstract Collection<Point> getPoints();
	
	public void display() {
		System.out.println(this.toString());
	}
	
	public abstract boolean covers(Point point);
	
	public abstract double originDistance();
	
	public int compareTo(Figure figure){
		if(this.equals(figure)){
			return 0;
		}
		double d1 = this.originDistance();
		double d2 = figure.originDistance();
		return (d2-d1) > 0 ? -1 : 1;
	}	

	public Color getColor() {
		return this.color;
	}
}
