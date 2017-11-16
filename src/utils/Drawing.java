package utils;

import java.util.HashSet;
import java.util.Collection;

public class Drawing {
	
	/*
	 * HashSet car les doublons sont inutiles dans un dessin
	 * et nous n'avons pas besoin d'un ordre spécifique
	 */
	private Collection<Figure> figures = new HashSet<>();
	
	public Drawing() {
	}
	
	public boolean add(Figure figure) {
		return this.figures.add(figure);
	}
	
	public Collection<Figure> getFigures() {
		return this.figures;
	}
	
	public void setFigures(Collection<Figure> figures) {
		this.figures = new HashSet<>(figures);
	}
	
	@Override
	public String toString() {
		return "Drawing : [figures=" + figures + "]";
	}

	public void display() {
		System.out.println(this.toString());
	}
	
}
