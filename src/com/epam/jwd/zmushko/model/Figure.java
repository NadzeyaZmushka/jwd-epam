package com.epam.jwd.zmushko.model;

import com.epam.jwd.zmushko.action.IdGenerator;
import com.epam.jwd.zmushko.startegy.FigureCalculator;

import java.util.Objects;

public abstract class Figure {

    String name;
    long id;
    FigureType type;
    FigureCalculator figureCalculator;

    public Figure() {
        this.id = IdGenerator.getId();
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public FigureType getType() {
        return type;
    }

    public FigureCalculator getFigureCalculator() {
        return figureCalculator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return type == figure.type &&
                Objects.equals(figureCalculator, figure.figureCalculator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, figureCalculator);
    }

    @Override
    public String toString() {
        return "Figure{" +
                "type=" + type +
                '}';
    }
}
