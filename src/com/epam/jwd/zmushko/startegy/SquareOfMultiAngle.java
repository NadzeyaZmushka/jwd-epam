package com.epam.jwd.zmushko.startegy;

import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.model.MultiAngleFigure;
import com.epam.jwd.zmushko.model.SimpleFigureFactory;

public enum SquareOfMultiAngle implements SquareOfFigure {
    INSTANCE;
    FigureFactory factory = new SimpleFigureFactory();

    //(ns * (side * side)) / (4.0 * Math.tan((Math.PI / ns)))
    @Override
    public double calculateSquare(FigureType type, int sides) {
        double result = 0;
        if (type == FigureType.MULTI_ANGLE_FIGURE && sides == 5) {
            try {
                MultiAngleFigure multiAngleFigure = (MultiAngleFigure) factory.createFigure(FigureType.MULTI_ANGLE_FIGURE, 5);
                result = (sides * (Distance.side(multiAngleFigure.getP1(), multiAngleFigure.getP2())
                        * Distance.side(multiAngleFigure.getP2(), multiAngleFigure.getP3())))
                        / (4.0 * Math.tan(Math.PI / sides));
            } catch (FigureException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
