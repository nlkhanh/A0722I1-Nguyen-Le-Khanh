package m2s14_exception_handling_debug.review.illegal_triangle_exception;

public class IllegalTriangleException extends Exception{
    @Override
    public String getMessage() {
        return "IllegalTriangleException: your input sides is not a triangle";
    }
}
