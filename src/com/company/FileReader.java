package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    public FileReader() {
    }

    public List<String> readLine() {
        try {
            List<String> allLines = Files.readAllLines(Paths.get("/Users/user/Desktop/BAS/Programos duomenys.txt"));
            return allLines;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
