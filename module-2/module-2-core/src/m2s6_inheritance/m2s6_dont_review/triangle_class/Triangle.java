package m2s6_inheritance.m2s6_dont_review.triangle_class;

public class Triangle extends Shape {
    private double size1 = 1.0;
    private double size2 = 1.0;
    private double size3 = 1.0;

    public Triangle() {
    }

    public Triangle(double size1, double size2, double size3) {
        this.size1 = size1;
        this.size2 = size2;
        this.size3 = size3;
    }

    public Triangle(String color, double size1, double size2, double size3) {
        super(color);
        this.size1 = size1;
        this.size2 = size2;
        this.size3 = size3;
    }

    public double getSize1() {
        return this.size1;
    }

    public void setSize1(double size1) {
        this.size1 = size1;
    }

    public double getSize2() {
        return this.size2;
    }

    public void setSize2(double size2) {
        this.size2 = size2;
    }

    public double getSize3() {
        return this.size3;
    }

    public void setSize3(double size3) {
        this.size3 = size3;
    }

    public double getPerimeter() {
        return this.getSize1() + this.getSize2() + this.getSize3();
    }

    public double getArea() {
        double halfPerimeter = this.getPerimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - this.getSize1()) * (halfPerimeter - this.getSize2()) * (halfPerimeter - this.getSize3()));
    }

    @Override
    public String toString() {
        return "A triangle with edge1=" + this.getSize1() + ", edge2=" + this.getSize2() + ", edge3=" + this.getSize3() + ", which is subclass of " + super.toString();
    }
}