package com.superdzen.trywithres;

import java.io.IOException;

/**
 * Created by superdzen@gmail.com on 19.06.2018.
 */
public class Main {
    public static void main(String[] args) {
        try (ClosableClass closableObject = new ClosableClass(System.in)) {
            closableObject.readAndPrintLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
