package com.superdzen.java_challenges.strings.pattern_syntax_checker;

import java.util.Scanner;
import java.util.regex.*;

/**
 * Created by superdzen@gmail.com on 10.07.2017.
 * https://www.hackerrank.com/challenges/pattern-syntax-checker
 * You are given a pattern. You have to check whether the syntax of the given pattern is valid.
 */
public class PatternSyntaxChecker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String pattern = in.nextLine();
            try {
                Pattern p = Pattern.compile(pattern);
                System.out.println("Valid");
            } catch (PatternSyntaxException pse) {
                System.out.println("Invalid");
            }
            testCases--;
        }
    }
}
