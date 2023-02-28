package m2s7_abstract_class_interface.m2s7_review.resizeable_interface;

import m2s6_inheritance.m2s6_dont_review.shape_object.Circle;

public class CircleResizeable extends Circle
        implements Resizeable {
    public CircleResizeable() {
    }

    public CircleResizeable(double radius) {
        super(radius);
    }

    public CircleResizeable(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }

    @Override
    public void resize(double percent) {
        this.setRadius(this.getRadius() * percent);
    }
}