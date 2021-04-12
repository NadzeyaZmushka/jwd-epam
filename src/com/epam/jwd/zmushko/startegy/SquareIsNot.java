package com.epam.jwd.zmushko.startegy;

import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.FigureType;

public enum SquareIsNot implements SquareOfFigure {
    INSTANCE;


    @Override
    public double calculateSquare(FigureType figure, int sides) {
        return 0;
    }
}
