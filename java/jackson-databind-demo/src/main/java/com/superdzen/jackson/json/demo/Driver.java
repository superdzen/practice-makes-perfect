package com.superdzen.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import static com.superdzen.jackson.utils.FileUtils.getFileFromResources;

public class Driver {
    public static void main(String[] args) {
        try {
            // create object mapper
            ObjectMapper mapper = new ObjectMapper();

            // read JSON file and map to JAVA POJO
            Student student1 =
                    mapper.readValue(getFileFromResources("sample-lite.json"), Student.class);

            // print object
            System.out.println("Student #1: " + student1);

            System.out.println("--------------------------");
            // read another JSON file and map to JAVA POJO
            Student student2 =
                    mapper.readValue(getFileFromResources("sample-full.json"), Student.class);

            // print object
            System.out.println("Student #2: " + student2);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
