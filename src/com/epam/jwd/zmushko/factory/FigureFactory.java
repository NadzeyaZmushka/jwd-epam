package com.epam.jwd.zmushko.factory;

import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.model.Point;

public interface FigureFactory {
    Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException;

}
