package swe.designpatterns;

public class ColorFactoryA extends AbstractFactory {

	@Override
	public Color getColor(ColorName colorName) {
		switch(colorName) {
		case RED:
			return new Red();
		case GREEN:
			return new Green();
		case BLUE:
			return new Blue();
		default:
			return null;
		}
	}

	@Override
	public Shape getShape(ShapeType shapeType) {
		return null;
	}

}
