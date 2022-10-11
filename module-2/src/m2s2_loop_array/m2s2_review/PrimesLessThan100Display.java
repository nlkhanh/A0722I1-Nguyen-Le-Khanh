package m2s2_loop_array.m2s2_review;

public class PrimesLessThan100Display {
    public static void main(String[] args) {
        System.out.print("Primes less than 100 is: ");
        int number = 2;
        while (number < 100) {
            int i = 2;
            boolean check = true;
            while (i < number) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check) {
                System.out.print(number + " ");
            }
            number++;
        }
    }
}