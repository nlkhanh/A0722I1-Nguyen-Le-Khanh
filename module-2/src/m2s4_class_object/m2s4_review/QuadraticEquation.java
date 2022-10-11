package m2s4_class_object.m2s4_review;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getDiscriminant() {
        return Math.pow(this.b, 2) - (4 * this.a * this.c);
    }

    public double getRoot1() {
        if (this.getDiscriminant() < 0) {
            return 0;
        } else {
            return (-this.b + Math.pow(this.getDiscriminant(), 0.5)) / (2 * this.a);
        }
    }

    public double getRoot2() {
        if (this.getDiscriminant() < 0) {
            return 0;
        } else {
            return (-this.b - Math.pow(this.getDiscriminant(), 0.5)) / (2 * this.a);
        }
    }
}