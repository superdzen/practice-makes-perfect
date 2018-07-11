package com.superdzen.java_challenges.strings.tag_content_extractor;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by superdzen@gmail.com on 12.07.2017.
 * https://www.hackerrank.com/challenges/tag-content-extractor/
 * Given a string of text in a tag-based language, parse this text and retrieve the contents
 * enclosed within sequences of well-organized tags meeting the following criterion:
 *  The name of the start and end tags must be same.
 *  Tags can be nested, but content between nested tags is considered not valid.
 *  Tags can consist of any printable characters.
 */
public class TagContentExtractor {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        String patternString = "<(.+)>([^<]+)</\\1>";
        Pattern pattern = Pattern.compile(patternString);

        while (testCases > 0) {
            int count = 0;
            String line = in.nextLine();
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                if (matcher.group(2).length() != 0) {
                    System.out.println(matcher.group(2));
                    count++;
                }

            }
            if (count == 0) {
                System.out.println("None");
            }
            testCases--;
        }
    }
}
