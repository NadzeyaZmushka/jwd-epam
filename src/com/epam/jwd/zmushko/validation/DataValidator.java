package com.epam.jwd.zmushko.validation;

import com.epam.jwd.zmushko.exception.FigureCannotExistException;
import com.epam.jwd.zmushko.util.DataReader;

public class DataValidator {

    public boolean isValidDataFromFile() throws FigureCannotExistException {
        boolean result = false;
        for (Double data : DataReader.mapCorrdinatesToDouble()) {
            if (data != null) {
                result = true;
            } else {
                throw new FigureCannotExistException("Not enough data");
            }
        }
        return result;
    }

}
