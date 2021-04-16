package com.epam.jwd.zmushko.model;

import com.epam.jwd.zmushko.startegy.MultiAngleCalculator;

import java.util.Objects;

public class MultiAngleFigure extends Figure {
    private static final String NAME = "MultiAngle";
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;
    private Point p5;
    private Point p6;

    private MultiAngleFigure() {
        name = NAME;
        type = FigureType.MULTI_ANGLE_FIGURE;
        figureCalculator = MultiAngleCalculator.INSTANCE;
    }

    public static class Builder {
        private final MultiAngleFigure multiAngleFigure;

        public Builder() {
            multiAngleFigure = new MultiAngleFigure();
        }


        public Builder withFourAngles(Point[] points) {
            multiAngleFigure.p1 = points[0];
            multiAngleFigure.p2 = points[1];
            multiAngleFigure.p3 = points[2];
            multiAngleFigure.p4 = points[3];
            return this;
        }

        public Builder withFiveAngles(Point[] points) {
            multiAngleFigure.p1 = points[0];
            multiAngleFigure.p2 = points[1];
            multiAngleFigure.p3 = points[2];
            multiAngleFigure.p4 = points[3];
            multiAngleFigure.p5 = points[4];
            return this;
        }

        public Builder withSixAngles(Point[] points) {
            multiAngleFigure.p1 = points[0];
            multiAngleFigure.p2 = points[1];
            multiAngleFigure.p3 = points[2];
            multiAngleFigure.p4 = points[3];
            multiAngleFigure.p5 = points[4];
            multiAngleFigure.p6 = points[5];
            return this;
        }

        public MultiAngleFigure build() {
            return multiAngleFigure;
        }
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
