package m2s6_inherritance.m2s6_dont_review.shape_object;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(double size) {
        super(size, size);
    }

    public Square(String color, boolean filled, double size) {
        super(color, filled, size, size);
    }

    public double getSize() {
        return super.getWidth();
    }

    public void setSize(double size) {
        super.setWidth(size);
        super.setLength(size);
    }

    @Override
    public void setWidth(double width) {
        this.setSize(width);
    }

    @Override
    public void setLength(double length) {
        this.setSize(length);
    }

    @Override
    public String toString() {
        return "A square with size=" + this.getSize() + ", which is subclass of " + super.toString();
    }
}