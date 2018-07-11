package com.superdzen.java_challenges.strings.java_regex3_username_checker;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by superdzen@gmail.com on 12.07.2017.
 * https://www.hackerrank.com/challenges/valid-username-checker
 * Your task is to check whether that username is valid. A valid username will have the following properties:
 * The username can contain alphanumeric characters and/or underscores(_).
 * The username must start with an alphabetic character.
 * 8 <= |Username| <= 30.
 */
public class JavaRegex3UsernameChecker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String username = in.nextLine();
            String pattern = "^[a-zA-Z][\\w]{7,29}$";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(username);

            if (m.find()) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
            testCases--;
        }
    }
}
