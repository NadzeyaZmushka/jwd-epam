package com.epam.jwd.zmushko.model;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleFigureFactory implements FigureFactory {
    static final Logger LOGGER = LogManager.getLogger(SimpleFigureFactory.class);

    public Figure createFigure(FigureType type, int points) throws FigureCannotExistException {
        Figure figure = null;
        switch (type) {
            case POINT:
                figure = Point.createPoint();
                break;
            case LINE:
                figure = Line.createLine(Point.createPoint(), Point.createPoint());
                break;
            case TRIANGLE:
                figure = Triangle.createTriangle(Point.createPoint(), Point.createPoint(),
                        Point.createPoint());
                break;
            case SQUARE:
                figure = Square.createSquare(Point.createPoint(), Point.createPoint(),
                        Point.createPoint(), Point.createPoint());
                break;
            case MULTI_ANGLE_FIGURE:
                switch (points) {
                    case 4:
                        figure = MultiAngleFigure.createFigure(4);
                        break;
                    case 5:
                        figure = MultiAngleFigure.createFigure(5);
                        break;
                    case 6:
                        figure = MultiAngleFigure.createFigure(6);
                        break;
                    default:
                        LOGGER.error("other figure");
                }
                break;
            default:
                throw new FigureCannotExistException();
        }
        return figure;
    }
}
