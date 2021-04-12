package com.epam.jwd.zmushko.startegy;

import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import com.epam.jwd.zmushko.model.SimpleFigureFactory;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.model.Square;

public class SquareOfRectangle implements SquareOfFigure {
    private static final SquareOfRectangle instance = new SquareOfRectangle();
    FigureFactory factory = new SimpleFigureFactory();
    public SquareOfRectangle() {
    }

    public static SquareOfRectangle getInstance() {
        return instance;
    }

    @Override
    public double calculateSquare(FigureType type, int sides) {
        double result = 0;
        try {
            Square square = (Square) factory.createFigure(FigureType.SQUARE, 4);
            double sideA = Distance.side(square.getA(), square.getB());
            double sideB = Distance.side(square.getB(), square.getC());
            result = sideA * sideB;
        } catch (FigureException e) {
            e.printStackTrace();
        }
        return result;
    }
}
