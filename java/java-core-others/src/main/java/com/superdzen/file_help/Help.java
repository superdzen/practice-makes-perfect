package com.superdzen.file_help;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by superdzen@gmail.com on 19.08.2017.
 */
public class Help {
    String helpFile;

    public Help(String helpFile) {
        this.helpFile = helpFile;
    }

    String getSelection(){
        String topic = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            topic = bufferedReader.readLine();

        } catch (IOException e) {
            System.out.println("Ошибка при чтении с консоли");
        }
        return topic;
    }

    boolean helpOn(String what) {
        int ch;
        String topic, info;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(helpFile))) {
            do {
                ch = bufferedReader.read();
                if (ch == '#') {
                    topic = bufferedReader.readLine();
                    if (what.compareTo(topic) == 0) {
                        do {
                            info = bufferedReader.readLine();
                            if (info != null) {
                                System.out.println(info);
                            }
                        } while (info != null && info.length() != 0);
                        return true; //Тема найдена
                    }
                }
            } while (ch != -1);
        } catch (IOException e) {
            System.out.println("Ошибка доступа к файлу справки");
            return false;
        }
        return false; // Тема не найдена
    }
}
