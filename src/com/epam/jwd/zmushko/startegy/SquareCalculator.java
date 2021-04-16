package com.epam.jwd.zmushko.startegy;

import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.Square;

public class SquareCalculator implements FigureCalculator {
    private static SquareCalculator instance;

    private SquareCalculator() {
    }

    public static SquareCalculator getInstance() {
        if (instance == null) {
            instance = new SquareCalculator();
        }
        return instance;
    }

    @Override
    public double calculatePerimeter(Figure figure) {
        Square square = (Square) figure;
        return (side(square.getA(), square.getB()) +
                side(square.getB(), square.getC())) * 2;
    }

    @Override
    public double calculateArea(Figure figure) {
        Square square = (Square) figure;
        double sideA = side(square.getA(), square.getB());
        double sideB = side(square.getB(), square.getC());
        return sideA * sideB;
    }
}
