package com.superdzen.file_search;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by superdzen@gmail.com on 23.08.2017.
 * This program searches for files by mask in given directory
 */
public class Main {
    private static String osType;

    public static void main(String[] args) {
        searchFor(".doc$", "D:\\");
    }

    public static void searchFor(String mask, String dir) {
        //check for wrong parameters
        if (mask != null && dir != null) {
            if (dir.length() == 0) {
                if (getOsName().equals("Windows")) {
                    dir = "c:\\";                               //if dir = "" then search from root dir
                } else if (getOsName().equals("Unix-like")) {
                    dir = "//";
                }
            }

            Pattern pattern = Pattern.compile(mask, Pattern.CASE_INSENSITIVE);

            walkDirRecursively(pattern, new File(dir));

        } else {
            System.out.println("Null parameters");
        }
    }

    public static void walkDirRecursively(Pattern pattern, File dir) {
        File listFiles[] = dir.listFiles();
        if (listFiles != null) {
            for (File listFile : listFiles) {
                if (listFile.isDirectory()) {
                    walkDirRecursively(pattern, listFile);
                } else {
                    Matcher m = pattern.matcher(listFile.getPath());
                    if (m.find()) {
                        System.out.println(listFile.getAbsolutePath());
                    }
                }
            }
        }
    }

    public static String getOsName() {
        if (osType == null) {
            String osName = System.getProperty("os.name");
            //System.out.println(osName);
            if (osName.contains("Windows")) {
                osType = "Windows";
            } else {
                osType = "Unix-like";
            }
        }
        return osType;
    }
}


