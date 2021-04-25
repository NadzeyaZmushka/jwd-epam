package com.epam.jwd.zmushko.decorator;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.model.Point;
import com.epam.jwd.zmushko.validation.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PreProcessingFactory extends FigureFactoryDecorator {

    public static final Logger LOGGER = LogManager.getLogger();

    private final FigureFactory figureFactory;

    private final DataValidator checkData = new DataValidator();

    public PreProcessingFactory(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException {
        Figure figure;

        LOGGER.info("Pre process: ");

        if (checkData.isValidDataFromFile()) {
            LOGGER.info("Data is valid");
            figure = figureFactory.createFigure(type, figureConstituents);
        } else {
            throw new FigureCannotExistException("Invalid data");
        }
        return figure;
    }
}
