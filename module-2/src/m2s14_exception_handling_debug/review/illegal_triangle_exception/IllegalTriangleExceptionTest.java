package m2s14_exception_handling_debug.review.illegal_triangle_exception;

import java.util.Scanner;

public class IllegalTriangleExceptionTest {

    private static void inputSides() throws IllegalTriangleException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first side of triangle: ");
        double firstSide = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter second side of triangle: ");
        double secondSide = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter third side of triangle: ");
        double thirdSide = Double.parseDouble(scanner.nextLine());

        if (!isTriangle(firstSide, secondSide, thirdSide)) {
            throw new IllegalTriangleException();
        }
    }

    private static boolean isTriangle(double firstSide, double secondSide, double thirdSide) {
        boolean isNegativeSide = firstSide * secondSide * thirdSide < 0;
        boolean isRightSide = ((firstSide + secondSide) > thirdSide) && ((firstSide + thirdSide) > secondSide) && ((secondSide + thirdSide) > firstSide);
        return (!isNegativeSide && isRightSide);
    }

    public static void main(String[] args) {
        try {
            inputSides();
            System.out.println("Is Triangle!");
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}
