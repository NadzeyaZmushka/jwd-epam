package com.epam.jwd.action;

import com.epam.jwd.exception.FigureCannotExistException;
import com.epam.jwd.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayCreator {
    private static final Logger LOGGER = LogManager.getLogger();

    public static Object[] createArray(Figures type) {
        ArrayCreator creator = new ArrayCreator();
        Object[] array = null;
        switch (type) {
            case POINT:
                array = creator.createArrayOfPoints();
                break;
            case LINE:
                array = creator.createArrayOfLines();
                break;
            case TRIANGLE:
                array = creator.createArrayOfTriangles();
                break;
            case SQUARE:
                array = creator.createArrayOfSquare();
                break;
            default:
                LOGGER.error("Wrong figure");
        }
        return array;
    }

    private Object[] createArrayOfPoints() {
        Object[] array = new Object[4];
        for (int i = 0; i < array.length; i++) {
            array[i] = Point.createPoint();
        }
        return array;
    }

    private Object[] createArrayOfLines() {
        Line[] array = new Line[2];
        for (int i = 0; i < array.length; i++) {
            try {
                array[i] = Line.createLine(Point.createPoint(),
                        Point.createPoint());
            } catch (FigureCannotExistException e) {
                LOGGER.error("object " + Line.class.toString() + " isn't figure " + Line.getNAME());
            }
        }
        return array;
    }

    private Object[] createArrayOfTriangles() {
        Triangle[] array = new Triangle[2];
        for (int i = 0; i < array.length; i++) {
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

    private Object[] createArrayOfSquare() {
        Square[] array = new Square[1];
        for (int i = 0; i < array.length; i++) {
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
