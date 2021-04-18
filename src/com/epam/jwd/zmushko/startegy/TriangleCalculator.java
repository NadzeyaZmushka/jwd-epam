package com.epam.jwd.zmushko.startegy;

import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.Triangle;

public class TriangleCalculator implements FigureCalculator {

    private static TriangleCalculator instance;

    private TriangleCalculator() {

    }

    public static TriangleCalculator getInstance() {
        if (instance == null) {
            instance = new TriangleCalculator();
        }
        return instance;
    }

    @Override
    public double calculatePerimeter(Figure figure) {
        Triangle triangle = (Triangle) figure;
        return side(triangle.getA(), triangle.getB()) +
                side(triangle.getB(), triangle.getC()) +
                side(triangle.getC(), triangle.getA());
    }

    @Override
    public double calculateArea(Figure figure) {
        Triangle triangle = (Triangle) figure;
        double sideA = side(triangle.getA(), triangle.getB());
        double sideB = side(triangle.getB(), triangle.getC());
        double sideC = side(triangle.getC(), triangle.getA());
        double p = (sideA + sideB + sideC) / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }
}
