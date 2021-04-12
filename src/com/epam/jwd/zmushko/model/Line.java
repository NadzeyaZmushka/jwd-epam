package com.epam.jwd.zmushko.model;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;

import java.util.Objects;

import static com.epam.jwd.zmushko.service.FigureValidator.isLine;

public class Line extends Figure {
    private static final String NAME = "Line";
    private final Point a;
    private final Point b;

    private Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }


    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public static String getNAME() {
        return NAME;
    }

    /*An exception FigureCannotExistException "not enough points" may be thrown*/
    static Line createLine(Point a, Point b) throws FigureCannotExistException {
        Line line = new Line(a, b);
        if (!isLine(line)) {
            throw new FigureCannotExistException();
        } else {
            return line;
        }
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
