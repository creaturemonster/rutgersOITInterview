package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndReturnContentsOfFile {
    /**
     *  The question asked me to write a Java Program that will read and display the contents of the file.
     * @param file
     * @throws IOException
     */
    public void readFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
       try{
           String st;
           while ((st = br.readLine()) != null){
               System.out.println(st);
           }
       }catch (IOException e){
            new IOException();
       } finally{
           br.close();
       }
    }
}
