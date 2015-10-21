package swe.designpatterns;

public class FactoryPatternDemo {
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		
		Shape shape1 = shapeFactory.getShape(ShapeType.RECTANGLE);
		shape1.draw();

		Shape shape2 = shapeFactory.getShape(ShapeType.CIRCLE);
		shape2.draw();

		Shape shape3 = shapeFactory.getShape(ShapeType.SQUARE);
		shape3.draw();
	}
}
