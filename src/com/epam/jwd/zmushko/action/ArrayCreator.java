package com.epam.jwd.zmushko.action;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.model.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayCreator {
    public static final Logger LOGGER = LogManager.getLogger(ArrayCreator.class);

    private ArrayCreator() {
    }

    public static Point[] createArray(int length) {
        Point[] points = new Point[length];
        Random random = new Random();
        double[] coordinates = DataReader.readCoordinatesToDoubleArray();
        for (int i = 0; i < points.length; i++) {
            points[i] = Point.createPoint(coordinates[random.nextInt(coordinates.length)],
                    coordinates[random.nextInt(coordinates.length)]);
        }
        return points;
    }

    public static List<Figure> createListOfFigure(FigureFactory factory, FigureType type, Point[] points, int size) {
        List<Figure> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            try {
                list.add(factory.createFigure(type, points));
            } catch (FigureCannotExistException e) {
                LOGGER.error("object " + Figure.getName() + " isn't figure " + Figure.getName());
            } catch (FigureException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
