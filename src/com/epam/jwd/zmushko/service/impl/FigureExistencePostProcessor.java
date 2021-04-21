package com.epam.jwd.zmushko.service.impl;

import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.service.FigurePostProcessor;
import com.epam.jwd.zmushko.validation.FigureValidator;

public class FigureExistencePostProcessor implements FigurePostProcessor {

    @Override
    public Figure process(Figure figure) throws FigureException {
        if ((figure.getType() == FigureType.LINE && FigureValidator.isLine(figure)) ||
                (figure.getType() == FigureType.TRIANGLE && FigureValidator.isTriangle(figure)) ||
                (figure.getType() == FigureType.SQUARE && FigureValidator.isSquare(figure)) ||
                (figure.getType() == FigureType.MULTI_ANGLE_FIGURE && FigureValidator.isMultiAngle(figure))
        ) {
            return figure;
        }
        return figure;
    }
}
