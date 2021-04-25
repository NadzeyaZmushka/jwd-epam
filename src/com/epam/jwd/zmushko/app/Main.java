package com.epam.jwd.zmushko.app;

import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.factory.impl.ArrayOfPoints;
import com.epam.jwd.zmushko.model.Line;
import com.epam.jwd.zmushko.model.MultiAngleFigure;
import com.epam.jwd.zmushko.model.Point;
import com.epam.jwd.zmushko.model.Square;
import com.epam.jwd.zmushko.model.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static final Logger LOGGER = LogManager.getLogger();

    public static CollectionsInit init = new CollectionsInit();

    public static void main(String[] args) {
        Point[] points = ArrayOfPoints.createArrayOfPoints(8);

        try {
            init.initCollections(points, 2);
        } catch (FigureException e) {
            e.printStackTrace();
        }

        LOGGER.trace("The program started ");

        PrintInfoAboutFigures.printInfo(init.retrieveFigureList(Line.class));
        PrintInfoAboutFigures.printInfo(init.retrieveFigureList(Triangle.class));
        PrintInfoAboutFigures.printInfo(init.retrieveFigureList(Square.class));
        PrintInfoAboutFigures.printInfo(init.retrieveFigureList(MultiAngleFigure.class));

        LOGGER.trace("The program is over");
    }

}
