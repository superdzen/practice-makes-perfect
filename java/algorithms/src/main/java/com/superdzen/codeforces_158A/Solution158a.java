package com.superdzen.codeforces_158A;

import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 19.11.2017.
 * http://codeforces.com/problemset/problem/158/A
 * «Участник выходит в следующий раунд соревнований, если он набрал не меньше баллов, чем участник, занявший k-е место,
 * при условии, что набранное им число баллов строго положительно...» — выдержка из правил соревнований.
 * <p>
 * Всего в соревновании было n участников (n ≥ k), и вам уже известны их баллы.
 * Определите, сколько участников выйдет в следующий раунд.
 */
public class Solution158a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int playersCount = scanner.nextInt();
        int place_k = scanner.nextInt();
        int[] scoreArray = new int[playersCount];

        for (int i = 0; i < playersCount; i++) {
            scoreArray[i] = scanner.nextInt();
        }

        int point_k = scoreArray[place_k - 1];

        int participantCount;
        int startIdx;

        if (point_k == 0) {
            participantCount = 0;
            startIdx = 0;
        } else {
            participantCount = place_k - 1;
            startIdx = place_k - 1;
        }

        for (int i = startIdx; i < scoreArray.length; i++) {
            if (scoreArray[i] >= point_k && scoreArray[i] != 0) {
                participantCount++;
            } else {
                break;
            }
        }
        System.out.println(participantCount);
    }
}
