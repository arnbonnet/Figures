package figures;

import utils.*;

public class Main {

	public static void main(String[] args) {
		Point point1 = new Point(3,4);
		System.out.println("Point : " + point1.toString());
		System.out.println("point.getX() : " + point1.getX());
		System.out.println("point.getY() : " + point1.getY());
		
		Circle circle1 = new Circle(point1, 12);
		circle1.display();
		
		Rectangle rectangle1 = new Rectangle(point1, 15, 8);
		rectangle1.display();
		
		Point point2 = new Point();
		System.out.println("new Point() : " + point2.toString());
		
		Circle circle2 = FigureUtil.getRandomCircle();
		circle2.display();
		
		Rectangle rectangle2 = FigureUtil.getRandomRectangle(false);
		rectangle2.display();
		
		Square square = new Square(point1, 5);
		square.display();
		
		Point point3 = new Point(10,5);
		Point point4 = point3.clone();
		Point point5 = new Point(20,7);
		
		System.out.println("point3 == point 4 ? " + point3.equals(point4)); //True
		System.out.println("point4 == point 5 ? " + point4.equals(point5)); //False
		System.out.println("point3 == point 5 ? " + point3.equals(point5)); //False
		
		System.out.println();
		System.out.println("RandomFigures : ");
		Figure figure = FigureUtil.getRandomFigure();
		figure.display();
		Figure figure2 = FigureUtil.getRandomFigure();
		figure2.display();
		Figure figure3 = FigureUtil.getRandomFigure();
		figure3.display();
		Figure figure4 = FigureUtil.getRandomFigure();
		figure4.display();
		
		System.out.println();
		System.out.print("figure.getPoints() :");
		Point[] figurePoints = figure.getPoints();
		for(Point point : figurePoints) {
			System.out.print(point);
		}
		System.out.println();
		
		System.out.print("figure2.getPoints() :");
		Point[] figure2Points = figure2.getPoints();
		for(Point point : figure2Points) {
			System.out.print(point);
		}
		System.out.println();
		
		System.out.print("figure3.getPoints() :");
		Point[] figure3Points = figure3.getPoints();
		for(Point point : figure3Points) {
			System.out.print(point);
		}
		System.out.println();
		
		System.out.print("figure4.getPoints() :");
		Point[] figure4Points = figure4.getPoints();
		for(Point point : figure4Points) {
			System.out.print(point);
		}
		
		System.out.println();
		System.out.println("Segment display :");
		Segment segment = new Segment(new Point(), 10, false);
		segment.display();
		
		System.out.println();
		System.out.println("RandomSurfacables : ");
		Surfacable surfacable = FigureUtil.getRandomSurfacable();
		surfacable.display();
		Surfacable surfacable2 = FigureUtil.getRandomSurfacable();
		surfacable2.display();
		Surfacable surfacable3 = FigureUtil.getRandomSurfacable();
		surfacable3.display();
		Surfacable surfacable4 = FigureUtil.getRandomSurfacable();
		surfacable4.display();
		
		Circle circle3 = new Circle(new Point(), 3);
		circle3.display();
		System.out.println("circle3 area : " + circle3.getArea());
		
		Rectangle rectangle3 = new Rectangle(new Point(), 3, 9);
		rectangle3.display();
		System.out.println("rectangle area : " + rectangle3.getArea());
		
		Square square3 = new Square(new Point(), 3);
		square3.display();
		System.out.println("square area : " + square3.getArea());
		
		Figure[] figures = new Figure[4];
		figures[0] = figure;
		figures[1] = figure2;
		figures[2] = figure3;
		figures[3] = figure4;
		
		System.out.println();
		System.out.println("Points of 4 random figures :");
		Point[] points = FigureUtil.getPoints(figures);
		for(Point point:points) {
			System.out.print(point.toString());
		}

	}

}
