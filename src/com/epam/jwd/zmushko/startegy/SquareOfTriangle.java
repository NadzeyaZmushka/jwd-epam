package com.epam.jwd.zmushko.startegy;

import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import com.epam.jwd.zmushko.model.SimpleFigureFactory;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.model.Triangle;

public class SquareOfTriangle implements SquareOfFigure {
    private static final SquareOfTriangle instance = new SquareOfTriangle();
    FigureFactory factory = new SimpleFigureFactory();

    public SquareOfTriangle() {
    }

    public static SquareOfTriangle getInstance() {
        return instance;
    }

    @Override
    public double calculateSquare(FigureType type, int sides) {
        double result = 0;
        try {
            Triangle triangle = (Triangle) factory.createFigure(FigureType.TRIANGLE, 3);
            double sideA = Distance.side(triangle.getA(), triangle.getB());
            double sideB = Distance.side(triangle.getB(), triangle.getC());
            double sideC = Distance.side(triangle.getC(), triangle.getA());
            double p = (sideA + sideB + sideC) / 2;
            result = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        } catch (FigureException e) {
            e.printStackTrace();
        }
        return result;
    }
}
