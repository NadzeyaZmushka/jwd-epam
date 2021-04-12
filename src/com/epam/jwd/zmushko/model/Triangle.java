package com.epam.jwd.zmushko.model;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;

import java.util.Objects;

import static com.epam.jwd.zmushko.service.FigureValidator.isTriangle;

public class Triangle extends Figure {
    private static final String NAME = "Triangle";
    private final Point a;
    private final Point b;
    private final Point c;

    private Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    public static String getNAME() {
        return NAME;
    }

    /*An exception FigureCannotExistException "not enough points" may be thrown
     *An exception FigureCannotExistException "figure is not triangle" may be thrown*/
    static Triangle createTriangle(Point a, Point b, Point c) throws FigureCannotExistException {
        Triangle triangle = new Triangle(a, b, c);
        if (!isTriangle(triangle)) {
            throw new FigureCannotExistException();
        } else {
            return triangle;
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
