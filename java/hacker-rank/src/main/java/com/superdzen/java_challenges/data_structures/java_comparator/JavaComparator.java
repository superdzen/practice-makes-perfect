package com.superdzen.java_challenges.data_structures.java_comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 21.10.2017.
 * https://www.hackerrank.com/challenges/java-comparator
 */
public class JavaComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Player[] players = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            players[i] = new Player(scanner.next(), scanner.nextInt());
        }
        scanner.close();

        Arrays.sort(players, checker);

        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i].name + " " + players[i].score);
        }
    }
}

class Player {
    String name;
    int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        if (o1.score == o2.score) {
            return o1.name.compareTo(o2.name);
        } else {
            return o2.score - o1.score;
        }
    }
}