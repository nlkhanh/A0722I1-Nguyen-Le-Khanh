package utils.user_exception;


public class UserException extends Exception {
    @Override
    public String getMessage() {
        return "Oops! you have a mistake!";
    }
}
