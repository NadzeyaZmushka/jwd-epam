package com.epam.jwd.zmushko.service.impl;

import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.service.Specification;
import com.epam.jwd.zmushko.startegy.FigureCalculator;

public class FindByAreaRange implements Specification {
    private final double minArea;
    private final double maxArea;

    public FindByAreaRange(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specify(Figure figure) {
        FigureCalculator calculator = figure.getFigureCalculator();
        double area = calculator.calculateArea(figure);
        return minArea < area && area < maxArea;
    }
}
