package utils;

public enum Color {
	Red('R'), Green('G'), Blue('B'), Yellow('Y'), Black('#');
	
	private char code;

	Color(char code) {
		this.code = code;
	}
	
	public char getCode() {
		return this.code;
	}
	
	public static Color getDefaultColor() {
		return Color.Black;
	}
	
}
