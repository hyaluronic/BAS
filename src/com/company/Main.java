package com.company;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("/Users/user/Desktop/BAS/Programos duomenys.txt");
        FileWriter writer = new FileWriter("/Users/user/Desktop/BAS/out.txt");
        List<String> allLines = reader.readAllLinesFromFile();
        for (String line : allLines) {
            writer.writeLineToFile(line);
            System.out.println(line);
        }
        writer.closeFile();
    }
}
