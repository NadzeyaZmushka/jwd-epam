package com.epam.jwd.zmushko.model;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.startegy.FigureCalculatorStrategy;
import com.epam.jwd.zmushko.startegy.SquareCalculatorStrategy;

import java.util.Objects;

public class Square extends Figure {

    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    private Square(Point[] points) {
        name = "Square";
        figureCalculator = SquareCalculatorStrategy.getInstance();
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

    public static Square create(Point[] points) throws FigureCannotExistException {
        if (points.length < 4) {
            throw new FigureCannotExistException("Not enough points to create square");
        }
        return new Square(points);
    }

    @Override
    public boolean isValid() throws FigureCannotExistException {
        Square s = this;
        FigureCalculatorStrategy calculator = s.getFigureCalculator();
        if (s.getA().equals(s.getB()) || s.getA().equals(s.getC()) ||
                s.getA().equals(s.getD()) || s.getB().equals(s.getC()) ||
                s.getB().equals(s.getD()) || s.getC().equals(s.getD())) {
            throw new FigureCannotExistException("not enough points");
        } else if (calculator.side(s.getA(), s.getB()) != calculator.side(s.getB(), s.getC()) ||
                calculator.side(s.getC(), s.getD()) != calculator.side(s.getD(), s.getA()) ||
                calculator.side(s.getB(), s.getC()) != calculator.side(s.getD(), s.getA()) ||
                calculator.side(s.getA(), s.getC()) != calculator.side(s.getB(), s.getD())) {
            throw new FigureCannotExistException("figure is rectangle but not square");
        } else {
            return true;
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
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", name='" + name + '\'' +
                '}';
    }

}
