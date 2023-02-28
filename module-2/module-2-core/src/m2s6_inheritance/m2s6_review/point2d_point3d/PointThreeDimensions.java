package m2s6_inheritance.m2s6_review.point2d_point3d;

public class PointThreeDimensions extends PointTwoDimensions {
    private float z;

    public PointThreeDimensions() {
    }

    public PointThreeDimensions(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return this.z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ() {
        return new float[]{super.getX(), super.getY(), this.getZ()};
    }

    public void setXYX(float x, float y, float z) {
        super.setXY(x, y);
        this.setZ(z);
    }

    @Override
    public String toString() {
        return "(" + super.getX() + "," + super.getY() + "," + this.getZ() + ")";
    }
}