package com.epam.jwd.zmushko.decorator;

import com.epam.jwd.zmushko.factory.FigureFactory;

public class PreProcessingFactory extends FigureFactoryDecorator {
    FigureFactory figureFactory;

    public PreProcessingFactory(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    public void preProcess() {
        System.out.println("pre process");
    }
}
