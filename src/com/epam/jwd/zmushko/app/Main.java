package com.epam.jwd.zmushko.app;

import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import com.epam.jwd.zmushko.model.ArrayOfPoints;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.model.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger();

    private static final FigureFactory factory = FigureFactory.newInstance();

    public static void main(String[] args) {
        Point[] points = ArrayOfPoints.createArrayOfPoints(6);

//        List<Figure> lines = new ArrayList<>();
//        for (int i = 0; i < 2; i++){
//            try {
//                lines.add(factory.createFigure(FigureType.LINE, points));
//            } catch (FigureException e) {
//                e.printStackTrace();
//            }
//        }
//        List<Figure> triangles = new ArrayList<>();
//        for (int i = 0; i < 2; i++){
//            try {
//                triangles.add(factory.createFigure(FigureType.TRIANGLE, points));
//            } catch (FigureException e) {
//                e.printStackTrace();
//            }
//        }
//        List<Figure> squares = new ArrayList<>();
//        for (int i = 0; i < 2; i++){
//            try {
//                squares.add(factory.createFigure(FigureType.SQUARE, points));
//            } catch (FigureException e) {
//                e.getMessage();
//            }
//        }
//        List<Figure> multiAngles = new ArrayList<>();
//        for (int i = 0; i < 2; i++){
//            try {
//                multiAngles.add(factory.createFigure(FigureType.MULTI_ANGLE_FIGURE, points));
//            } catch (FigureException e) {
//                e.printStackTrace();
//            }
//        }

        LOGGER.trace("The program started ");

        try {
            Figure line = factory.createFigure(FigureType.LINE, points);
            Figure triangle = factory.createFigure(FigureType.TRIANGLE, points);
            double perimeterOfTriangle = triangle.getFigureCalculator().calculatePerimeter(triangle);
            LOGGER.info("Perimeter of triangle: " + perimeterOfTriangle);
        } catch (FigureException e) {
            LOGGER.error(e.getMessage());
        }


//        PrintInfo.printInfoAboutPoints(points);
//        PrintInfo.printInfoAboutFigure(lines);
//        PrintInfo.printInfoAboutFigure(triangles);
//        PrintInfo.printInfoAboutFigure(squares);
//        PrintInfo.printInfoAboutFigure(multiAngles);

        LOGGER.trace("The program is over");
    }
}
