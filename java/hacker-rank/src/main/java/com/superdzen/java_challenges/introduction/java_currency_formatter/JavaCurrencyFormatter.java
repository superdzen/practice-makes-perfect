package com.superdzen.java_challenges.introduction.java_currency_formatter;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 08.07.2017.
 * https://www.hackerrank.com/challenges/java-currency-formatter
 * In Russia delimiter in double-precision number is ","
 */
public class JavaCurrencyFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        Locale indiaLocale = new Locale("en", "IN");

        NumberFormat numberFormatUS = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat numberFormatIndia = NumberFormat.getCurrencyInstance(indiaLocale);
        NumberFormat numberFormatChina = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat numberFormatFrance = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        System.out.println("US: " + numberFormatUS.format(payment));
        System.out.println("India: " + numberFormatIndia.format(payment));
        System.out.println("China: " + numberFormatChina.format(payment));
        System.out.println("France: " + numberFormatFrance.format(payment));
    }
}

