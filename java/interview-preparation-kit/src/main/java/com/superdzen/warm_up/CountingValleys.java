package com.superdzen.warm_up;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {

    /*A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.*/
    private static int countingValleys(int n, String s) {
        int valleyInOutCount = 0;
        int currSeaLevel = 0;
        int lastSeaLevel = 0;

        for (char c : s.toCharArray()) {
            lastSeaLevel = currSeaLevel;
            if (c == 'D') {
                currSeaLevel--;
            } else if (c == 'U') {
                currSeaLevel++;
            }
            if ((lastSeaLevel == 0 && currSeaLevel < 0) || (lastSeaLevel < 0 && currSeaLevel == 0)) {
                valleyInOutCount++;
            }
        }
        return valleyInOutCount / 2;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}