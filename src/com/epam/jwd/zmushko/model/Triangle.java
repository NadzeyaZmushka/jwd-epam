package com.epam.jwd.zmushko.model;

import com.epam.jwd.zmushko.startegy.TriangleCalculator;

import java.util.Objects;

public class Triangle extends Figure {
    private static final String NAME = "Triangle";
    private final Point a;
    private final Point b;
    private final Point c;


    private Triangle(Point[] points) {
        name = NAME;
        type = FigureType.TRIANGLE;
        figureCalculator = TriangleCalculator.getInstance();
        this.a = points[0];
        this.b = points[1];
        this.c = points[2];
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

    static Triangle createTriangle(Point[] points) {
        return new Triangle(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(a, triangle.a) &&
                Objects.equals(b, triangle.b) &&
                Objects.equals(c, triangle.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
