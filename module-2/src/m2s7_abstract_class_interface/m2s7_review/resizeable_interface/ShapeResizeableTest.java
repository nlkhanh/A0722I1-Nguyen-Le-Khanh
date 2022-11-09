package m2s7_abstract_class_interface.m2s7_review.resizeable_interface;

import m2s6_inheritance.m2s6_dont_review.shape_object.*;

public class ShapeResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new CircleResizeable(3.5);
        shapes[1] = new RectangleResizeable(2.0, 5.0);
        shapes[2] = new SquareResizeable("red", false, 1.3);

        System.out.println("Pre-resize: ");
        for (Shape shape : shapes) {
            if (shape instanceof CircleResizeable) {
                System.out.println((CircleResizeable) shape);
            } else if (shape instanceof RectangleResizeable) {
                System.out.println((RectangleResizeable) shape);
            } else {
                System.out.println((SquareResizeable) shape);
            }
        }

        for (Shape shape : shapes) {
            if (shape instanceof CircleResizeable) {
                ((CircleResizeable) shape).resize(0.5);
            } else if (shape instanceof RectangleResizeable) {
                ((RectangleResizeable) shape).resize(1.5);
            } else {
                ((SquareResizeable) shape).resize(2.0);
            }
        }

        System.out.println("Post-resize: ");
        for (Shape shape : shapes) {
            if (shape instanceof CircleResizeable) {
                System.out.println((CircleResizeable) shape);
            } else if (shape instanceof RectangleResizeable) {
                System.out.println((Rectangle) shape);
            } else {
                System.out.println((SquareResizeable) shape);
            }
        }
    }
}