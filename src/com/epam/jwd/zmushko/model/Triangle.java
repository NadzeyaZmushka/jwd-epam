package com.epam.jwd.zmushko.model;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;

import java.util.Objects;

import static com.epam.jwd.zmushko.validation.FigureValidator.isTriangle;

public class Triangle extends Figure {
    private static final String NAME = "Triangle";
    private final Point point1;
    private final Point point2;
    private final Point point3;

    private Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public static String getNAME() {
        return NAME;
    }

    /*An exception FigureCannotExistException "not enough points" may be thrown
     *An exception FigureCannotExistException "figure is not triangle" may be thrown*/
    public static Triangle createTriangle(Point a, Point b, Point c) throws FigureCannotExistException {
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
        return Objects.equals(point1, triangle.point1) &&
                Objects.equals(point2, triangle.point2) &&
                Objects.equals(point3, triangle.point3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point1, point2, point3);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                ", point3=" + point3 +
                '}';
    }
}
