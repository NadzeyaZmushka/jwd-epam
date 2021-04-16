package com.epam.jwd.zmushko.startegy;

import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.Point;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public interface FigureCalculator {

    double calculatePerimeter(Figure figure);

    double calculateArea(Figure figure);

    default double side(Point p1, Point p2) {
        return sqrt(pow((p2.getX() - p1.getX()), 2) + pow((p2.getY() - p1.getY()), 2));
    }
}
