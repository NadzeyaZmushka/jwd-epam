package com.epam.jwd.zmushko.app;

import com.epam.jwd.zmushko.model.Figure;

import java.util.Collection;

public class PrintInfoAboutFigures {

    public static void printInfo(Collection<? extends Figure> figures) {
        for (Figure figure : figures) {
            System.out.println("Figure: " + figure.toString() + "\n" +
                    "with area: " + figure.getFigureCalculator().calculateArea(figure) + "\n" +
                    "with perimeter: " + figure.getFigureCalculator().calculatePerimeter(figure));
        }
    }

}
