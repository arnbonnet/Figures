package utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class FigureUtil {
	private static final int X_MIN = 0;
	private static final int X_MAX = 99;

	private static final int Y_MIN = 0;
	private static final int Y_MAX = 99;
	
	private static int getRandomInt(int max) {
		Random random = new Random();
		return random.nextInt(max);
	}

	private static Point getRandomPoint() {
		return new Point(getRandomInt(100), getRandomInt(100));

	}
	
	private static Color getRandomColor() {
		Color values[] = Color.values();
		int index = getRandomInt(values.length);
		return values[index];
	}

	public static Circle getRandomCircle() {
		return new Circle(getRandomPoint(), getRandomInt(100), getRandomColor());
	}

	public static Rectangle getRandomRectangle(boolean isSquare) {
		if(isSquare) {
			return new Square(getRandomPoint(), getRandomInt(100), getRandomColor());
		} else {
			return new Rectangle(getRandomPoint(), getRandomInt(100), getRandomInt(100), getRandomColor());			
		}
	}
	
	public static Segment getRandomSegment() {
		if(getRandomInt(2) == 0) {
			return new Segment(getRandomPoint(), getRandomInt(100), false, getRandomColor());
		} else {
			return new Segment(getRandomPoint(), getRandomInt(100), true, getRandomColor());
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

	public static Collection<Surfacable> generateSurfacables(int nbSurfacables) {
		HashSet<Surfacable> surfacables = new HashSet<>();
		while(surfacables.size() < nbSurfacables) {
			surfacables.add(getRandomSurfacable());
		}
		
		return surfacables;
	}
	
	public static Optional<Figure> getFigureCoveringPoint(Point point, Drawing drawing) {
		return drawing.getFigures().stream()
				.filter(f -> f.covers(point))
				.findFirst();
	}
	
	public static List<Figure> closestToOriginSort(Drawing drawing){
		return drawing.getFigures().stream()
				.sorted()
				.collect(Collectors.toList());
	}
	
	public static List<Surfacable> areaDescendingSort(Drawing drawing){
		return drawing.getFigures().stream()
				.filter(f -> f instanceof Surfacable)
				.map(x -> (Surfacable) x)
				.sorted( (f1,f2) -> f1.getArea() > f2.getArea() ? -1 : 1)
				.collect(Collectors.toList());
	}
	
	public static void print(Drawing drawing) {
		try {
			File file = File.createTempFile("drawing", ".txt"); 
			PrintWriter printWriter = new PrintWriter(file);
			drawing.getFigures().stream()
			.forEach(f -> printWriter.println(f.toString()));
			
			for(int x=X_MIN; x<X_MAX; x++) {
				printWriter.print("=");
			}
			printWriter.println();
			
			for(int y=Y_MIN; y<Y_MAX; y++) {
				for(int x=X_MIN; x<X_MAX; x++) {
					Optional<Figure> figure = FigureUtil.getFigureCoveringPoint(new Point(x,y), drawing);
					if(figure.isPresent()) {
						printWriter.print(figure.get().getColor().getCode());
					} else {
						printWriter.print(" ");
					}
				}
				printWriter.println();
			}
			
			System.out.println("File location " + file.getAbsolutePath());
			printWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
}
