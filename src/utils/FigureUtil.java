package utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

public class FigureUtil {

	private static int getRandomInt(int max) {
		Random random = new Random();
		return random.nextInt(max);
	}

	private static Point getRandomPoint() {
		return new Point(getRandomInt(100), getRandomInt(100));

	}

	public static Circle getRandomCircle() {
		return new Circle(getRandomPoint(), getRandomInt(100));
	}

	public static Rectangle getRandomRectangle(boolean isSquare) {
		if(isSquare) {
			return new Square(getRandomPoint(), getRandomInt(100));
		} else {
			return new Rectangle(getRandomPoint(), getRandomInt(100), getRandomInt(100));			
		}
	}
	
	public static Segment getRandomSegment() {
		if(getRandomInt(2) == 0) {
			return new Segment(getRandomPoint(), getRandomInt(100), false);
		} else {
			return new Segment(getRandomPoint(), getRandomInt(100), true);
		}
	}
	
	public static Figure getRandomFigure() {
		Figure figure = null;
		
		int ran = getRandomInt(4); // 0 -> 3
		switch (ran) {
		case 0 : 
			figure = getRandomCircle();
			break;
			
		case 1 : 
			figure = getRandomRectangle(false);
			break;
			
		case 2 :
			figure = getRandomRectangle(true);
			break;
		case 3 :
		default :
			figure = getRandomSegment();
			
		}
		
		return figure;
	}
	
	public static Surfacable getRandomSurfacable() {
		Surfacable area = null;
		
		int ran = getRandomInt(3); // 0 -> 2
		switch (ran) {
		case 0 : 
			area = getRandomCircle();
			break;
			
		case 1 : 
			area = getRandomRectangle(false);
			break;
			
		case 2 :
		default :
			area = getRandomRectangle(true);
			break;
			
		}
		return area;
	}
	
	public static Point[] getPoints(Figure... figures) {
		int newTabPointsLength = 0;
		for(Figure figure:figures) {
			newTabPointsLength += figure.getPoints().size();
		}
		
		Point[] tabPointsOutput = new Point[newTabPointsLength];
		int i = 0;
		for(Figure figure:figures) {
			for(Point point:figure.getPoints()) {
				tabPointsOutput[i++] = point;
			}
		}
		
		return tabPointsOutput;
	}
	
	public static Collection<Figure> generateFigures(int nbFigures) {
		HashSet<Figure> figures = new HashSet<>();
		while(figures.size() < nbFigures) {
			figures.add(getRandomFigure());
		}
		
		return figures;
	}
}
