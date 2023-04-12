package codegym.exception;

import codegym.model.Comment;

public class BadWordFilterException extends Exception{
    public BadWordFilterException(String message) {
        super(message);
    }
}
