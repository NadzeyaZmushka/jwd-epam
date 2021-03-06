package com.epam.jwd.zmushko.service;

import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.model.Point;

import java.util.List;
import java.util.Optional;

public interface FigureCrud extends Iterable<Figure> {
    Figure create(FigureType type, Point[] figureConstituents) throws FigureException;

    List<Figure> multiCreate(FigureType type, Point[] points, int count) throws FigureException;

    boolean delete(Figure figure);

    int find(Figure figure);

    List<Figure> update(int index, Figure figure);

    Optional<Figure> findById(long id);

    Optional<Figure> findByCriteria(Specification specification);
}
