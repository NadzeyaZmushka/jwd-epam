package com.epam.jwd.action;

import com.epam.jwd.model.Point;

import static java.lang.Math.*;

public class Distance {
    public static double calculateDistance(Point p1, Point p2) {
        return sqrt(pow((p2.getX() - p1.getX()),2) + pow((p2.getY() - p1.getY()),2));
    }
}
