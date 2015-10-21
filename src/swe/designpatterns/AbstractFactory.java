package swe.designpatterns;

public abstract class AbstractFactory {
	abstract public Color getColor(ColorName colorName);
	abstract public Shape getShape(ShapeType shapeType);
}
