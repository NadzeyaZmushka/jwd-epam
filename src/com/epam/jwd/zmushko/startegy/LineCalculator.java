package com.epam.jwd.zmushko.startegy;

import com.epam.jwd.zmushko.model.Figure;

public enum LineCalculator implements FigureCalculator {
    INSTANCE;

    @Override
    public double calculatePerimeter(Figure figure) {
        return 0;
    }

    @Override
    public double calculateArea(Figure figure) {
        return 0;
    }
}
