package com.epam.jwd.zmushko.model;

import com.epam.jwd.zmushko.startegy.LineCalculator;

import java.util.Objects;

public class Line extends Figure {
    private static final String NAME = "Line";
    private final Point a;
    private final Point b;

    public Line(Point[] points) {
        name = NAME;
        type = FigureType.LINE;
        figureCalculator = LineCalculator.INSTANCE;
        this.a = points[0];
        this.b = points[1];
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    static Line createLine(Point[] points) {
        return new Line(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(a, line.a) &&
                Objects.equals(b, line.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "Line{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
