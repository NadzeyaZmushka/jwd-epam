package com.epam.jwd.zmushko.model;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import com.epam.jwd.zmushko.service.FigurePostProcessor;
import com.epam.jwd.zmushko.service.impl.FigureExistencePostProcessor;
import com.epam.jwd.zmushko.validation.CheckDataFromFile;

public class SimpleFigureFactory implements FigureFactory {
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
        Figure figure = null;
        FigurePostProcessor processor = new FigureExistencePostProcessor();
        CheckDataFromFile data = new CheckDataFromFile();
        if (data.isValidData()) {
            switch (type) {
                case LINE:
                    figure = Line.createLine(figureConstituents);
                    break;
                case TRIANGLE:
                    figure = Triangle.createTriangle(figureConstituents);
                    break;
                case SQUARE:
                    figure = Square.createSquare(figureConstituents);
                    break;
                case MULTI_ANGLE_FIGURE:
                    if (figureConstituents.length == 4) {
                        figure = new MultiAngleFigure.Builder().withFourAngles(figureConstituents).build();
                    } else if (figureConstituents.length == 5) {
                        figure = new MultiAngleFigure.Builder().withFiveAngles(figureConstituents).build();
                    } else if (figureConstituents.length == 6) {
                        figure = new MultiAngleFigure.Builder().withSixAngles(figureConstituents).build();
                    }
                    break;
                default:
                    throw new FigureCannotExistException("unknown type");
            }
        }
        return processor.process(figure);
    }
}
