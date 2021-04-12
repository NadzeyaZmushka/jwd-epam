package com.epam.jwd.zmushko.app;

import com.epam.jwd.zmushko.action.PrintInfo;
import com.epam.jwd.zmushko.model.ArrayCreator;
import com.epam.jwd.zmushko.model.Figure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        ArrayCreator creator = new ArrayCreator();

        List<Figure> points = creator.createArrayOfPoints(4);
        List<Figure> lines = creator.createArrayOfLines(2);
        List<Figure> triangles = creator.createArrayOfTriangles(2);
        List<Figure> squares = creator.createArrayOfSquare(1);

//        Figure multiAngle = null;
//        try {
//            multiAngle = FigureFactory.createFigure(FigureType.MULTI_ANGLE_FIGURE, 6);
//            LOGGER.info(multiAngle.toString());
//        } catch (FigureCannotExistException e) {
//            e.printStackTrace();
//        }

        LOGGER.trace("The program has started ");

        PrintInfo.printInfoAboutPoints(points);
        PrintInfo.printInfoAboutFigure(lines);
        PrintInfo.printInfoAboutFigure(triangles);
        PrintInfo.printInfoAboutFigure(squares);

        LOGGER.trace("The program is over");
    }
}
