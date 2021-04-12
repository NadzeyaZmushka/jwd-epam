package com.epam.jwd.zmushko.action;

import com.epam.jwd.zmushko.model.Figure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PrintInfo {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void printInfoAboutFigure(List<? extends Figure> figures) {
        for (Figure figure : figures) {
            if (figure != null) {
                LOGGER.info(figure);
            }
        }
    }

    public static void printInfoAboutPoints(List<? extends Figure> figures) {
        int i = 0;
        do {
            LOGGER.info(figures);
            i++;
        } while (i < figures.size());
    }
}
