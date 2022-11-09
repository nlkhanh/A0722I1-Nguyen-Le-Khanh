package m2s7_abstract_class_interface.m2s7_dont_review.comparator_interface;

import m2s6_inheritance.m2s6_dont_review.shape_object.Circle;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle circle1, Circle circle2) {
       return Double.compare(circle1.getRadius(), circle2.getRadius());
    }
}