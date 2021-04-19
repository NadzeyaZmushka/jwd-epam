package com.epam.jwd.zmushko.action;

public class IdGenerator {
    private static long id = 1L;

    public static long getId() {
        return id++;
    }
}
