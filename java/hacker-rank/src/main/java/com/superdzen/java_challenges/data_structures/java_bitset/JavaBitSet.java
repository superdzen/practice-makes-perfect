package com.superdzen.java_challenges.data_structures.java_bitset;

import java.util.BitSet;
import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 22.10.2017.
 */
public class JavaBitSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        String command;

        while (m-- > 0) {
            command = scanner.next();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            switch (command) {
                case "AND":
                    if (x == 1) {
                        b1.and(b2);
                    } else {
                        b2.and(b1);
                    }
                    break;
                case "OR":
                    if (x == 1) {
                        b1.or(b2);
                    } else {
                        b2.or(b1);
                    }
                    break;
                case "XOR":
                    if (x == 1) {
                        b1.xor(b2);
                    } else {
                        b2.xor(b1);
                    }
                    break;
                case "FLIP":
                    if (x == 1) {
                        b1.flip(y);
                    } else {
                        b2.flip(y);
                    }
                    break;
                case "SET":
                    if (x == 1) {
                        b1.set(y);
                    } else {
                        b2.set(y);
                    }
                    break;
            }
            System.out.println(b1.cardinality() + " " + b2.cardinality());
        }
    }
}

