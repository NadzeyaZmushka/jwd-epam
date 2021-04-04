package com.epam.jwd.zmushko.action;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.Figures;
import com.epam.jwd.zmushko.model.Point;
import com.epam.jwd.zmushko.model.Line;
import com.epam.jwd.zmushko.model.Triangle;
import com.epam.jwd.zmushko.model.Square;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayFactory {
    private static final Logger LOGGER = LogManager.getLogger();

    public static Figure[] createArray(Figures type, int size) {
        ArrayFactory creator = new ArrayFactory();
        Figure[] array = null;
        switch (type) {
            case POINT:
                array = creator.createArrayOfPoints(size);
                break;
            case LINE:
                array = creator.createArrayOfLines(size);
                break;
            case TRIANGLE:
                array = creator.createArrayOfTriangles(size);
                break;
            case SQUARE:
                array = creator.createArrayOfSquare(size);
                break;
            default:
                LOGGER.error("Wrong figure");
        }
        return array;
    }

    private Figure[] createArrayOfPoints(int size) {
        Figure[] array = new Point[size];
        for (int i = 0; i < size; i++) {
            array[i] = Point.createPoint();
        }
        return array;
    }

    private Figure[] createArrayOfLines(int size) {
        Figure[] array = new Line[size];
        for (int i = 0; i < size; i++) {
            try {
                array[i] = Line.createLine(Point.createPoint(),
                        Point.createPoint());
            } catch (FigureCannotExistException e) {
                LOGGER.error("object " + Line.class.toString() + " isn't figure " + Line.getNAME());
            }
        }
        return array;
    }

    private Figure[] createArrayOfTriangles(int size) {
        Figure[] array = new Triangle[size];
        for (int i = 0; i < size; i++) {
            try {
                array[i] = Triangle.createTriangle(Point.createPoint(),
                        Point.createPoint(),
                        Point.createPoint());
            } catch (FigureCannotExistException e) {
                LOGGER.error("Object " + Triangle.class.toString() + " isn't figure " + Triangle.getNAME());
            }
        }
        return array;
    }

    private Figure[] createArrayOfSquare(int size) {
        Figure[] array = new Square[size];
        for (int i = 0; i < size; i++) {
            try {
                array[i] = Square.createSquare(Point.createPoint(),
                        Point.createPoint(),
                        Point.createPoint(),
                        Point.createPoint());
            } catch (FigureCannotExistException e) {
                LOGGER.error("object " + Square.class.toString() + " isn't figure " + Square.getNAME());
            }
        }
        return array;
    }
}
