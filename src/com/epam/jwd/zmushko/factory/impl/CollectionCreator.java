package com.epam.jwd.zmushko.factory.impl;

import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.model.Line;
import com.epam.jwd.zmushko.model.MultiAngleFigure;
import com.epam.jwd.zmushko.model.Point;
import com.epam.jwd.zmushko.model.Square;
import com.epam.jwd.zmushko.model.Triangle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionCreator {

    private static final FigureFactory factory = FigureFactory.newInstance();

    public static Collection<Line> listOfLines(Point[] points, int size) throws FigureException {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lines.add((Line) factory.createFigure(FigureType.LINE, points));
        }
        return lines;
    }

    public static Collection<Triangle> listOfTriangles(Point[] points, int size) throws FigureException {
        List<Triangle> triangles = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            triangles.add((Triangle) factory.createFigure(FigureType.TRIANGLE, points));
        }
        return triangles;
    }

    public static Collection<Square> listOfSquare(Point[] points, int size) throws FigureException {
        List<Square> squares = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            squares.add((Square) factory.createFigure(FigureType.SQUARE, points));
        }
        return squares;
    }

    public static Collection<MultiAngleFigure> listOfMultiangle(Point[] points, int size) throws FigureException {
        List<MultiAngleFigure> multiAngleFigures = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            multiAngleFigures.add((MultiAngleFigure) factory.createFigure(FigureType.MULTI_ANGLE_FIGURE, points));
        }
        return multiAngleFigures;
    }

}
