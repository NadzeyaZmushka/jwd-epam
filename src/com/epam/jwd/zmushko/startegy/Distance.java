package com.epam.jwd.zmushko.startegy;

import com.epam.jwd.zmushko.model.Point;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Distance {
    public static double side(Point p1, Point p2) {
        return sqrt(pow((p2.getX() - p1.getX()), 2) + pow((p2.getY() - p1.getY()), 2));
    }
}
