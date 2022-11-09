package m2s7_abstract_class_interface.m2s7_dont_review.comparable_interface;

import m2s6_inheritance.m2s6_dont_review.shape_object.*;

public class ComparableCircle extends Circle
        implements Comparable<ComparableCircle> {
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }

    @Override
    public int compareTo(ComparableCircle circle) {
        return Double.compare(this.getRadius(), circle.getRadius());
    }
}