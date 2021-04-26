package com.epam.jwd.zmushko.app;

import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.factory.impl.ArrayOfPointsFactory;
import com.epam.jwd.zmushko.factory.impl.CollectionCreator;
import com.epam.jwd.zmushko.model.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        Point[] points = ArrayOfPointsFactory.createArrayOfPoints(8);

        LOGGER.trace("The program started ");

        try {
            PrintInfoAboutFigures.printInfo(CollectionCreator.listOfLines(points, 2));
            PrintInfoAboutFigures.printInfo(CollectionCreator.listOfTriangles(points, 2));
            PrintInfoAboutFigures.printInfo(CollectionCreator.listOfSquare(points, 1));
            PrintInfoAboutFigures.printInfo(CollectionCreator.listOfMultiangle(points, 1));
        } catch (FigureException e) {
            LOGGER.error(e.getMessage());
        }

        LOGGER.trace("The program is over");
    }

}
