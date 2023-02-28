package m2s7_abstract_class_interface.m2s7_dont_review.comparator_interface;

import m2s6_inheritance.m2s6_dont_review.shape_object.Circle;

import java.util.Arrays;

public class CircleComparatorTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle();
        circles[1] = new Circle(10.5);
        circles[2] = new Circle("Red", false, 5.3);

        System.out.println("Pre-sorted: ");
        for (Circle circle : circles) {
            System.out.println(circle);
        }

        Arrays.sort(circles, new CircleComparator());

        System.out.println("Post-sorted: ");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}