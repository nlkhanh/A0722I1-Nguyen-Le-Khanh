package m2s7_abstract_class_interface.m2s7_review.colorable_interface;

import m2s6_inherritance.m2s6_dont_review.shape_object.Square;

public class SquareColorable extends Square implements Colorable {
    public SquareColorable() {
    }

    public SquareColorable(double size) {
        super(size);
    }

    public SquareColorable(String color, boolean filled, double size) {
        super(color, filled, size);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
