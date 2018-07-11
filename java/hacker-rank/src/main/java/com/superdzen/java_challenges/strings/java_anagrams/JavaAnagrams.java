package com.superdzen.java_challenges.strings.java_anagrams;

import java.util.*;

/**
 * Created by superdzen@gmail.com on 09.07.2017.
 * https://www.hackerrank.com/challenges/java-anagrams
 * If a and b are case-insensitive anagrams, return true; otherwise, return false instead.
 * We use HashMap to determine anagrams
 */

public class JavaAnagrams {

    static boolean isAnagram(String a, String b) {

        //Strings need to be not null and have the same length
        if (a == null || b == null || (a.length() != b.length())) {
            return false;
        }
        char[] arrayA = a.toLowerCase().toCharArray();
        char[] arrayB = b.toLowerCase().toCharArray();
        Map<Character, Integer> hashMap = new HashMap<>();

        //Add characters of array to HashMap<character, frequency>
        for (char A : arrayA) {
            if (hashMap.containsKey(A)) {
                hashMap.put(A, (hashMap.get(A) + 1));
            } else {
                hashMap.put(A, 1);
            }
        }

        /*check if character in arrayB contains in HashMap
                    if yes - check if frequency > 0, update HashMap with frequency minus 1;
                    if frequency become 0; return false;
                if character in arrayB not contains in HashMap return false;
         */
        for (char B : arrayB) {
            if (!hashMap.containsKey(B)) {
                return false;
            }
            int count = hashMap.get(B);
            if (count > 0) {
                hashMap.put(B, --count);
            } else {
                return false;
            }
        }

        //if we could get here, it is an anagram
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
