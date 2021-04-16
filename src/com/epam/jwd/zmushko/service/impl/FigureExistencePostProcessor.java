package com.epam.jwd.zmushko.service.impl;

import com.epam.jwd.zmushko.exception.FigureException;
import com.epam.jwd.zmushko.model.Figure;
import com.epam.jwd.zmushko.model.FigureType;
import com.epam.jwd.zmushko.service.FigurePostProcessor;
import com.epam.jwd.zmushko.validation.FigureValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FigureExistencePostProcessor implements FigurePostProcessor {
    public static final Logger LOGGER = LogManager.getLogger(FigureExistencePostProcessor.class);

    @Override
    public Figure process(Figure figure) throws FigureException {
        if (figure.getType().equals(FigureType.LINE)){
            if (FigureValidator.isLine(figure)){
                LOGGER.info("post process: figure " + Figure.getName() + " was created");
            }
        }else if (figure.getType().equals(FigureType.TRIANGLE)){
            if (FigureValidator.isTriangle(figure)){
                LOGGER.info("post process: figure " + Figure.getName() + " was created");
            }
        }else if (figure.getType().equals(FigureType.SQUARE)){
            if (FigureValidator.isSquare(figure)){
                LOGGER.info("post process: figure " + Figure.getName() + " was created");
            }
        }
        return figure;
    }
}
