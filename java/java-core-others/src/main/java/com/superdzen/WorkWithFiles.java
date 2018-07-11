package com.superdzen;

import java.io.*;

/**
 * Created by superdzen@gmail.com on 17.08.2017.
 */
public class WorkWithFiles {
    public static void main(String[] args) {
        String srcFileName = "c:\\Training.iml";
        String dstFileName = "c:\\Training_copy.iml";

        //   copyFileByBytes(srcFileName, dstFileName);
        //read10BytesFromStdIn();

        copyFileBySymbols(srcFileName, dstFileName);
        compareFiles(srcFileName, dstFileName);
        printFileByLines(dstFileName);
    }

    public static void printFileByLines(String Filename) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Filename))) {
            String tmpString;
            while ((tmpString = bufferedReader.readLine()) != null) {
                System.out.println(tmpString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void copyFileBySymbols(String FileName1, String FileName2) {

        try (FileReader fileReader = new FileReader(FileName1);
             FileWriter fileWriter = new FileWriter(FileName2)) {
            int ch;
            while ((ch = fileReader.read()) != -1) {
                fileWriter.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void read10BytesFromStdIn() {
        byte[] charArray = new byte[10];

        try {
            System.in.read(charArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < charArray.length; i++) {
            System.out.print((char) charArray[i]);
        }

    }

    public static boolean compareFiles(String FileName1, String FileName2) {

        try (FileInputStream file1 = new FileInputStream(FileName1);
             FileInputStream file2 = new FileInputStream(FileName2)) {
            int b1, b2;
            do {
                b1 = file1.read();
                b2 = file2.read();
                if (b1 != b2) break;
            } while (b1 != -1 && b2 != -1);
            if (b1 == b2) {
                System.out.println("The files are the same.");
                return true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

    public static void copyFileByBytes(String inputFileName, String outputFileName) {

        try (FileInputStream fileInputStream = new FileInputStream(inputFileName);
             FileOutputStream fileOutputStream = new FileOutputStream(outputFileName)) {
            int b;
            while ((b = fileInputStream.read()) != -1) {
                // System.out.print((char) b);
                fileOutputStream.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
