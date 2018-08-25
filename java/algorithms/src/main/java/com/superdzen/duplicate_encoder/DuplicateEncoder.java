package com.superdzen.duplicate_encoder;

/**
 * Created by superdzen@gmail.com on 25.06.2017.
 * https://www.codewars.com/kata/54b42f9314d9229fd6000d9c
 *
 * The goal of this exercise is to convert a string to a new string where each character in the new string is '('
 * if that character appears only once in the original string, or ')'
 * if that character appears more than once in the original string.
 * Ignore capitalization when determining if a character is a duplicate.
 * Examples:
 * "din" => "((("
 * "recede" => "()()()"
 * "Success" => ")())())"
 * "(( @" => "))(("
 */
public class DuplicateEncoder {
    public static void main(String[] args) {
        System.out.println(encode("Success"));
    }
    static String encode(String word) {
        String tempString = word.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tempString.length(); i++) {
            char ch = tempString.charAt(i);
            if (tempString.indexOf(ch) == tempString.lastIndexOf(ch)) {
                stringBuilder.append("(");
            } else {
                stringBuilder.append(")");
            }
        }
        return stringBuilder.toString();
    }
}