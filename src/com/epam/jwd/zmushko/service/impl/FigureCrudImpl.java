package com.epam.jwd.zmushko.service.impl;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.factory.FigureFactory;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.model.Point;
import com.epam.jwd.zmushko.service.FigureCrud;
import com.epam.jwd.zmushko.service.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FigureCrudImpl implements FigureCrud {

    public static final Logger LOGGER = LogManager.getLogger();
    private final List<Figure> data;
    FigureFactory factory;

    public FigureCrudImpl(Collection<Figure> data, FigureFactory factory) {
        this.data = new ArrayList<>(data);
        this.factory = factory;
    }

    @Override
    public Figure create(FigureType type, Point[] figureConstituents) throws FigureException {
        Figure figure = factory.createFigure(type, figureConstituents);
        data.add(figure);
        return figure;
    }
//
    @Override
    public List<Figure> multiCreate(List<Point[]> figureConstituents, List<FigureType> types) throws FigureException {
        if (figureConstituents.size() != types.size()){
            throw new FigureCannotExistException("Invalid parameters");
        }
        List<Figure> listResult = new ArrayList<>();
        Iterator<Point[]> iterator = figureConstituents.iterator();
        for (FigureType type : types) {
            Figure figure = factory.createFigure(type, iterator.next());
            listResult.add(figure);
        }
        data.addAll(listResult);
        return listResult;
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
    public Figure update(int index, Figure figure) {
        return data.set(index, figure);
    }

    @Override
    public Optional<Figure> findById(int index) {
        return Optional.of(data.get(index));
    }

    @Override
    public List<Figure> findByCriteria(Specification specification) {
        return data.stream().filter(specification::specify).collect(Collectors.toList());
    }

    @Override
    public Iterator<Figure> iterator() {
        return data.iterator();
    }
}
