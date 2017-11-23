package figures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import utils.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("======= TEST objects initialisations and displays =======");
		Point point1 = new Point(3,4);
		System.out.println("Point : " + point1.toString()); // [3;4]
		System.out.println("point.getX() : " + point1.getX()); // 3
		System.out.println("point.getY() : " + point1.getY()); // 4
		
		Point point2 = new Point();
		System.out.println("new Point() : " + point2.toString()); // [25;25]

		Circle circle1 = new Circle(point1, 12);
		circle1.display(); // Circle: [[3;4], 12, Color : #]
		Circle coloredCircle = new Circle(point1, 12, Color.Red);
		coloredCircle.display(); // Circle: [[3;4], 12, Color : R]
		
		Rectangle rectangle1 = new Rectangle(point1, 15, 8);
		rectangle1.display(); // Rect: [3;4][3;12][18;12][18;4], Color : #
		Rectangle coloredRectangle = new Rectangle(point1, 15, 8, Color.Blue);
		coloredRectangle.display(); // Rect: [3;4][3;12][18;12][18;4], Color : B
		
		Square square = new Square(point1, 5);
		square.display(); // Square: [3;4][3;9][8;9][8;4], Color : #
		Square coloredSquare = new Square(point1, 5, Color.Yellow);
		coloredSquare.display(); // Square: [3;4][3;9][8;9][8;4], Color : Y

		Segment segment = new Segment(new Point(), 10, false);
		segment.display(); // Seg: [25;25] to [25;35], Color : #
		Segment coloredSegment = new Segment(new Point(), 10, true, Color.Green);
		coloredSegment.display(); // Seg: [25;25] to [35;25], Color : G
		System.out.println();
		
		
		System.out.println("====== TEST random figures ======");
		System.out.print("Random circle : ");
		Circle circle2 = FigureUtil.getRandomCircle();
		circle2.display();
		
		System.out.print("Random rectangle : ");
		Rectangle rectangle2 = FigureUtil.getRandomRectangle(false);
		rectangle2.display();
		
		System.out.print("Random segment : ");
		Segment segment2 = FigureUtil.getRandomSegment();
		segment2.display();
		
		System.out.println();
		System.out.println("4 Random figures : ");
		Figure figure = FigureUtil.getRandomFigure();
		figure.display();
		Figure figure2 = FigureUtil.getRandomFigure();
		figure2.display();
		Figure figure3 = FigureUtil.getRandomFigure();
		figure3.display();
		Figure figure4 = FigureUtil.getRandomFigure();
		figure4.display();
		
		System.out.println();
		System.out.println("4 random surfacables (Circle, Rectangle or Square) : ");
		Surfacable surfacable = FigureUtil.getRandomSurfacable();
		surfacable.display();
		Surfacable surfacable2 = FigureUtil.getRandomSurfacable();
		surfacable2.display();
		Surfacable surfacable3 = FigureUtil.getRandomSurfacable();
		surfacable3.display();
		Surfacable surfacable4 = FigureUtil.getRandomSurfacable();
		surfacable4.display();
		
		System.out.println();
		System.out.println("====== TEST equals ======");
		
		System.out.println("Point equals :");
		Point point3 = new Point(10,5);
		Point point4 = point3.clone();
		Point point5 = new Point(20,7);
		System.out.println("point3 == point4 ? " + point3.equals(point4)); //True
		System.out.println("point4 == point5 ? " + point4.equals(point5)); //False
		System.out.println("point3 == point5 ? " + point3.equals(point5)); //False
		
		System.out.println();
		System.out.print("Circle equals : ");
		Circle circle5 = new Circle(new Point(), 5);
		Circle circle6 = new Circle(new Point(), 5);
		Circle circle7 = new Circle(new Point(5,9), 2);
		System.out.print(circle5.equals(circle6) + " "); //TRUE
		System.out.println(circle5.equals(circle7)); //FALSE
		
		System.out.println();
		
		System.out.println("====== TEST figures getPoints with HashSet ======");
		System.out.print("figure1 :");
		Collection<Point> figurePoints = figure.getPoints();
		for(Point point : figurePoints) {
			System.out.print(point);
		}
		System.out.println();
		
		System.out.print("figure2 :");
		Collection<Point> figure2Points = figure2.getPoints();
		for(Point point : figure2Points) {
			System.out.print(point);
		}
		System.out.println();
		
		System.out.print("figure3 :");
		Collection<Point> figure3Points = figure3.getPoints();
		for(Point point : figure3Points) {
			System.out.print(point);
		}
		System.out.println();
		
		System.out.print("figure4 :");
		Collection<Point> figure4Points = figure4.getPoints();
		for(Point point : figure4Points) {
			System.out.print(point);
		}
		System.out.println();
		System.out.println();
		
		System.out.println("====== TEST surfacable figures getArea ======");
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
		System.out.println("====== TEST getPoints of a 4 figures array ======");
		Point[] points = FigureUtil.getPoints(figures);
		for(Point point:points) {
			System.out.print(point.toString());
		}
		System.out.println();
		System.out.println();
		
		System.out.println("====== TEST drawing ======");
		System.out.println("Using drawing.add(figure) :");
		Drawing drawing = new Drawing();
		drawing.add(figure);
		drawing.add(figure2);
		drawing.add(figure3);
		drawing.add(figure4);
		
		drawing.display();
		
		System.out.println("Using drawing.setFigures(FigureUtil.generateFigures(nbFigures) :");
		Drawing drawing2 = new Drawing();
		drawing2.setFigures(FigureUtil.generateFigures(5));
		drawing2.display();
		
		System.out.println();
		System.out.println("====== TEST covers method ======");
		System.out.print("Circle : ");
		Circle circle4 = new Circle(new Point(3,4), 2);
		System.out.print(circle4.covers(new Point(2,3)) + " "); //TRUE
		System.out.println(circle4.covers(new Point(9,6))); //FALSE
		
		System.out.print("Rectangle : ");
		Rectangle rectangle4 = new Rectangle(new Point(3,4), 5, 6);
		System.out.print(rectangle4.covers(new Point(5,6)) + " "); //TRUE
		System.out.println(rectangle4.covers(new Point(2,2))); //FALSE
		
		System.out.print("Segment : ");
		Segment segment4 = new Segment(new Point(3,4), 5, true);
		System.out.print(segment4.covers(new Point(5,4)) + " "); //TRUE
		System.out.println(segment4.covers(new Point(3,12))); //FALSE
		
		System.out.println();
		System.out.println("====== TEST getFigureCoveringPoint ======");
		Optional<Figure> firstFigureCoveringPoint = FigureUtil.getFigureCoveringPoint(new Point(), drawing2);
		if(firstFigureCoveringPoint.isPresent()) {
			System.out.println(FigureUtil.getFigureCoveringPoint(new Point(), drawing2));			
		} else {
			System.out.println("There is no figure in the drawing covering the point [25;25]");
		}
		
		System.out.println();
		System.out.println("====== TEST originDistance ======");
		// TODO : Tester distanceOrigin
		
		System.out.println();
		
		System.out.println("====== TEST closestToOriginSort ======");
		System.out.print("Unsorted ");
		drawing2.display();
		List<Figure> figures2 = FigureUtil.closestToOriginSort(drawing2);
		System.out.println("Sorted figures : " + figures2);
		
		System.out.println();
		System.out.println("====== TEST areaDescendingSort ======");
		Collection<Surfacable> unsortedSurfacables = new ArrayList<>();
		unsortedSurfacables = FigureUtil.generateSurfacables(5);
		System.out.println("Unsorted surfacable : " + unsortedSurfacables);
		
		List<Surfacable> sortedSurfacables = FigureUtil.areaDescendingSort(drawing2);
		System.out.println("Sorted surfacable : " + sortedSurfacables);
		
		
		// TODO : Tester gestion des couleurs de figures
		
		FigureUtil.print(drawing2);
	}

}
