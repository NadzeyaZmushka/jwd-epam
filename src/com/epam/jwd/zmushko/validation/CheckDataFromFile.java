package com.epam.jwd.zmushko.validation;

import com.epam.jwd.zmushko.action.DataReader;
import com.epam.jwd.zmushko.exception.FigureCannotExistException;

public class CheckDataFromFile {

    public boolean isValidData() throws FigureCannotExistException {
        boolean result = false;
        for (Double data : DataReader.readCoordinatesToDoubleArray()) {
            if (data != null && DataReader.readCoordinatesToDoubleArray().length >= 4) {
                result = true;
            } else {
                throw new FigureCannotExistException("not enough data");
            }
        }
        return result;
    }
}
