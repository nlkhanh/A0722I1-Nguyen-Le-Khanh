package m2s2_loop_array.m2s2_review;

import java.util.Scanner;

public class GeometriesDisplay {
    public static void main(String[] args) {
        int choice;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Menu: ");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle (the corner is square at 4 different angles: top-left, top-right, bottom-left, bottom-right");
            System.out.println("3. Print the isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Draw the rectangle");
                    int widthRec = 7;
                    int heightRec = 3;
                    for (int i = 1; i <= heightRec; i++) {
                        for (int j = 1; j <= widthRec; j++) {
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    int sizeSquareTri = 5;
                    System.out.println("Draw the square triangle top-left: ");
                    for (int i = 1; i <= sizeSquareTri; i++) {
                        for (int j = 1; j <= sizeSquareTri; j++) {
                            if (j <= (sizeSquareTri - i + 1)) {
                                System.out.print("* ");
                            } else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println("");
                    }
                    System.out.println("Draw the square triangle top-right: ");
                    for (int i = 1; i <= sizeSquareTri; i++) {
                        for (int j = 1; j <= sizeSquareTri; j++) {
                            if (j >= i) {
                                System.out.print("* ");
                            } else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println("");
                    }
                    System.out.println("Draw the square triangle bottom-left: ");
                    for (int i = 1; i <= sizeSquareTri; i++) {
                        for (int j = 1; j <= sizeSquareTri; j++) {
                            if (j <= i) {
                                System.out.print("* ");
                            }
                        }
                        System.out.println("");
                    }
                    System.out.println("Draw the square triangle bottom-right: ");
                    for (int i = 1; i <= sizeSquareTri; i++) {
                        for (int j = 1; j <= sizeSquareTri; j++) {
                            if (j > (sizeSquareTri - i)) {
                                System.out.print("* ");
                            } else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println("");
                    }
                    break;
                case 3:
                    int widthIsoTri = 11;
                    int heightIsoTri = (widthIsoTri - 1) / 2;
                    System.out.println("Draw the isosceles triangle: ");
                    for (int i = 1; i <= heightIsoTri; i++) {
                        for (int j = 1; j <= widthIsoTri; j++) {
                            if ((j >= heightIsoTri - (i - 1)) && (j <= heightIsoTri + (i - 1))) {
                                System.out.print("* ");
                            } else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println("");
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        } while (choice != 4);
    }
}