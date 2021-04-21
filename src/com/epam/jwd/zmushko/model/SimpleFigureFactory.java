package com.epam.jwd.zmushko.model;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleFigureFactory implements FigureFactory {
    public static final Logger LOGGER = LogManager.getLogger();

    private static SimpleFigureFactory instance;

    private SimpleFigureFactory() {
    }

    public static SimpleFigureFactory getInstance() {
        if (instance == null) {
            instance = new SimpleFigureFactory();
        }
        return instance;
    }

    public Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException {
        LOGGER.info("Creating figure");
        Figure figure = null;
        switch (type) {
            case LINE:
                figure = Line.create(figureConstituents);
                break;
            case TRIANGLE:
                figure = Triangle.create(figureConstituents);
                break;
            case SQUARE:
                figure = Square.create(figureConstituents);
                break;
            case MULTI_ANGLE_FIGURE:
                if (figureConstituents.length == 4) {
                    figure = new MultiAngleFigure.Builder().withFourAngles(figureConstituents).build(figureConstituents);
                } else if (figureConstituents.length == 5) {
                    figure = new MultiAngleFigure.Builder().withFiveAngles(figureConstituents).build(figureConstituents);
                } else if (figureConstituents.length == 6) {
                    figure = new MultiAngleFigure.Builder().withSixAngles(figureConstituents).build(figureConstituents);
                }
                break;
            default:
                throw new FigureCannotExistException("Unknown type");
        }
        return figure;
    }
}
