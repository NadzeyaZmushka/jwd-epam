package com.epam.jwd.zmushko.model;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.startegy.LineCalculator;

import java.util.Objects;

public class Line extends Figure {
    private final Point a;
    private final Point b;

    private Line(Point[] points) {
        name = "Line";
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

    static Line create(Point[] points) throws FigureCannotExistException {
        if (points.length < 2) {
            throw new FigureCannotExistException("Not enough points");
        }
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
