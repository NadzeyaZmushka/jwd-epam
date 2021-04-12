package com.epam.jwd.zmushko.exception;

public class FigureCannotExistException extends FigureException {
    public FigureCannotExistException() {
        super();
    }

    public FigureCannotExistException(String message) {
        super(message);
    }
}