package m2s4_class_object.m2s4__dont_review.stop_watch;

import java.util.Arrays;

public class StopWatchTest {
    public static void main(String[] args) {
        double[] numbers = new double[100000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Math.random() * 10;
        }
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println("Start time is: " + watch.getStartTime());
        Arrays.sort(numbers);
        watch.end();
        System.out.println("End time is: " + watch.getEndTime());
        System.out.println("Elapse time is: " + watch.getElapsedTime());
    }
}