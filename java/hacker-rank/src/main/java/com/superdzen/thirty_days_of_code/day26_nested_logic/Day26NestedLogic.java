package com.superdzen.thirty_days_of_code.day26_nested_logic;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 01.08.2017.
 * https://www.hackerrank.com/challenges/30-nested-logic/
 * Months starts with 0 ((
 */
public class Day26NestedLogic {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int dayActReturned = scanner.nextInt();
        int monthActReturned = scanner.nextInt();
        int yearActReturned = scanner.nextInt();
        int dayExpReturned = scanner.nextInt();
        int monthExpReturned = scanner.nextInt();
        int yearExpReturned = scanner.nextInt();

        Calendar calendarActReturned = new GregorianCalendar(yearActReturned, monthActReturned - 1, dayActReturned);
        Calendar calendarExpReturned = new GregorianCalendar(yearExpReturned, monthExpReturned - 1, dayExpReturned);

        int fine = 0;

        if (calendarActReturned.after(calendarExpReturned)) {
            if (calendarActReturned.get(Calendar.MONTH) == calendarExpReturned.get(Calendar.MONTH)
                    && calendarActReturned.get(Calendar.YEAR) == calendarExpReturned.get(Calendar.YEAR)) {
                fine = 15 * (calendarActReturned.get(Calendar.DAY_OF_MONTH) - calendarExpReturned.get(Calendar.DAY_OF_MONTH));
            } else if (calendarActReturned.get(Calendar.YEAR) == calendarExpReturned.get(Calendar.YEAR)) {
                fine = 500 * (calendarActReturned.get(Calendar.MONTH) - calendarExpReturned.get(Calendar.MONTH));
            } else {
                fine = 10000;
            }
        }

        System.out.println(fine);

    }
}
