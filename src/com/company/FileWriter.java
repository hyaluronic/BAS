package com.company;

import java.io.IOException;

public class FileWriter {
    private java.io.FileWriter fw;

    public FileWriter(String path) throws IOException {
       fw = new java.io.FileWriter(path);
    }

    public void writeLineToFile(String line) throws IOException {
        fw.write(line + "\n");
    }

    public void closeFile() throws IOException {
        fw.close();
    }
}
