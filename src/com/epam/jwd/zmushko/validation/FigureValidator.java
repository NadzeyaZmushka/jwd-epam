package com.epam.jwd.zmushko.validation;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.model.Line;
import com.epam.jwd.zmushko.model.Square;
import com.epam.jwd.zmushko.model.Triangle;

import static com.epam.jwd.zmushko.action.Distance.calculateDistance;

public class FigureValidator {
    public static boolean isLine(Line l) throws FigureCannotExistException {
        if (l.getPoint1().equals(l.getPoint2())) {
            throw new FigureCannotExistException("not enough points");
        } else {
            return true;
        }
    }

    /*A triangle cannot exist if three points lie on the same straight line*/
    public static boolean isTriangle(Triangle t) throws FigureCannotExistException {
        if (t.getPoint1().equals(t.getPoint2()) || t.getPoint1().equals(t.getPoint3())
                || t.getPoint2().equals(t.getPoint3())) {
            throw new FigureCannotExistException("not enough points");
        } else if ((t.getPoint1().getX() == t.getPoint2().getX() && t.getPoint1().getX() == t.getPoint3().getX()) ||
                t.getPoint1().getY() == t.getPoint2().getY() && t.getPoint1().getY() == t.getPoint3().getY()) {
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
        } else if (calculateDistance(s.getA(), s.getB()) != calculateDistance(s.getB(), s.getC()) ||
                calculateDistance(s.getC(), s.getD()) != calculateDistance(s.getD(), s.getA()) ||
                calculateDistance(s.getB(), s.getC()) != calculateDistance(s.getD(), s.getA()) ||
                calculateDistance(s.getA(), s.getC()) != calculateDistance(s.getB(), s.getD())) {
            throw new FigureCannotExistException("figure is rectangle but not square");
        } else {
            return true;
        }
    }
}
