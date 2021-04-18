package com.epam.jwd.zmushko.service.impl;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.service.FigurePostProcessor;
import com.epam.jwd.zmushko.validation.FigureValidator;

public class FigureExistencePostProcessor implements FigurePostProcessor {

    @Override
    public Figure process(Figure figure) throws FigureException {
        if (figure.getType().equals(FigureType.LINE)) {
            if (FigureValidator.isLine(figure)) {
                return figure;
            }
        } else if (figure.getType().equals(FigureType.TRIANGLE)) {
            if (FigureValidator.isTriangle(figure)) {
                return figure;
            }
        } else if (figure.getType().equals(FigureType.SQUARE)) {
            if (FigureValidator.isSquare(figure)) {
                return figure;
            }
        } else if (figure.getType().equals(FigureType.MULTI_ANGLE_FIGURE)) {
            if (FigureValidator.isMultiAngle(figure)) {
                return figure;
            }
        } else {
            throw new FigureCannotExistException("Figure cannot exist");
        }
        return figure;
    }
}
