package com.superdzen.interview_preparation_kit.sherlock_and_anagrams;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams
 * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string.
 * Given a string, find the number of pairs of substrings of the string that are anagrams of each other.
 */
public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int numOfAnagrams = 0;
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < s.length() - i + 1; j++) {
                char[] subString = s.substring(i, i + j).toCharArray();
                Arrays.sort(subString);
                String s1 = Arrays.toString(subString);
                if (m.containsKey(s1)) {
                    int v1 = m.get(s1);
                    numOfAnagrams += v1;
                    m.put(s1, v1 + 1);
                } else {
                    m.put(s1, 1);
                }
            }
        }
        return numOfAnagrams;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            System.out.println(result);
        }
        scanner.close();
    }
}
