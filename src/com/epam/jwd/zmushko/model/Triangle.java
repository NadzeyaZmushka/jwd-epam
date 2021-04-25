package com.epam.jwd.zmushko.model;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.startegy.TriangleCalculatorStrategy;

import java.util.Objects;

public class Triangle extends Figure {

    private final Point a;
    private final Point b;
    private final Point c;

    private Triangle(Point[] points) {
        name = "Triangle";
        figureCalculator = TriangleCalculatorStrategy.getInstance();
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

    public static Triangle create(Point[] points) throws FigureCannotExistException {
        if (points.length < 3) {
            throw new FigureCannotExistException("Not enough points");
        }
        return new Triangle(points);
    }

    @Override
    public boolean isValid() throws FigureCannotExistException {
        Triangle t = this;
        if (t.getA().equals(t.getB()) || t.getA().equals(t.getC())
                || t.getB().equals(t.getC())) {
            throw new FigureCannotExistException("not enough points");
        } else if ((t.getA().getX() == t.getB().getX() && t.getA().getX() == t.getC().getX()) ||
                t.getA().getY() == t.getB().getY() && t.getA().getY() == t.getC().getY()) {
            throw new FigureCannotExistException("figure is not triangle");
        } else {
            return true;
        }
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
