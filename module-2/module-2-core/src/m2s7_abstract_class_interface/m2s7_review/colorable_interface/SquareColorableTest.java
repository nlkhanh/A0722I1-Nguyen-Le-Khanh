package m2s7_abstract_class_interface.m2s7_review.colorable_interface;

import m2s6_inheritance.m2s6_dont_review.shape_object.*;

public class SquareColorableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle("red", false, 2.3);
        shapes[1] = new Rectangle("red", false, 4.2, 6.5);
        shapes[2] = new SquareColorable("red", false, 3.4);

        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println(((Circle) shape).getArea());
            } else if (shape instanceof Rectangle) {
                System.out.println(((Rectangle) shape).getArea());
            }
            if (shape instanceof Colorable) {
                ((SquareColorable) shape).howToColor();
            }
        }
    }
}