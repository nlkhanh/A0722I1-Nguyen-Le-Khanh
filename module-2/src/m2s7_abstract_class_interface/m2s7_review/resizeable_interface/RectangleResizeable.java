package m2s7_abstract_class_interface.m2s7_review.resizeable_interface;

import m2s6_inheritance.m2s6_dont_review.shape_object.Rectangle;

public class RectangleResizeable extends Rectangle implements Resizeable {
    public RectangleResizeable() {
    }

    public RectangleResizeable(double width, double length) {
        super(width, length);
    }

    public RectangleResizeable(String color, boolean filled, double width, double length) {
        super(color, filled, width, length);
    }

    @Override
    public void resize(double percent) {
        this.setWidth(this.getWidth() * percent);
        this.setLength(this.getLength() * percent);
    }
}