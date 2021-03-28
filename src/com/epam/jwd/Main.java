package com.epam.jwd;

import com.epam.jwd.action.CreateArray;
import com.epam.jwd.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final Object[] points = CreateArray.createArray(Figures.POINT);
    private static final Object[] lines = CreateArray.createArray(Figures.LINE);
    private static final Object[] triangles = CreateArray.createArray(Figures.TRIANGLE);
    private static final Object[] squares = CreateArray.createArray(Figures.SQUARE);

    public static void main(String[] args) {
        LOGGER.trace("The program has started ");
        printInfoAboutPoints(points);
        printInfoAboutFigure(lines);
        printInfoAboutFigure(triangles);
        printInfoAboutFigure(squares);
        LOGGER.trace("The program is over");
    }

    public static void printInfoAboutFigure(Object[] objects) {
        for (Object object : objects) {
            if (object != null){
                LOGGER.info(object.toString());
            }
        }
    }
    public static void printInfoAboutPoints(Object[] points){
        int i = 0;
        do {
            LOGGER.info(points[i].toString());
            i++;
        } while (i < points.length);
    }
}
