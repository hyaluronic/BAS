package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    private final String path;

    public FileReader(String path) {
        this.path = path;
    }

    public List<String> readAllLinesFromFile() {
        try {
            List<String> allLines = Files.readAllLines(Paths.get(path));
            return allLines;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
