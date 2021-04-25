package com.epam.jwd.zmushko.service.impl;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.service.FigurePostProcessor;

public class FigureExistencePostProcessor implements FigurePostProcessor {

    @Override
    public Figure process(Figure figure) throws FigureException {
        if (figure != null && figure.isValid()) {
            return figure;
        }
        throw new FigureCannotExistException("Invalid figure");
    }

}
