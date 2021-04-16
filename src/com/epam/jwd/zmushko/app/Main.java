package com.epam.jwd.zmushko.app;

import com.epam.jwd.zmushko.action.PrintInfo;
import com.epam.jwd.zmushko.action.ArrayCreator;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.model.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        Point[] points = ArrayCreator.createArray(6);

        List<Figure> lines = ArrayCreator.createListOfFigure(FigureType.LINE, points, 3);
        List<Figure> triangles = ArrayCreator.createListOfFigure(FigureType.TRIANGLE, points, 2);
        List<Figure> squares = ArrayCreator.createListOfFigure(FigureType.SQUARE, points, 1);
        List<Figure> multiAngles = ArrayCreator.createListOfFigure(FigureType.MULTI_ANGLE_FIGURE, points, 1);


        LOGGER.trace("The program started ");

        PrintInfo.printInfoAboutPoints(points);
        PrintInfo.printInfoAboutFigure(lines);
        PrintInfo.printInfoAboutFigure(triangles);
        PrintInfo.printInfoAboutFigure(squares);
        PrintInfo.printInfoAboutFigure(multiAngles);

        LOGGER.trace("The program is over");
    }
}
