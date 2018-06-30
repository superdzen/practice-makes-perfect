package com.superdzen.ctci_ransom_note;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 25.10.2017.
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 * Given the words in the magazine and the words in the ransom note,
 * print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.
 * <p>
 * For example, the note is "Attack at dawn". The magazine contains only "attack at dawn".
 * The magazine has all the right words, but there's a case mismatch. The answer is No.
 */
public class HashTablesRansomNote {
    private Map<String, Integer> magazineMap;
    private Map<String, Integer> noteMap;

    private HashTablesRansomNote(String magazine, String note) {

        magazineMap = new HashMap<>();
        noteMap = new HashMap<>();
        String[] magString = magazine.split(" ");
        String[] noteString = note.split(" ");

        for (String magS : magString) {
            int wordCount = 1;
            if (magazineMap.containsKey(magS)) {
                wordCount = magazineMap.get(magS);
                wordCount++;
                magazineMap.put(magS, wordCount);
            } else {
                magazineMap.put(magS, wordCount);
            }
        }

        for (String noteS : noteString) {
            int wordCount = 1;
            if (noteMap.containsKey(noteS)) {
                wordCount = noteMap.get(noteS);
                wordCount++;
                noteMap.put(noteS, wordCount);
            } else {
                noteMap.put(noteS, wordCount);
            }
        }

    }

    private boolean solve() {
        boolean canRepl = true;
        for (String key : noteMap.keySet()) {
            if (magazineMap.containsKey(key)) {
                if (magazineMap.get(key) < noteMap.get(key)) {
                    canRepl = false;
                }
            } else {
                canRepl = false;
            }
        }
        return canRepl;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        scanner.nextLine();
        HashTablesRansomNote hashTablesRansomNote = new HashTablesRansomNote(scanner.nextLine(), scanner.nextLine());

        boolean answer = hashTablesRansomNote.solve();
        if (answer) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
