package com.epam.jwd.zmushko.service;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.FigureType;

import java.util.List;

public interface FigureCrud {
    Figure create(FigureType type, int points) throws FigureCannotExistException;

    List<Figure> multiCreate(FigureType... types);

    boolean delete(Figure figure);

    Figure find(Figure figure);

    boolean update(Figure figure);

    Figure fondById(int index);
}
