package com.epam.jwd.zmushko.generator;

public class IdGenerator {

    private static long id = 1L;

    public static long getId() {
        return id++;
    }

}
