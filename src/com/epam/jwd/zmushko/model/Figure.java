package com.epam.jwd.zmushko.model;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.generator.IdGenerator;
import com.epam.jwd.zmushko.startegy.FigureCalculatorStrategy;

import java.util.Objects;

public abstract class Figure {

    protected String name;
    protected long id;
    protected FigureCalculatorStrategy figureCalculator;

    public Figure() {
        this.id = IdGenerator.getId();
    }

    public abstract boolean isValid() throws FigureCannotExistException;

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public FigureCalculatorStrategy getFigureCalculator() {
        return figureCalculator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return id == figure.id &&
                Objects.equals(name, figure.name) &&
                Objects.equals(figureCalculator, figure.figureCalculator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, figureCalculator);
    }

    @Override
    public String toString() {
        return "Figure{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", figureCalculator=" + figureCalculator +
                '}';
    }
}
