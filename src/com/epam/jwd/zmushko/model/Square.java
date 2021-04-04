package com.epam.jwd.zmushko.model;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;

import java.util.Objects;

import static com.epam.jwd.zmushko.validation.FigureValidator.isSquare;

public class Square extends Figure {
    private static final String NAME = "Square";

    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    private Square(Point point1, Point point2, Point point3, Point point4) {
        this.a = point1;
        this.b = point2;
        this.c = point3;
        this.d = point4;
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

    public static String getNAME() {
        return NAME;
    }

    /*An exception FigureCannotExistException "not enough points" may be thrown
     *An exception FigureCannotExistException "figure is rectangle but not square" may be thrown*/
    public static Square createSquare(Point a, Point b, Point c, Point d) throws FigureCannotExistException {
        Square square = new Square(a, b, c, d);
        if (!isSquare(square)) {
            throw new FigureCannotExistException();
        } else {
            return square;
        }
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
                "point1=" + a +
                ", point2=" + b +
                ", point3=" + c +
                ", point4=" + d +
                '}';
    }
}
