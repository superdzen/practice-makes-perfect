package com.superdzen.bankaccountapp.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by superdzen@gmail.com on 30.05.2018.
 */
public class CSV {
    // This method will read data from a CSV file and return as a list
    public static List<String[]> read(String file) {
        List<String[]> data = new LinkedList<>();
        String dataRow;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((dataRow = bufferedReader.readLine()) != null) {
                String[] dataRecords = dataRow.split(",");
                data.add(dataRecords);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file: " + file);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read file: " + file);
            e.printStackTrace();
        }
        return data;
    }
}