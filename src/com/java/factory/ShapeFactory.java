package com.java.factory;

public class ShapeFactory {

    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        }
        else if (shapeType.equalsIgnoreCase("Square")) {
            return new Square();
        }
        return null;
    }

    public static void main(String[] args) {
        ShapeFactory obj = new ShapeFactory();
        Shape shape = obj.getShape("Rectangle");
        if (shape != null)
            shape.draw();
    }
}
