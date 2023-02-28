package m2s7_abstract_class_interface.m2s7_dont_review.comparable_interface;

import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle();
        circles[1] = new ComparableCircle(5.0);
        circles[2] = new ComparableCircle("indigo", false, 2.3);

        System.out.println("Pre-sorted: ");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }

        Arrays.sort(circles);

        System.out.println("Post-sorted: ");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
    }
}