package com.epam.jwd.zmushko.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {

    public static List<String> readFromFile() {
        String filePath = "src/com/epam/jwd/zmushko/resource/point.txt";
        List<String> coordinateToString = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            coordinateToString = reader.lines()
                    .flatMap(s -> Arrays.stream(s.split(" ")))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return coordinateToString;
    }

    public static List<Double> mapCorrdinatesToDouble() {
        List<String> listCoordinates = readFromFile();
        List<Double> coordinates = new ArrayList<>();
        for (String str : listCoordinates) {
            coordinates.add(Double.parseDouble(str));
        }
        return coordinates;
    }

}
