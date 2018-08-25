package com.superdzen.ctci_making_anagrams;

import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 24.10.2017.
 * https://www.hackerrank.com/challenges/ctci-making-anagrams
 * Given two strings, a and b, that may or may not be of the same length,
 * determine the minimum number of character deletions required to make a and b anagrams.
 * Any characters can be deleted from either of the strings.
 */
public class StringsMakingAnagrams {
    public static int numberNeeded(String first, String second) {
        int num = 0;
        int[] lettersCounter = new int[26];

        for (char c : first.toCharArray()) {
            lettersCounter[c - 'a']++;
        }

        for (char c : second.toCharArray()) {
            lettersCounter[c - 'a']--;
        }

        for (int letterCounter : lettersCounter) {
            num += Math.abs(letterCounter);
        }

        return num;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
