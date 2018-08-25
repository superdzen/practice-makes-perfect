package com.superdzen.java_challenges.data_structures.java_1D_array_part2;

import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 19.09.2017.
 * https://www.hackerrank.com/challenges/java-1d-array/problem
 * This is implementation of depth-first search (DFS).
 */
public class Java1DArrayPart2 {
    public static boolean canWin(int leap, int[] game, int i) {
        if (i < 0 || game[i] == 1) {
            return false;
        } else if (i + 1 >= game.length || i + leap >= game.length) {
            return true;
        }
        game[i] = 1;
        return canWin(leap, game, i + leap) ||
                canWin(leap, game, i + 1) ||
                canWin(leap, game, i - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game, 0)) ? "YES" : "NO");
        }
        scan.close();
    }
}
