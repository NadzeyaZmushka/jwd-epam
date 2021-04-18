package com.epam.jwd.zmushko.decorator;

import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.model.Point;
import com.epam.jwd.zmushko.service.FigurePostProcessor;
import com.epam.jwd.zmushko.service.impl.FigureExistencePostProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PostProcessingFactory extends FigureFactoryDecorator {

    public static final Logger LOGGER = LogManager.getLogger();

    private final FigureFactory figureFactory;

    private final FigurePostProcessor postProcessor = new FigureExistencePostProcessor();

    public PostProcessingFactory(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException {
        Figure figure = figureFactory.createFigure(type, figureConstituents);
        LOGGER.info("Post process: ");
        figure = postProcessor.process(figure);
        LOGGER.info("Figure " + Figure.getName() + " was created");
        return figure;
    }
}
