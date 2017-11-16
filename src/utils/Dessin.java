package utils;

import java.util.ArrayList;
import java.util.Collection;

public class Dessin {
	
	/*
	 * ArrayList car pas beaucoup d'éléments et peu d'insertions et suppressions
	 */
	private ArrayList<Figure> figures;
	
	public Dessin() {
		this.figures = new ArrayList<>();
	}
	
	public boolean add(Figure figure) {
		return this.figures.add(figure);
	}
	
	public Collection<Figure> getFigures() {
		return this.figures;
	}
	
}
