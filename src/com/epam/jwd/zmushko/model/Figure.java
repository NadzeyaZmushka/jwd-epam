package com.epam.jwd.zmushko.model;

import com.epam.jwd.zmushko.startegy.Perimeter;
import com.epam.jwd.zmushko.startegy.SquareOfFigure;

public abstract class Figure {
    FigureType type;
    Perimeter perimeter;
    SquareOfFigure square;


    public void setPerimeter(Perimeter per) {
        perimeter = per;
    }

    public void setSquareOfFigure(SquareOfFigure sq) {
        square = sq;
    }

    public FigureType getType() {
        return type;
    }
}
