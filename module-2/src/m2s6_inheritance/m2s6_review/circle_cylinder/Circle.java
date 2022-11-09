package m2s6_inheritance.m2s6_review.circle_cylinder;

public class Circle {
    private double radius = 1.0;
    private String color = "green";

    public Circle() {

    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.getRadius(), 2);
    }

    public double getPerimeter() {
        return Math.PI * this.getRadius() * 2;
    }

    @Override
    public String toString() {
        return "A circle with radius=" + this.getRadius() + ", and color is " + this.getColor();
    }
}