package com.epam.jwd.zmushko.factory;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.FigureType;

public interface FigureFactory {
    Figure createFigure(FigureType type, int points) throws FigureCannotExistException;
}
