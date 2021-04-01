package com.epam.jwd.model;

import com.epam.jwd.exception.FigureCannotExistException;

import java.util.Objects;

public class Line {
    private static final String NAME = "Line";
    private final Point point1;
    private final Point point2;

    private Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public static String getNAME() {
        return NAME;
    }

    public static Line createLine(Point a, Point b) throws FigureCannotExistException {
        Line line;
        if (a.equals(b)) {
            throw new FigureCannotExistException("not enough points");
        } else {
            line = new Line(a, b);
        }
        return line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(point1, line.point1) &&
                Objects.equals(point2, line.point2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point1, point2);
    }

    @Override
    public String toString() {
        return "Line{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                '}';
    }
}
