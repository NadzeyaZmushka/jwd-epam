package com.epam.jwd.zmushko.factory.impl;

import com.epam.jwd.zmushko.model.Point;
import com.epam.jwd.zmushko.util.DataReader;

import java.util.List;

public class ArrayOfPointsFactory {

    private ArrayOfPointsFactory() {
    }

    public static Point[] createArrayOfPoints(int length) {
        List<Double> coordinates = DataReader.mapCorrdinatesToDouble();
        Point[] points = new Point[length];

        for (int i = 0; i < points.length; i++) {
            points[i] = Point.createPoint(coordinates.get(i),
                    coordinates.get(i+1));
        }
        return points;
    }

}
