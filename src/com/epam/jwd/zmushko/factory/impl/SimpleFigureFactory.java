package com.epam.jwd.zmushko.factory.impl;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.model.Line;
import com.epam.jwd.zmushko.model.MultiAngleFigure;
import com.epam.jwd.zmushko.model.Point;
import com.epam.jwd.zmushko.model.Square;
import com.epam.jwd.zmushko.model.Triangle;
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

    public Figure createFigure(FigureType type, Point[] points) throws FigureException {
        LOGGER.info("Creating figure");
        Figure figure = null;
        switch (type) {
            case LINE:
                figure = Line.create(points);
                break;
            case TRIANGLE:
                figure = Triangle.create(points);
                break;
            case SQUARE:
                figure = Square.create(points);
                break;
            case MULTI_ANGLE_FIGURE:
                if (points.length == 4) {
                    figure = new MultiAngleFigure.Builder().withFourAngles(points).build(points);
                } else if (points.length == 5) {
                    figure = new MultiAngleFigure.Builder().withFiveAngles(points).build(points);
                } else if (points.length == 6) {
                    figure = new MultiAngleFigure.Builder().withSixAngles(points).build(points);
                }
                break;
            default:
                throw new FigureCannotExistException("Unknown type");
        }
        return figure;
    }

}
