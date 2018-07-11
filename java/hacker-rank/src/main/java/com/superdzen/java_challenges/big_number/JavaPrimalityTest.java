package com.superdzen.java_challenges.big_number;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 12.07.2017.
 * https://www.hackerrank.com/challenges/java-primality-test/
 * Given a large integer, use the Java BigInteger class' isProbablePrime method
 * to determine and print whether it's prime or not prime.
 */
public class JavaPrimalityTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();
        in.close();
        if (n.isProbablePrime(1)) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
    }
}
