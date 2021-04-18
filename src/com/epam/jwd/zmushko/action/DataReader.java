package com.epam.jwd.zmushko.action;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataReader {

    private static String[] readCoordinatesToString() {
        String filePath = "src/com/epam/jwd/zmushko/resource/point.txt";
        File file = new File(filePath);
        DataInputStream fin;
        String[] data = null;
        StringBuilder s = new StringBuilder();
        try {
            fin = new DataInputStream(new FileInputStream(file));
            int a;
            while ((a = fin.read()) != -1) {
                s.append((char) a);
            }
            data = s.toString().split(" ");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return data;
    }

    public static double[] readCoordinatesToDoubleArray() {
        String[] str = readCoordinatesToString();
        double[] coordinates = new double[str.length];
        for (int i = 0; i < str.length; i++) {
            coordinates[i] = Double.parseDouble(str[i]);
        }
        return coordinates;
    }
}
