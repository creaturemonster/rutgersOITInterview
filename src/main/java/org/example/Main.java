package org.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
            ReadAndReturnContentsOfFile reader=new ReadAndReturnContentsOfFile();
            File file = new File("src/main/java/theGreatGatsby.txt");
            reader.readFile(file);
    }
}