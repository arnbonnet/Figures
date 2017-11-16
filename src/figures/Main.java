package figures;

import java.util.Collection;

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
		Collection<Point> figurePoints = figure.getPoints();
		for(Point point : figurePoints) {
			System.out.print(point);
		}
		System.out.println();
		
		System.out.print("figure2.getPoints() :");
		Collection<Point> figure2Points = figure2.getPoints();
		for(Point point : figure2Points) {
			System.out.print(point);
		}
		System.out.println();
		
		System.out.print("figure3.getPoints() :");
		Collection<Point> figure3Points = figure3.getPoints();
		for(Point point : figure3Points) {
			System.out.print(point);
		}
		System.out.println();
		
		System.out.print("figure4.getPoints() :");
		Collection<Point> figure4Points = figure4.getPoints();
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
		System.out.print("Points of 4 random figures : ");
		Point[] points = FigureUtil.getPoints(figures);
		for(Point point:points) {
			System.out.print(point.toString());
		}
		System.out.println("\n");
		
		Drawing drawing = new Drawing();
		drawing.add(figure);
		drawing.add(figure2);
		drawing.add(figure3);
		drawing.add(figure4);
		
		drawing.display();
		
		Drawing drawing2 = new Drawing();
		drawing2.setFigures(FigureUtil.generateFigures(5));
		drawing2.display();
		
		System.out.println();
		System.out.println("TEST covers method");
		System.out.println("Circle covers");
		Circle circle4 = new Circle(new Point(3,4), 2);
		System.out.println(circle4.covers(new Point(2,3))); //TRUE
		System.out.println(circle4.covers(new Point(9,6))); //FALSE
		System.out.println("Rectangle covers");
		Rectangle rectangle4 = new Rectangle(new Point(3,4), 5, 6);
		System.out.println(rectangle4.covers(new Point(5,6))); //TRUE
		System.out.println(rectangle4.covers(new Point(2,2))); //FALSE
		System.out.println("Segment covers");
		Segment segment4 = new Segment(new Point(3,4), 5, true);
		System.out.println(segment4.covers(new Point(5,4))); //TRUE
		System.out.println(segment4.covers(new Point(3,12))); //FALSE
		
		System.out.println();
		System.out.println("TEST getFigureCoveringPoint");
		Figure figure5 = FigureUtil.getFigureCoveringPoint(new Point(), drawing2);
		if(figure5 != null) {
			System.out.println(FigureUtil.getFigureCoveringPoint(new Point(), drawing2));			
		} else {
			System.out.println("There is no figure of the drawing covering the point");
		}
	}

}
