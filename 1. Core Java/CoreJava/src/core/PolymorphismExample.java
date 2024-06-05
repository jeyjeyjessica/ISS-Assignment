package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PolymorphismExample {
    private static final Logger logger = LogManager.getLogger(PolymorphismExample.class);

    public static void main(String[] args) {
    	
        // Compile-time polymorphism (Method Overloading)
    	
        AreaCalculator calculator = new AreaCalculator();
        logger.info("Area of rectangle (5, 10): " + calculator.calculateArea(5, 10));
        logger.info("Area of circle (7): " + calculator.calculateArea(7));

        // Run-time polymorphism (Method Overriding)
        
        Shape shape;

        shape = new Rectangle(5, 10);
        logger.info("Area of rectangle: " + shape.calculateArea());

        shape = new Circle(7);
        logger.info("Area of circle: " + shape.calculateArea());
        
        shape = new Shape();
        logger.info("Base class method called : "+ shape.calculateArea());
    }
}

// Class demonstrating compile-time polymorphism (method overloading)

class AreaCalculator {
	
    // Method to calculate area of a rectangle
	
    public double calculateArea(double length, double width) {
        return length * width;
    }

    // Method to calculate area of a circle
    
    public double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }
}

// Base class Shape

class Shape {
    double calculateArea() {
        return 0;
    }
}

// Subclass Rectangle demonstrating run-time polymorphism (method overriding)

class Rectangle extends Shape {
    private double length;
    private double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }
}

// Subclass Circle demonstrating run-time polymorphism (method overriding)

class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

