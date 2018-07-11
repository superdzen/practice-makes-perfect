package com.superdzen.java_challenges.advanced.java_md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 24.10.2017.
 * https://www.hackerrank.com/challenges/java-md5
 */
public class JavaMD5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());

            byte[] digest = md.digest();
            StringBuilder stringBuilder = new StringBuilder();

            for (byte b : digest) {
                stringBuilder.append(String.format("%02x", b & 0xff));
            }

            System.out.println(stringBuilder.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }
}
