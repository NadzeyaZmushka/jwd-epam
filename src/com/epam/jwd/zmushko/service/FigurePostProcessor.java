package com.epam.jwd.zmushko.service;

import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.model.Figure;

public interface FigurePostProcessor {
    Figure process(Figure figure) throws FigureException;
}
