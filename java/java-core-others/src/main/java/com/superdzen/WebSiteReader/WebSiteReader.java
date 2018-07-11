package com.superdzen.WebSiteReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by superdzen@gmail.com on 13.11.2017.
 */
public class WebSiteReader {
    public static void main(String[] args) {
        String nextLine;
        URL url = null;
        URLConnection urlConnection = null;

        try {
            url = new URL("http://www.megafon.ru");
            urlConnection = url.openConnection();
        } catch (MalformedURLException e) {
            System.out.println("Please, check the URL");
        } catch (IOException e) {
            System.out.println("Another IO Exception");
            e.printStackTrace();
        }

        if (urlConnection != null) {
            try (InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                while (true) {
                    nextLine = bufferedReader.readLine();
                    if (nextLine != null) {
                        System.out.println(nextLine);
                    } else {
                        break;
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
