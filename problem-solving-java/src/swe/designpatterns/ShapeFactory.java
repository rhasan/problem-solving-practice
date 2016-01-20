package swe.designpatterns;

public class ShapeFactory {
	public Shape getShape(ShapeType shapeType) {
		switch(shapeType) {
			case RECTANGLE:
				return new Rectangle();
			case SQUARE:
				return new Square();
			case CIRCLE:
				return new Circle();
			default: 
				return null;
		}
	}
}
