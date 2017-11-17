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
	
	public int compareTo(Figure f){
		if(this.equals(f)){
			return 0;
		}
		double d1 = this.originDistance();
		double d2 = f.originDistance();
		return (d1-d2) > 0 ? -1 : 1;
	}	

	public Color getColor() {
		return this.color;
	}
}
