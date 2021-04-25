package com.epam.jwd.zmushko.app;

import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.factory.impl.CollectionCreator;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.Line;
import com.epam.jwd.zmushko.model.MultiAngleFigure;
import com.epam.jwd.zmushko.model.Point;
import com.epam.jwd.zmushko.model.Square;
import com.epam.jwd.zmushko.model.Triangle;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionsInit {

    private Collection<Line> lines = new ArrayList<>();
    private Collection<Triangle> triangles = new ArrayList<>();
    private Collection<Square> squares = new ArrayList<>();
    private Collection<MultiAngleFigure> multiAngleFigures = new ArrayList<>();

    public Collection<? extends Figure> retrieveFigureList(Class<? extends Figure> tClass) {
        Collection<? extends Figure> collection = null;
        if (tClass.equals(Line.class)) {
            collection = lines;
        }
        if (tClass.equals(Triangle.class)) {
            collection = triangles;
        }
        if (tClass.equals(Square.class)) {
            collection = squares;
        }
        if (tClass.equals(MultiAngleFigure.class)) {
            collection = multiAngleFigures;
        }
        return collection;
    }

    public void initCollections(Point[] points, int size) throws FigureException {
        lines = CollectionCreator.listOfLines(points, size);
        triangles = CollectionCreator.listOfTriangles(points, size);
        squares = CollectionCreator.listOfSquare(points, size);
        multiAngleFigures = CollectionCreator.listOfMultiangle(points, size);

    }

}
