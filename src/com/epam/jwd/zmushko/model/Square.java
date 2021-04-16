package com.epam.jwd.zmushko.model;

import com.epam.jwd.zmushko.startegy.SquareCalculator;

import java.util.Objects;

public class Square extends Figure {
    private static final String NAME = "Square";
    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    private Square(Point[] points) {
        name = NAME;
        type = FigureType.SQUARE;
        figureCalculator = SquareCalculator.getInstance();
        this.a = points[0];
        this.b = points[1];
        this.c = points[2];
        this.d = points[3];
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public Point getD() {
        return d;
    }

    static Square createSquare(Point[] points) {
        return new Square(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Objects.equals(a, square.a) &&
                Objects.equals(b, square.b) &&
                Objects.equals(c, square.c) &&
                Objects.equals(d, square.d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d);
    }

    @Override
    public String toString() {
        return "Square{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}
