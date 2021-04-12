package com.epam.jwd.zmushko.service.impl;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.model.SimpleFigureFactory;
import com.epam.jwd.zmushko.service.FigureCrud;

import java.util.List;

public class FigureCrudImpl implements FigureCrud {

    @Override
    public Figure create(FigureType type, int points) throws FigureCannotExistException {
        FigureFactory factory = new SimpleFigureFactory();
        return factory.createFigure(type, points);
    }

    @Override
    public List<Figure> multiCreate(FigureType... types) {
        return null;
    }

    @Override
    public boolean delete(Figure figure) {
        return false;
    }

    @Override
    public Figure find(Figure figure) {
        return null;
    }

    @Override
    public boolean update(Figure figure) {
        return false;
    }

    @Override
    public Figure fondById(int index) {
        return null;
    }
}
