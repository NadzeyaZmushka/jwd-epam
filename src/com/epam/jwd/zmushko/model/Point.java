package com.epam.jwd.zmushko.model;

import com.epam.jwd.zmushko.action.DataReader;

import java.util.Objects;
import java.util.Random;

public class Point extends Figure {
    private final double x;
    private final double y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    static Point createPoint() {
        DataReader coordinate = new DataReader();
        double[] data = coordinate.getCoordinates();
        Random random = new Random();
        return new Point(data[random.nextInt(data.length)], data[random.nextInt(data.length)]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
