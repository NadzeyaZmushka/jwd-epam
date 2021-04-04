package com.epam.jwd.zmushko.model;

import com.epam.jwd.zmushko.action.DataReader;

import java.util.Objects;
import java.util.Random;

public class Point extends Figure {
    private final int x;
    private final int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Point createPoint() {
//        return new Point((int) (Math.random() * 10 - 5), (int) (Math.random() * 10 - 5));
        DataReader coordinate = new DataReader();
        int[] data = coordinate.getCoordinates();
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
