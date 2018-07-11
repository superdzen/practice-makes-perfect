package com.superdzen.java_challenges.strings.java_substring_comparisons;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by superdzen@gmail.com on 08.07.2017.
 * https://www.hackerrank.com/challenges/java-string-compare
 * Given a string s, and an integer k, complete the function
 * so that it finds the lexicographically smallest and largest substrings of length k.
 */
public class JavaSubstringComparisons {
    public static String getSmallestAndLargestSimple(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = smallest;
        String subString;
        for (int j = 0; j < s.length() - k + 1; j++) {
            subString = s.substring(j, j + k);
            if (subString.compareTo(smallest) < 0) {
                smallest = subString;
            }
            if (subString.compareTo(largest) > 0) {
                largest = subString;
            }
        }
        return smallest + "\n" + largest;
    }

    public static String getSmallestAndLargestWithTreeSet(String s, int k) {
        SortedSet<String> sortedSet = new TreeSet<>();
        for (int j = 0; j <= s.length() - k; j++) {
            sortedSet.add(s.substring(j, j+k));
        }
        return sortedSet.first() + "\n" + sortedSet.last();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
        System.out.println(getSmallestAndLargestWithTreeSet(s, k));
    }
}
