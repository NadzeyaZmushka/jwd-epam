package com.epam.jwd.zmushko.decorator;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.FigureType;

public abstract class FigureFactoryDecorator implements FigureFactory {
    FigureFactory figureFactory;
    @Override
    public Figure createFigure(FigureType type, int points) throws FigureCannotExistException {
        return figureFactory.createFigure(type,points);
    }
}
