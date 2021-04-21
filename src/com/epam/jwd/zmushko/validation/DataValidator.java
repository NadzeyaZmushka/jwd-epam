package com.epam.jwd.zmushko.validation;

import com.epam.jwd.zmushko.action.DataReader;
import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.model.Point;

public class DataValidator {

    public boolean isValidDataFromFile() throws FigureCannotExistException {
        boolean result = false;
        for (Double data : DataReader.readCoordinatesToDoubleArray()) {
            if (data != null) {
                result = true;
            } else {
                throw new FigureCannotExistException("Not enough data");
            }
        }
        return result;
    }
}
