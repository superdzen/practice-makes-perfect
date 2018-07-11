package com.superdzen.thirty_days_of_code.day28_regex_patterns_and_intro_to_databases;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by superdzen@gmail.com on 02.08.2017.
 * https://www.hackerrank.com/challenges/30-regex-patterns/problem
 * Consider a database table, Emails, which has the attributes First Name and Email ID.
 * Given N rows of data simulating the Emails table, print an alphabetically-ordered list of people
 * whose email address ends in @gmail.com
 */
public class Day28RegExPatterns {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Pattern pattern = Pattern.compile(".+@gmail\\.com$");
        List<String> list = new ArrayList<>();

        for(int a0 = 0; a0 < N; a0++){
            String firstName = in.next();
            String emailID = in.next();
            Matcher matcher = pattern.matcher(emailID);
            if (matcher.find()) {
                list.add(firstName);
            }
        }

        Collections.sort(list);

        for (String s : list) {
            System.out.println(s);
        }
    }
}
