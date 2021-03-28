package com.epam.jwd.action;

import com.epam.jwd.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreateArray {
    private static final Logger LOGGER = LogManager.getLogger();

    public static Object[] createArray(Figures type) {
        Object[] array = null;
        switch (type) {
            case POINT:
                array = createArrayOfPoints();
                break;
            case LINE:
                array = createArrayOfLines();
                break;
            case TRIANGLE:
                array = createArrayOfTriangles();
                break;
            case SQUARE:
                array = createArrayOfSquare();
                break;
            default:
                LOGGER.error("Wrong figure");
        }
        return array;
    }

    private static Object[] createArrayOfPoints() {
        Object[] array = new Object[4];
        for (int i = 0; i < array.length; i++) {
            array[i] = Point.createPoint();
        }
        return array;
    }
    private static Object[] createArrayOfLines() {
        Line[] array = new Line[2];
        for (int i = 0; i < array.length; i++) {
            array[i] = Line.createLine(Point.createPoint(),
                    Point.createPoint());
        }
        return array;
    }

    private static Object[] createArrayOfTriangles() {
        Triangle[] array = new Triangle[2];
        for (int i = 0; i < array.length; i++) {
            array[i] = Triangle.createTriangle(Point.createPoint(),
                    Point.createPoint(),
                    Point.createPoint());
        }
        return array;
    }

    private static Object[] createArrayOfSquare() {
        Square[] array = new Square[1];
        for (int i = 0; i < array.length; i++) {
            array[i] = Square.createSquare(Point.createPoint(),
                    Point.createPoint(),
                    Point.createPoint(),
                    Point.createPoint());
        }
        return array;
    }
}
