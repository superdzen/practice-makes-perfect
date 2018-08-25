package com.superdzen.cube_summation;

/**
 * Created by superdzen@gmail.com on 05.07.2017.
 */
public class CubeInt {
    private int sizeOfCube;
    private int[][][] valuesOfBlocks;

    CubeInt(int n) {
        sizeOfCube = n;
        valuesOfBlocks = new int[sizeOfCube][sizeOfCube][sizeOfCube];
    }

    public int getSizeOfCube() {
        return sizeOfCube;
    }

    public int getValueOfBlock(int x, int y, int z) {
        return this.valuesOfBlocks[x][y][z];
    }

    void printOut() {
        for (int i = 0; i < sizeOfCube; i++) {
            for (int j = 0; j < sizeOfCube; j++) {
                for (int k = 0; k < sizeOfCube; k++) {
                    System.out.print(valuesOfBlocks[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public void setValueOfBlock(int x, int y, int z, int val) {
        this.valuesOfBlocks[x][y][z] = val;
    }

    public void getSummaryOfBlocks(int x1, int y1, int z1, int x2, int y2, int z2) {
        long sum = 0;
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                for (int k = z1; k <= z2; k++) {
                    sum += getValueOfBlock(i, j, k);
                }
            }
        }
        System.out.println(sum);
    }
}
