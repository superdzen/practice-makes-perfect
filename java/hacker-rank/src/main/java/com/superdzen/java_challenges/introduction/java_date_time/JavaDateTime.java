package com.superdzen.java_challenges.introduction.java_date_time;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 08.07.2017.
 * https://www.hackerrank.com/challenges/java-date-and-time
 * You are given a date. Your task is to find what the day is on that date.
 */
public class JavaDateTime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int month = in.nextInt();
        int day = in.nextInt();
        int year = in.nextInt();
        Calendar calendar = new GregorianCalendar(year, month, day);
        System.out.println(new DateFormatSymbols().getWeekdays()[calendar.get(Calendar.DAY_OF_WEEK)].toUpperCase());
    }
}