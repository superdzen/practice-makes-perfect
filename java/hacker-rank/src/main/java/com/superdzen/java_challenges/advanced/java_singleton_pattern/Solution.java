package com.superdzen.java_challenges.advanced.java_singleton_pattern;

/**
 * Created by superdzen@gmail.com on 03.09.2017.
 * https://www.hackerrank.com/challenges/java-singleton
 */
public class Solution {
    public String str;
    private static Solution instance;

    private Solution() {
    }

    public static Solution getSingleInstance() {
        if (instance == null) {
            instance = new Solution();
        }
        return instance;
    }

}
