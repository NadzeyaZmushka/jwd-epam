package com.epam.jwd.action;

import com.epam.jwd.exception.FigureCannotExistException;
import com.epam.jwd.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayCreator {
    private static final Logger LOGGER = LogManager.getLogger();

    public static Object[] createArray(Figures type, int size) {
        ArrayCreator creator = new ArrayCreator();
        Object[] array = null;
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

    private Object[] createArrayOfPoints(int size) {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = Point.createPoint();
        }
        return array;
    }

    private Object[] createArrayOfLines(int size) {
        Line[] array = new Line[size];
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

    private Object[] createArrayOfTriangles(int size) {
        Triangle[] array = new Triangle[size];
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

    private Object[] createArrayOfSquare(int size) {
        Square[] array = new Square[size];
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
