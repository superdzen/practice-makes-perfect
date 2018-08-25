package com.superdzen.cube_summation;


import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 05.07.2017.
 * https://www.hackerrank.com/challenges/cube-summation
 * *This is not optimal solution. We need to rewrite the code to Fenwick tree. And add some comments.
 * <p>
 * You are given a 3-D Matrix in which each block contains 0 initially.
 * The first block is defined by the coordinate (1,1,1) and the last block is defined by the coordinate (N,N,N).
 * <p>
 * There are two types of queries.
 * UPDATE x y z W
 * updates the value of block (x,y,z) to W.
 * QUERY x1 y1 z1 x2 y2 z2
 * calculates the sum of the value of blocks whose x coordinate is between x1 and x2 (inclusive),
 * y coordinate between y1 and y2 (inclusive) and z coordinate between z1 and z2 (inclusive).
 */
public class CubeSummation {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            CubeInt cubeInt = new CubeInt(N);
            scanner.nextLine();
            String inputString;
            for (int j = 0; j < M; j++) {
                inputString = scanner.nextLine();
                String[] stringAsArray = inputString.split("\\s+");
                if (stringAsArray[0].equals("UPDATE")) {
                    int x = Integer.parseInt(stringAsArray[1]) - 1;
                    int y = Integer.parseInt(stringAsArray[2]) - 1;
                    int z = Integer.parseInt(stringAsArray[3]) - 1;
                    int val = Integer.parseInt(stringAsArray[4]);
                    cubeInt.setValueOfBlock(x, y, z, val);
                }
                if (stringAsArray[0].equals("QUERY")) {
                    int x1 = Integer.parseInt(stringAsArray[1]) - 1;
                    int y1 = Integer.parseInt(stringAsArray[2]) - 1;
                    int z1 = Integer.parseInt(stringAsArray[3]) - 1;
                    int x2 = Integer.parseInt(stringAsArray[4]) - 1;
                    int y2 = Integer.parseInt(stringAsArray[5]) - 1;
                    int z2 = Integer.parseInt(stringAsArray[6]) - 1;
                    cubeInt.getSummaryOfBlocks(x1, y1, z1, x2, y2, z2);
                }
            }
        }
        scanner.close();
    }
}

