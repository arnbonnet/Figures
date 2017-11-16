package utils;

import java.util.Collection;

public abstract class Figure {
	
	public abstract Collection<Point> getPoints();
	
	public void display() {
		System.out.println(this.toString());
	}
}
