package com.superdzen.codeforces_71a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by superdzen@gmail.com on 30.06.2017.
 * http://codeforces.com/problemset/problem/71/A
 * Sometimes some words like "localization" or "internationalization" are so long that writing them many times in one text is quite tiresome.
 * Let's consider a word too long, if its length is strictly more than 10 characters.
 * All too long words should be replaced with a special abbreviation.
 * This abbreviation is made like this: we write down the first and the last letter of a word and between them
 * we write the number of letters between the first and the last letters.
 * That number is in decimal system and doesn't contain any leading zeroes.
 * Thus, "localization" will be spelt as "l10n", and "internationalization» will be spelt as "i18n".
 * You are suggested to automatize the process of changing the words with abbreviations.
 * At that all too long words should be replaced by the abbreviation and the words that are not too long should not undergo any changes.
 * Input:
 * The first line contains an integer n (1 ≤ n ≤ 100). Each of the following n lines contains one word.
 * All the words consist of lowercase Latin letters and possess the lengths of from 1 to 100 characters.
 * Output:
 * Print n lines. The i-th line should contain the result of replacing of the i-th word from the input data.
 */
public class Solution71A {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int wordsCount = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < wordsCount; i++) {
                String inputString = bufferedReader.readLine();
                if (inputString.length() > 10) {
                    String outputString = "" + inputString.charAt(0) + (inputString.length() - 2) + inputString.charAt(inputString.length() - 1);
                    System.out.println(outputString);
                } else {
                    System.out.println(inputString);
                }
            }
        } catch (NumberFormatException numberFormatExceprion) {
            System.out.println("Invalid input number");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}