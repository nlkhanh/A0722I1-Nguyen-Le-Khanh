package m2s2_loop_array.m2s2_review;

public class First20PrimesDisplay {
    public static void main(String[] args) {
        System.out.print("First 20 primes is: ");
        int count = 0;
        int number = 2;
        while (count < 20) {
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
                count++;
            }
            number++;
        }
    }
}