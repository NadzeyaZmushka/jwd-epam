package com.epam.jwd.zmushko.model;

import java.util.Objects;

public class MultiAngleFigure extends Figure {
    private final Point p1;
    private final Point p2;
    private final Point p3;
    private final Point p4;
    private Point p5;
    private Point p6;

    private MultiAngleFigure(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    private MultiAngleFigure(Point p1, Point p2, Point p3, Point p4, Point p5) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
    }

    private MultiAngleFigure(Point p1, Point p2, Point p3, Point p4, Point p5, Point p6) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.p6 = p6;
    }

    static MultiAngleFigure createFigure(int sides) {
        MultiAngleFigure figure = null;
        switch (sides) {
            case 4:
                figure = new MultiAngleFigure(Point.createPoint(), Point.createPoint(),
                        Point.createPoint(), Point.createPoint());
                break;
            case 5:
                figure = new MultiAngleFigure(Point.createPoint(), Point.createPoint(),
                        Point.createPoint(), Point.createPoint(), Point.createPoint());
                break;
            case 6:
                figure = new MultiAngleFigure(Point.createPoint(), Point.createPoint(),
                        Point.createPoint(), Point.createPoint(), Point.createPoint(), Point.createPoint());
                break;
            default:
                throw new IllegalArgumentException();

        }
        return figure;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    public Point getP4() {
        return p4;
    }

    public Point getP5() {
        return p5;
    }

    public Point getP6() {
        return p6;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiAngleFigure figure = (MultiAngleFigure) o;
        return Objects.equals(p1, figure.p1) &&
                Objects.equals(p2, figure.p2) &&
                Objects.equals(p3, figure.p3) &&
                Objects.equals(p4, figure.p4) &&
                Objects.equals(p5, figure.p5) &&
                Objects.equals(p6, figure.p6);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p1, p2, p3, p4, p5, p6);
    }

    @Override
    public String toString() {
        return "MultiAngleFigure{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", p4=" + p4 +
                ", p5=" + p5 +
                ", p6=" + p6 +
                '}';
    }
}
