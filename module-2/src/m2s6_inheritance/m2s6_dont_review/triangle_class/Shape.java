package m2s6_inheritance.m2s6_dont_review.triangle_class;

public class Shape {
    private String color = "red";

    public Shape() {
    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "A shape with color is: " + this.getColor();
    }
}