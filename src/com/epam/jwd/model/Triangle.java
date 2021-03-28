package com.epam.jwd.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Triangle {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String NAME = "Triangle";
    private Point point1;
    private Point point2;
    private Point point3;

    public static Triangle createTriangle(Point a, Point b, Point c) {
        Triangle triangle = null;
        if (a.equals(b) || a.equals(c) || b.equals(c)) {
            LOGGER.error("Object " + Triangle.class.toString() + " isn't figure " + NAME);
        }else {
            triangle = new Triangle(a, b, c);
        }
        return triangle;
    }

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (point1 != null ? !point1.equals(triangle.point1) : triangle.point1 != null) return false;
        if (point2 != null ? !point2.equals(triangle.point2) : triangle.point2 != null) return false;
        return point3 != null ? point3.equals(triangle.point3) : triangle.point3 == null;
    }

    @Override
    public int hashCode() {
        int result = point1 != null ? point1.hashCode() : 0;
        result = 31 * result + (point2 != null ? point2.hashCode() : 0);
        result = 31 * result + (point3 != null ? point3.hashCode() : 0);
        return result;
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
