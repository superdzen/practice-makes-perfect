package com.superdzen.springdemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService {

    private String fileName = "java/spring-demo-annotations/src/main/resources/fortunes.txt";
    private List<String> theFortunes;

    public FileFortuneService() {
        File theFile = new File(fileName);

        theFortunes = new ArrayList<>();
       // System.out.println("Reading file " + fileName);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(theFile))) {
            String tmpLine;
            while ((tmpLine = bufferedReader.readLine()) != null) {
                theFortunes.add(tmpLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Random myRandom = new Random();

    @Override
    public String getFortune() {
        int ix = myRandom.nextInt(theFortunes.size());
        return theFortunes.get(ix);
    }

    @PostConstruct
    private void testPostConstructAnnotation() {
        File file = new File(fileName);
        String tmpString;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            System.out.print(">> Reading file in @PostConstruct method: ");
            while ((tmpString = bufferedReader.readLine()) != null) {
                System.out.print(tmpString + ", ");
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
