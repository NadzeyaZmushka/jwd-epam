package com.epam.jwd.zmushko.service;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.model.Line;
import com.epam.jwd.zmushko.model.Square;
import com.epam.jwd.zmushko.model.Triangle;

import static com.epam.jwd.zmushko.startegy.Distance.side;

public final class FigureValidator {
    public static boolean isLine(Line l) throws FigureCannotExistException {
        if (l.getA().equals(l.getB())) {
            throw new FigureCannotExistException("not enough points");
        } else {
            return true;
        }
    }

    /*A triangle cannot exist if three points lie on the same straight line*/
    public static boolean isTriangle(Triangle t) throws FigureCannotExistException {
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
    public static boolean isSquare(Square s) throws FigureCannotExistException {
        if (s.getA().equals(s.getB()) || s.getA().equals(s.getC()) ||
                s.getA().equals(s.getD()) || s.getB().equals(s.getC()) ||
                s.getB().equals(s.getD()) || s.getC().equals(s.getD())) {
            throw new FigureCannotExistException("not enough points");
        } else if (side(s.getA(), s.getB()) != side(s.getB(), s.getC()) ||
                side(s.getC(), s.getD()) != side(s.getD(), s.getA()) ||
                side(s.getB(), s.getC()) != side(s.getD(), s.getA()) ||
                side(s.getA(), s.getC()) != side(s.getB(), s.getD())) {
            throw new FigureCannotExistException("figure is rectangle but not square");
        } else {
            return true;
        }
    }
}
