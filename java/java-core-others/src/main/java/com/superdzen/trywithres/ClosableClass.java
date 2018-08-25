package com.superdzen.trywithres;

import java.io.*;

/**
 * Created by superdzen@gmail.com on 19.06.2018.
 */
public class ClosableClass implements Closeable {

    private BufferedReader bufferedReader;

    public ClosableClass(InputStream inputStream) {
        System.out.println("Creating AutoClosable object for reading line and print it");
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public void readAndPrintLine() throws IOException {
        System.out.print("Enter input line: ");
        System.out.println("Input line: " + bufferedReader.readLine());
    }

    @Override
    public void close() throws IOException {
        if (bufferedReader != null) {
            System.out.print("AutoClosable object isn't null! Closing........");
            try {
                bufferedReader.close();
            } finally {
                bufferedReader = null;
                System.out.println(" closed.");
            }
        }
    }
}
