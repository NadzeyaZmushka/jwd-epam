package com.epam.jwd.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.jwd.action.Distance.*;

public class Square {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String NAME = "Square";

    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;

    public static Square createSquare(Point a, Point b, Point c, Point d) {
        Square square = null;
        if (a.equals(b) ||
                a.equals(c) ||
                a.equals(d) ||
                b.equals(c) ||
                b.equals(d) ||
                c.equals(d)) {
            LOGGER.error("object " + Square.class.toString() + " isn't figure " + NAME);
        } else if (calculateDistance(a, b) != calculateDistance(b, c) ||
                calculateDistance(c, d) != calculateDistance(d, a) ||
                calculateDistance(b, c) != calculateDistance(d, a) ||
                calculateDistance(a, c) != calculateDistance(b, d)) {
            LOGGER.error("object " + Square.class.toString() + " is rectangle, but not " + NAME);
        } else {
            square = new Square(a, b, c, d);
        }
        return square;
    }

    public Square(Point point1, Point point2, Point point3, Point point4) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        if (point1 != null ? !point1.equals(square.point1) : square.point1 != null) return false;
        if (point2 != null ? !point2.equals(square.point2) : square.point2 != null) return false;
        if (point3 != null ? !point3.equals(square.point3) : square.point3 != null) return false;
        return point4 != null ? point4.equals(square.point4) : square.point4 == null;
    }

    @Override
    public int hashCode() {
        int result = point1 != null ? point1.hashCode() : 0;
        result = 31 * result + (point2 != null ? point2.hashCode() : 0);
        result = 31 * result + (point3 != null ? point3.hashCode() : 0);
        result = 31 * result + (point4 != null ? point4.hashCode() : 0);
        return result;
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
