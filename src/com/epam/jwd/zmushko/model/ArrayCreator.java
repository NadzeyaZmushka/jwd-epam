package com.epam.jwd.zmushko.model;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ArrayCreator {
    private static final Logger LOGGER = LogManager.getLogger();
    FigureFactory figureFactory = new SimpleFigureFactory();
//
//    public static List<? extends Figure> createArray(FigureType type, int size) {
//        ArrayCreator creator = new ArrayCreator();
//        List<? extends Figure> list = new ArrayList<>();
//        switch (type) {
//            case POINT:
//                list = creator.createArrayOfPoints(size);
//                break;
//            case LINE:
//                list = creator.createArrayOfLines(size);
//                break;
//            case TRIANGLE:
//                list = creator.createArrayOfTriangles(size);
//                break;
//            case SQUARE:
//                list = creator.createArrayOfSquare(size);
//                break;
//            default:
//                LOGGER.error("Wrong figure");
//        }
//        return list;
//    }

    public List<Figure> createArrayOfPoints(int size) {
        List<Figure> points = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            try {
                points.add(figureFactory.createFigure(FigureType.POINT, 1));
            } catch (FigureCannotExistException e) {
                e.printStackTrace();
            }
        }
        return points;
    }

    public List<Figure> createArrayOfLines(int size) {
        List<Figure> lines = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            try {
                lines.add(figureFactory.createFigure(FigureType.LINE, 2));
            } catch (FigureCannotExistException e) {
                e.printStackTrace();
                LOGGER.error("object " + Line.class.toString() + " isn't figure " + Line.getNAME());
            }
        }
        return lines;
    }

    public List<Figure> createArrayOfTriangles(int size) {
        List<Figure> triangles = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            try {
                triangles.add(figureFactory.createFigure(FigureType.TRIANGLE, 3));
            } catch (FigureCannotExistException e) {
                e.printStackTrace();
                LOGGER.error("Object " + Triangle.class.toString() + " isn't figure " + Triangle.getNAME());
            }
        }
        return triangles;
    }

    public List<Figure> createArrayOfSquare(int size) {
        List<Figure> squares = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            try {
                squares.add(figureFactory.createFigure(FigureType.SQUARE, 4));
            } catch (FigureCannotExistException e) {
                e.printStackTrace();
                LOGGER.error("object " + Square.class.toString() + " isn't figure " + Square.getNAME());
            }
        }
        return squares;
    }
}
