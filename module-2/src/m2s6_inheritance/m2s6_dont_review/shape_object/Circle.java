package m2s6_inheritance.m2s6_dont_review.shape_object;

public class Circle extends Shape {
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.getRadius(), 2);
    }

    public double getPerimeter() {
        return Math.PI * this.getRadius() * 2;
    }

    @Override
    public String toString() {
        return "A Circle with radius=" + this.getRadius() + ", which is a subclass of " + super.toString();
    }
}