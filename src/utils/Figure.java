package utils;

public abstract class Figure {
	
	public abstract Point[] getPoints();
	
	public void display() {
		System.out.println(this.toString());
	}
}
