package com.superdzen.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import static com.superdzen.jackson.utils.FileUtils.*;

public class Driver {
    public static void main(String[] args) {
        try {
            // create object mapper
            ObjectMapper mapper = new ObjectMapper();

            // read JSON file and map to JAVA POJO
            Student student =
                    mapper.readValue(getFileFromResources("sample-lite.json"), Student.class);

            // print object properties
            System.out.println("Student firstName: " + student.getFirstName());
            System.out.println("Student lastName: " + student.getLastName());
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
