package com.epam.jwd.zmushko.exception;

public class FigureCannotExistException extends FigureException {
    private static final long serialVersionUID = -6709104358734083286L;

    public FigureCannotExistException() {
        super();
    }

    public FigureCannotExistException(String message) {
        super(message);
    }
}