package com.epam.jwd.zmushko.action;

import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PrintInfo {
    private static final Logger LOGGER = LogManager.getLogger();

    private PrintInfo() {
    }

    public static void printInfoAboutFigure(List<? extends Figure> figures) {
        for (Figure figure : figures) {
            if (figure != null) {
                LOGGER.info(figure);
            }
        }
    }

    public static void printInfoAboutPoints(Point[] points) {
        for (Point point : points) {
            LOGGER.info(point);
        }
    }
}

