package com.epam.jwd.zmushko;

import com.epam.jwd.zmushko.action.ArrayFactory;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.Figures;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final Figure[] points = ArrayFactory.createArray(Figures.POINT, 4);
    private static final Figure[] lines = ArrayFactory.createArray(Figures.LINE, 2);
    private static final Figure[] triangles = ArrayFactory.createArray(Figures.TRIANGLE, 2);
    private static final Figure[] squares = ArrayFactory.createArray(Figures.SQUARE, 1);

    public static void main(String[] args) {
        LOGGER.trace("The program has started ");
        printInfoAboutPoints(points);
        printInfoAboutFigure(lines);
        printInfoAboutFigure(triangles);
        printInfoAboutFigure(squares);
        LOGGER.trace("The program is over");
    }

    public static void printInfoAboutFigure(Figure[] figures) {
        for (Figure figure : figures) {
            if (figure != null) {
                LOGGER.info(figure.toString());
            }
        }
    }

    public static void printInfoAboutPoints(Figure[] points) {
        int i = 0;
        do {
            LOGGER.info(points[i].toString());
            i++;
        } while (i < points.length);
    }
}
