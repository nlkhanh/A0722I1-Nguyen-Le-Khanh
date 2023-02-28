package m2s4_class_object.m2s4_review;

public class QuadraticEquation {
    private double firstCoefficient, secondCoefficient, constantTerm;

    public QuadraticEquation(double firstCoefficient, double secondCoefficient, double constantTerm) {
        this.firstCoefficient = firstCoefficient;
        this.secondCoefficient = secondCoefficient;
        this.constantTerm = constantTerm;
    }

    public double getFirstCoefficient() {
        return this.firstCoefficient;
    }

    public double getSecondCoefficient() {
        return this.secondCoefficient;
    }

    public double getConstantTerm() {
        return this.constantTerm;
    }

    public double getDiscriminant() {
        return Math.pow(this.secondCoefficient, 2) - (4 * this.firstCoefficient * this.constantTerm);
    }

    public double getFirstRoot() {
        if (this.getDiscriminant() < 0) {
            return 0;
        } else {
            return (-this.secondCoefficient + Math.pow(this.getDiscriminant(), 0.5)) / (2 * this.firstCoefficient);
        }
    }

    public double getSecondRoot() {
        if (this.getDiscriminant() < 0) {
            return 0;
        } else {
            return (-this.secondCoefficient - Math.pow(this.getDiscriminant(), 0.5)) / (2 * this.firstCoefficient);
        }
    }
}