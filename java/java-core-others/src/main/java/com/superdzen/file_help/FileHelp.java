package com.superdzen.file_help;

/**
 * Created by superdzen@gmail.com on 19.08.2017.
 */
public class FileHelp {
    public static void main(String[] args) {
        Help helpObject = new Help("c:\\helpfile.txt");
        String topic;

        System.out.println("Воспользуйтесь справочной системой\nДля выхода из системы наберите 'stop'.");

        do {
            topic = helpObject.getSelection();
            if (topic.equals("stop")) {
                break;
            }
            if (!helpObject.helpOn(topic)) {
                System.out.println("Тема не найдена.\n");
            }
        } while (true);
    }
}

