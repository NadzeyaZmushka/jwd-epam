package com.epam.jwd.zmushko.service.impl;

import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.model.Point;
import com.epam.jwd.zmushko.service.FigureCrud;
import com.epam.jwd.zmushko.service.Specification;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FigureCrudImpl implements FigureCrud {

    private final List<Figure> data;
    FigureFactory factory;

    public FigureCrudImpl(List<Figure> data, FigureFactory factory) {
        this.data = data;
        this.factory = factory;
    }

    @Override
    public Figure create(FigureType type, Point[] points) throws FigureException {
        Figure figure = factory.createFigure(type, points);
        data.add(figure);
        return figure;
    }

    @Override
    public List<Figure> multiCreate(FigureType type, Point[] points, int count) throws FigureException {
        List<Figure> resultList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            resultList.add(create(type, points));
        }
        return resultList;
    }

    @Override
    public boolean delete(Figure figure) {
        return data.remove(figure);
    }

    @Override
    public int find(Figure figure) {
        return data.indexOf(figure);
    }

    @Override
    public List<Figure> update(int index, Figure figure) {
        data.set(index, figure);
        return data;
    }

    @Override
    public Optional<Figure> findById(long id) {
        List<Figure> resultList = data.stream().filter(o -> id == o.getId()).collect(Collectors.toList());
        return resultList.size() != 0 ? Optional.of(resultList.get(0)) : Optional.empty();
    }

    @Override
    public Optional<Figure> findByCriteria(Specification specification) {
        return data.stream().filter(specification::specify).findAny();
    }

    @Override
    public Iterator<Figure> iterator() {
        return data.iterator();
    }

}
