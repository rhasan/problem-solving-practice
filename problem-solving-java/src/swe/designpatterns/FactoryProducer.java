package swe.designpatterns;

public class FactoryProducer {
	public static AbstractFactory getFactory(FactoryType factoryType) {
		
		switch(factoryType) {
		case COLOR:
			return new ColorFactoryA();
		case SHAPE:
			return new ShapeFactoryA();
		default:
			return null;
		}
	}
}
