package m2s4_class_object.m2s4_review;

public class Fan {
    final static int SLOW = 1;
    final static int MEDIUM = 2;
    final static int FAST = 3;

    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public Fan() {
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return this.on;
    }

    public void setStatus(boolean status) {
        this.on = status;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (this.isOn()) {
            return "Speed is " + this.getSpeed() + "\n" + "Color is " + this.getColor() + "\n" + "Radius is " + this.getRadius() + "\nFan is on";
        } else {
            return "Color is " + this.getColor() + "\n" + "Radius is " + this.getRadius() + "\nFan is off";
        }
    }
}