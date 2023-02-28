package m2s6_inheritance.m2s6_review.point2d_point3d;

public class PointTwoDimensions {
    private float x;
    private float y;

    public PointTwoDimensions() {
    }

    public PointTwoDimensions(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        return new float[]{this.getX(), this.getY()};
    }

    public void setXY(float x, float y) {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public String toString() {
        return "(" + this.getX() + "," + this.getY() +")";
    }
}