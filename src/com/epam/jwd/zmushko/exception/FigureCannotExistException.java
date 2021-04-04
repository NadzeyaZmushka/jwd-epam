package com.epam.jwd.zmushko.exception;

public class FigureCannotExistException extends Exception {
    public FigureCannotExistException() {
    }

    public FigureCannotExistException(String message) {
        super(message);
    }
}
