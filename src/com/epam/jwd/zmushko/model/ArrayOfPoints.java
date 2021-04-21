package com.epam.jwd.zmushko.model;

import com.epam.jwd.zmushko.action.DataReader;

import java.util.Random;

public class ArrayOfPoints {

    private ArrayOfPoints() {
    }

    public static Point[] createArrayOfPoints(int length) {
        Point[] points = new Point[length];
        Random random = new Random();
        double[] coordinates = DataReader.readCoordinatesToDoubleArray();
        for (int i = 0; i < points.length; i++) {
            points[i] = Point.createPoint(coordinates[random.nextInt(coordinates.length)],
                    coordinates[random.nextInt(coordinates.length)]);
        }
        return points;
    }
}
