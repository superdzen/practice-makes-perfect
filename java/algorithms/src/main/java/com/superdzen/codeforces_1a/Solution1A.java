package com.superdzen.codeforces_1a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by superdzen@gmail.com on 01.07.2017.
 * Theatre Square in the capital city of Berland has a rectangular shape with the size n × m meters.
 * On the occasion of the city's anniversary, a decision was taken to pave the Square with square granite flagstones.
 * Each flagstone is of the size a × a.
 * What is the least number of flagstones needed to pave the Square?
 * It's allowed to cover the surface larger than the Theatre Square, but the Square has to be covered.
 * It's not allowed to break the flagstones. The sides of flagstones should be parallel to the sides of the Square.
 * Input:
 * The input contains string of three positive integer numbers in the first line: n,  m and a (1 ≤  n, m, a ≤ 10^9) separated by " ".
 * Example: 5 5 2
 * Output:
 * Write the needed number of flagstones.
 */
public class Solution1A {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = bufferedReader.readLine();

        //Splitting inout string to array:
        String[] stringAsArray = inputString.split("\\s+");

        //We need 3 numbers, checking:
        if (stringAsArray.length != 3) {
            System.out.println("Wrong count of elements");
            System.out.print("Wrong count of elements");
            return;
        }

        int lenOfSquare = Integer.parseInt(stringAsArray[0]);
        int widOfSquare = Integer.parseInt(stringAsArray[1]);
        int lenOfFlagstone = Integer.parseInt(stringAsArray[2]);

        //We need positive numbers, checking:
        if (lenOfFlagstone <= 0 || lenOfSquare <= 0 || widOfSquare <= 0) {
            System.out.println("Wrong input numbers");
            return;
        }

        /*
         * Input value is integer, but output can be long.
         * Example input: 1000000000 1000000000 1
         * output: 1000000000000000000
         * so we made output long to avoid integer overflow
         */
        long CountOfPlate;

        /*
         * There are 4 options:
         * if length of Square and length of Flagstone are multiple, width of Square and length of Flagstone are multiple
         * if length of Square and length of Flagstone are not multiple, width of Square and length of Flagstone are multiple
         * if length of Square and length of Flagstone are multiple, width of Square and length of Flagstone are not multiple
         * if length of Square and length of Flagstone are not multiple, width of Square and length of Flagstone are not multiple
         * if are not multiple we need add +1 to result of division
         */
        boolean isLenSquareMultipleLenPlate = lenOfSquare % lenOfFlagstone == 0;
        boolean isWidSquareMultipleLenPlate = widOfSquare % lenOfFlagstone == 0;
        long lenSquareDivLenPlate = lenOfSquare / lenOfFlagstone;
        long widSquareDivLenPlate = widOfSquare / lenOfFlagstone;

        if (isLenSquareMultipleLenPlate && isWidSquareMultipleLenPlate) {
            CountOfPlate = lenSquareDivLenPlate * widSquareDivLenPlate;
        } else if (!isLenSquareMultipleLenPlate && isWidSquareMultipleLenPlate) {
            CountOfPlate = (lenSquareDivLenPlate + 1) * widSquareDivLenPlate;
        }
        //in this cases it`s not necessary to check isWidSquareMultipleLenPlate
        else if (isLenSquareMultipleLenPlate) {
            CountOfPlate = lenSquareDivLenPlate * (widSquareDivLenPlate + 1);
        } else {
            CountOfPlate = (lenSquareDivLenPlate + 1) * (widSquareDivLenPlate + 1);
        }

        //Printing the result
        System.out.println(CountOfPlate);
    }
}