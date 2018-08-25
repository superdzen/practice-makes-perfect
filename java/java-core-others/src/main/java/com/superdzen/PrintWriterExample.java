package com.superdzen;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by superdzen@gmail.com on 19.08.2017.
 */
public class PrintWriterExample {
    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("c:\\Training.iml");
             PrintWriter printWriter = new PrintWriter(System.out,true)) {
            int ch;
            while ((ch = fileReader.read()) != -1) {
                printWriter.print((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
