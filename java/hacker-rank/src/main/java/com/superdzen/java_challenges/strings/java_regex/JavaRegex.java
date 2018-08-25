package com.superdzen.java_challenges.strings.java_regex;

import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 11.07.2017.
 * https://www.hackerrank.com/challenges/java-regex
 * Write a class called MyRegex which will contain a string pattern.
 * You need to write a regular expression and assign it to the pattern such that it can be used to validate an IPv4 address.
 * There are two variants of pattern described in MyRegex class. Considering that IPv4-address can start with "0".
 */
public class JavaRegex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String IP = in.next();
            System.out.print(IP.matches(new MyRegex().pattern1) + "  ");
            System.out.println(IP.matches(new MyRegex().pattern2));
        }
    }
}

class MyRegex {
    static final String pattern1 = "^(([01]?\\d?\\d|25[0-5]|2[0-4]\\d)(\\.|$)){4}$";
    static final String pattern2 = "" +
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
}