package com.epam.jwd.zmushko.startegy;

import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import com.epam.jwd.zmushko.model.SimpleFigureFactory;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.model.Triangle;

public class PerimeterOfTriangle implements Perimeter {
    private static PerimeterOfTriangle instance;
    FigureFactory factory = new SimpleFigureFactory();

    private PerimeterOfTriangle() {
    }

    public static PerimeterOfTriangle getInstance() {
        if (instance == null) {
            instance = new PerimeterOfTriangle();
        }
        return instance;
    }

    @Override
    public double calculatePerimeter() {
        double result = 0;
        try {
            Triangle triangle = (Triangle) factory.createFigure(FigureType.TRIANGLE, 3);
            result = Distance.side(triangle.getA(), triangle.getB()) +
                    Distance.side(triangle.getB(), triangle.getC()) +
                    Distance.side(triangle.getC(), triangle.getA());
        } catch (FigureException e) {
            e.printStackTrace();
        }
        return result;
    }
}
