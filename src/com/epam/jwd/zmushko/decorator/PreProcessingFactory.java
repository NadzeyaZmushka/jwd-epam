package com.epam.jwd.zmushko.decorator;

import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.model.Point;
import com.epam.jwd.zmushko.validation.CheckDataFromFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PreProcessingFactory extends FigureFactoryDecorator {
    public static final Logger LOGGER = LogManager.getLogger();

    private final FigureFactory figureFactory;

    private final CheckDataFromFile checkData = new CheckDataFromFile();

    public PreProcessingFactory(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException {
        LOGGER.info("Pre process: ");
        if (!checkData.isValidData()) {
            throw new FigureException("Invalid data");
        }
        LOGGER.info("Data is valid");
        return figureFactory.createFigure(type, figureConstituents);
    }
}
