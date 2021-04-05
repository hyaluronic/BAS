package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileReader reader = new FileReader();
        List<String> allLines = reader.readLine();
        for (String line : allLines) {
            System.out.println(line);
        }
    }
}
