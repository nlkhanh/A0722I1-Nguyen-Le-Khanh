package m2s4_class_object.m2s4__dont_review;

import javafx.scene.paint.Stop;

public class StopWatch {
    private long startTime = System.currentTimeMillis();
    private long endTime;

    public StopWatch() {
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void end() {
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }
}