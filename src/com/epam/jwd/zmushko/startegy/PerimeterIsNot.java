package com.epam.jwd.zmushko.startegy;

public enum PerimeterIsNot implements Perimeter {
    INSTANCE;

    @Override
    public double calculatePerimeter() {
        return 0;
    }
}
