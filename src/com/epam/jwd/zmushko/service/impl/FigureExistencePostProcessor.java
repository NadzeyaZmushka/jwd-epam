package com.epam.jwd.zmushko.service.impl;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.Triangle;
import com.epam.jwd.zmushko.model.Square;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.model.Line;
import com.epam.jwd.zmushko.model.SimpleFigureFactory;
import com.epam.jwd.zmushko.service.FigurePostProcessor;
import com.epam.jwd.zmushko.service.FigureValidator;

public class FigureExistencePostProcessor implements FigurePostProcessor {
    FigureFactory factory = new SimpleFigureFactory();

    public FigureExistencePostProcessor(Figure figure) {
    }

    @Override
    public Figure process(Figure figure) throws FigureCannotExistException {
        if (figure.getType().equals(FigureType.POINT)){
            return figure;
        }
        if (figure.getType().equals(FigureType.LINE)) {
            FigureValidator.isLine((Line) figure);
        } else if (figure.getType().equals(FigureType.TRIANGLE)) {
            FigureValidator.isTriangle((Triangle) figure);
        } else if (figure.getType().equals(FigureType.SQUARE)) {
            FigureValidator.isSquare((Square) figure);
        }
        return figure;
    }
}
