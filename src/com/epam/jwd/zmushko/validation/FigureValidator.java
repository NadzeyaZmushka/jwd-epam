package com.epam.jwd.zmushko.validation;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.Line;
import com.epam.jwd.zmushko.model.Square;
import com.epam.jwd.zmushko.model.Triangle;
import com.epam.jwd.zmushko.startegy.FigureCalculator;

public class FigureValidator {
    public static boolean isLine(Figure figure) throws FigureCannotExistException {
        Line l = (Line)figure;
        if (l.getA().equals(l.getB())) {
            throw new FigureCannotExistException("not enough points");
        } else {
            return true;
        }
    }

    /*A triangle cannot exist if three points lie on the same straight line*/
    public static boolean isTriangle(Figure figure) throws FigureCannotExistException {
        Triangle t = (Triangle)figure;
        if (t.getA().equals(t.getB()) || t.getA().equals(t.getC())
                || t.getB().equals(t.getC())) {
            throw new FigureCannotExistException("not enough points");
        } else if ((t.getA().getX() == t.getB().getX() && t.getA().getX() == t.getC().getX()) ||
                t.getA().getY() == t.getB().getY() && t.getA().getY() == t.getC().getY()) {
            throw new FigureCannotExistException("figure is not triangle");
        } else {
            return true;
        }
    }

    /*A square can exist if all four sides are equal
     *and the two diagonals are equal*/
    public static boolean isSquare(Figure figure) throws FigureCannotExistException {
        Square s = (Square)figure;
        FigureCalculator calculator = s.getFigureCalculator();
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
}
