package com.epam.jwd.zmushko.factory;

import com.epam.jwd.zmushko.decorator.PostProcessingFactory;
import com.epam.jwd.zmushko.decorator.PreProcessingFactory;
import com.epam.jwd.zmushko.model.SimpleFigureFactory;

public class ApplicationContext {

    static FigureFactory newInstance() {
        return new PostProcessingFactory(
                new PreProcessingFactory(
                        SimpleFigureFactory.getInstance()
                )
        );
    }
}
