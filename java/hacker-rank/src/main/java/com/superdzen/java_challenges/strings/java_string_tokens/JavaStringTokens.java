package com.superdzen.java_challenges.strings.java_string_tokens;

import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 09.07.2017.
 * https://www.hackerrank.com/challenges/java-string-tokens
 * A token is one or more consecutive English alphabetic letters.
 * Print count of all tokens, and all the tokens
 */
public class JavaStringTokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        //delete spaces at the edges
        s = s.trim();

        //Check if empty string
        if (s.length() == 0) {
            System.out.println(0);
            return;
        }
        //Splitting on non-alphabet characters
        String[] tokens = s.split("[ !,?._'@]+");

        System.out.println(tokens.length);
        if (tokens.length > 0) {
            for (String str : tokens) {
                System.out.println(str);
            }
        }
        scan.close();
    }
}
