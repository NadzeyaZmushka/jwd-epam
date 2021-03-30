package com.epam.jwd.exception;

public class FigureCannotExistException extends RuntimeException {
    public FigureCannotExistException() {
    }

    public FigureCannotExistException(String message) {
        super(message);
    }

    public FigureCannotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public FigureCannotExistException(Throwable cause) {
        super(cause);
    }
}
