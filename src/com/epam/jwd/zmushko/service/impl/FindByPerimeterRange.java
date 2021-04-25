package com.epam.jwd.zmushko.service.impl;

import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.service.Specification;
import com.epam.jwd.zmushko.startegy.FigureCalculatorStrategy;

public class FindByPerimeterRange implements Specification {
    private final double minPerimeter;
    private final double maxPerimeter;

    public FindByPerimeterRange(double minPerimeter, double maxPerimeter) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
    }

    @Override
    public boolean specify(Figure figure) {
        FigureCalculatorStrategy calculator = figure.getFigureCalculator();
        double perimeter = calculator.calculatePerimeter(figure);
        return minPerimeter < perimeter && perimeter < maxPerimeter;
    }

}
