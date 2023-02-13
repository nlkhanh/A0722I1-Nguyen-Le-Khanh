package quadratic_equation;

public class QuadraticEquation {
    public static String calculate(double a, double b, double c) {
        double discriminant = (Math.pow(b, 2)) - (4 * a * c);
        if (discriminant > 0) {
            double firstRoot = (-b + Math.sqrt(discriminant)) / (2 * a);
            double secondRoot = (-b - Math.sqrt(discriminant)) / (2 * a);
            return "The equation has two root: " + firstRoot + " and " + secondRoot;
        } else if (discriminant == 0) {
            double root = -b + (2 * a);
            return "The equation has two equal root: " + root;
        }
        return "The equation has no root";
    }
}
