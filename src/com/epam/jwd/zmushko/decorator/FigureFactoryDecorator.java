package com.epam.jwd.zmushko.decorator;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.model.Point;

public abstract class FigureFactoryDecorator implements FigureFactory {
    FigureFactory figureFactory;

    @Override
    public Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException {
        return figureFactory.createFigure(type, figureConstituents);
    }
}
