package m2s7_abstract_class_interface.m2s7_review.resizeable_interface;

import m2s6_inherritance.m2s6_dont_review.shape_object.Square;

public class SquareResizeable extends Square implements Resizeable {
    public SquareResizeable() {
    }

    public SquareResizeable(double size) {
        super(size);
    }

    public SquareResizeable(String color, boolean filled, double size) {
        super(color, filled, size);
    }

    @Override
    public void resize(double percent) {
        this.setSize(this.getSize() * percent);
    }
}