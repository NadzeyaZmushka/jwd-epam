package com.epam.jwd.model;

import com.epam.jwd.exception.FigureCannotExistException;
import java.util.Objects;

import static com.epam.jwd.action.Distance.*;

public class Square {
    private static final String NAME = "Square";

    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;

    private Square(Point point1, Point point2, Point point3, Point point4) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

    public Point getPoint4() {
        return point4;
    }

    public void setPoint4(Point point4) {
        this.point4 = point4;
    }

    public static String getNAME() {
        return NAME;
    }

    public static Square createSquare(Point a, Point b, Point c, Point d) throws FigureCannotExistException {
        Square square;
        if (a.equals(b) || a.equals(c) || a.equals(d) || b.equals(c) || b.equals(d) || c.equals(d)) {
            throw new FigureCannotExistException("not enough points");
        } else if (calculateDistance(a, b) != calculateDistance(b, c) ||
                calculateDistance(c, d) != calculateDistance(d, a) ||
                calculateDistance(b, c) != calculateDistance(d, a) ||
                calculateDistance(a, c) != calculateDistance(b, d)) {
            throw new FigureCannotExistException("figure is rectangle but not square");
        } else {
            square = new Square(a, b, c, d);
        }
        return square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Objects.equals(point1, square.point1) &&
                Objects.equals(point2, square.point2) &&
                Objects.equals(point3, square.point3) &&
                Objects.equals(point4, square.point4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point1, point2, point3, point4);
    }

    @Override
    public String toString() {
        return "Square{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                ", point3=" + point3 +
                ", point4=" + point4 +
                '}';
    }
}
