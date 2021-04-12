package com.epam.jwd.zmushko.decorator;

import com.epam.jwd.zmushko.factory.FigureFactory;
import com.epam.jwd.zmushko.model.Figure;

public class PostProcessingFactory extends FigureFactoryDecorator {
    FigureFactory figureFactory;

    public PostProcessingFactory(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    public void postProcess(Figure figure) {
        System.out.println("post process");
    }
}
