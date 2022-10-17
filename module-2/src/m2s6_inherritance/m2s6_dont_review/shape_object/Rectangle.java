package m2s6_inherritance.m2s6_dont_review.shape_object;

public class Rectangle extends Shape{
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return this.getWidth() * this.getLength();
    }

    public double getPerimeter() {
        return (this.getWidth() + this.getLength()) / 2;
    }

    @Override
    public String toString() {
        return "A Rectangle with width=" + this.getWidth() + " and length=" + this.getLength() + ", which is subclass of " + super.toString();
    }
}