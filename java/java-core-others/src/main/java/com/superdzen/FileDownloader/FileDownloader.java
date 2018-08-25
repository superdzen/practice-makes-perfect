package com.superdzen.FileDownloader;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by superdzen@gmail.com on 13.11.2017.
 */
public class FileDownloader {
    public static void main(String[] args) {
        String urlToDownload = "https://raw.githubusercontent.com/superdzen/JavaTraining/master/src/main/java/com/superdzen/others/FileDownloader/file.txt";
        long startTime = System.currentTimeMillis();
        SimpleDownloader(urlToDownload);
        long midTime = System.currentTimeMillis();
        System.out.println("SimpleDownloader function took " + (midTime - startTime) + " miliseconds");
        BufferedDownloader(urlToDownload);
        long endTime = System.currentTimeMillis();
        System.out.println("BufferedDownloader function took " + (endTime - midTime) + " miliseconds");
    }

    public static void SimpleDownloader(String urlString) {
        URL url = null;
        URLConnection urlConnection = null;

        try {
            url = new URL(urlString);
            urlConnection = url.openConnection();

            InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
            FileOutputStream outputStream = new FileOutputStream(new File("simple.donwloaded.file"));
            int ch;
            while ((ch = inputStreamReader.read()) != -1) {
                outputStream.write(ch);
            }
        } catch (MalformedURLException e) {
            System.out.println("Please check the url string");
        } catch (IOException e) {
            System.out.println("Some IO Exception while opening URL connection");
        }

    }

    public static void BufferedDownloader(String urlString) {
        URL url = null;
        URLConnection urlConnection = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            url = new URL(urlString);
            urlConnection = url.openConnection();

            bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
            bufferedOutputStream = new BufferedOutputStream(
                    new FileOutputStream(new File("buffered.donwloaded.file")));
            int count;

            while ((count = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(count);
            }
        } catch (MalformedURLException e) {
            System.out.println("Please check the url string");
        } catch (IOException e) {
            System.out.println("Some IO Exception");
        }finally {
            if(bufferedInputStream !=null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream!=null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
