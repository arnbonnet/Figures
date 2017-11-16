package utils;

public class Square extends Rectangle {

	public Square(Point point, int side) {
		super(point, side, side);
	}
	
	public int getSide() {
		return getWidth();
	}

	public void setSide(int side) {
		super.setHeight(side);
		super.setWidth(side);
	}
	
	public void setHeight(int side) {
		super.setHeight(side);
		super.setWidth(side);
	}
	
	public void setWidth(int side) {
		super.setWidth(side);
		super.setHeight(side);
	}
	
	protected String getType() {
		return "Square";
	}
	
}
