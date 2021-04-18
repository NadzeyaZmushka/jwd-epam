package com.epam.jwd.zmushko.factory;

import com.epam.jwd.zmushko.decorator.PostProcessingFactory;
import com.epam.jwd.zmushko.decorator.PreProcessingFactory;
import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.model.Point;
import com.epam.jwd.zmushko.model.SimpleFigureFactory;

public interface FigureFactory {
    Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException;

    static FigureFactory newInstance() {
        return new PostProcessingFactory(
                new PreProcessingFactory(
                        SimpleFigureFactory.getInstance()
                )
        );
    }
}
