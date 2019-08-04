package com.superdzen.jackson.utils;

import com.superdzen.jackson.json.demo.Driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

public class FileUtils {

    public static File getFileFromResources(String fileName) throws FileNotFoundException {

        ClassLoader classLoader = Driver.class.getClassLoader();
        URL resourceURL = classLoader.getResource(fileName);

        if (resourceURL == null) {
            throw new FileNotFoundException();
        }

        return new File(resourceURL.getFile());
    }
}
