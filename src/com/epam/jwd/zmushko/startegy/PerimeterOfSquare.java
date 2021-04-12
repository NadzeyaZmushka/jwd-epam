package com.epam.jwd.zmushko.startegy;

import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import com.epam.jwd.zmushko.model.SimpleFigureFactory;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.model.Square;

public class PerimeterOfSquare implements Perimeter {
    private static PerimeterOfSquare instance;
    FigureFactory factory = new SimpleFigureFactory();

    private PerimeterOfSquare() {
    }

    public static PerimeterOfSquare getInstance() {
        if (instance == null) {
            instance = new PerimeterOfSquare();
        }
        return instance;
    }

    @Override
    public double calculatePerimeter() {
        double result = 0;
        try {
            Square square = (Square) factory.createFigure(FigureType.SQUARE, 4);
            result = (Distance.side(square.getA(), square.getB()) +
                    Distance.side(square.getB(), square.getC())) * 2;
        } catch (FigureException e) {
            e.printStackTrace();
        }
        return result;
    }
}
