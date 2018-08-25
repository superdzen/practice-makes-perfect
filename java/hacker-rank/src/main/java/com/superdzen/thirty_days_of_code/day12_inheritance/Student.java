package com.superdzen.thirty_days_of_code.day12_inheritance;

/**
 * Created by superdzen@gmail.com on 04.07.2017.
 *
 */
public class Student extends Person {
    private int[] testScores;

    /*
    *   Class Constructor
    *
    *   @param firstName - A string denoting the Person's first name.
    *   @param lastName - A string denoting the Person's last name.
    *   @param id - An integer denoting the Person's ID number.
    *   @param scores - An array of integers denoting the Person's test scores.
    */

    Student(String firstName, String lastName, int id, int[] scores) {
        super(firstName, lastName, id);
        this.testScores = scores;
    }

    /*
    *   Method Name: calculate
    *   @return A character denoting the grade.
    */
    public char calculate() {
        int sum = 0;
        int length = this.testScores.length;
        for (int testScore : testScores) {
            sum += testScore;
        }

        int avg = sum / length;
        char ch = 0;
        if (avg < 40) {
            ch = 'T';
        } else if (avg >= 40 && avg < 55) {
            ch = 'D';
        } else if (avg >= 55 && avg < 70) {
            ch = 'P';
        } else if (avg >= 70 && avg < 80) {
            ch = 'A';
        } else if (avg >= 80 && avg < 90) {
            ch = 'E';
        } else if (avg >= 90 && avg <= 100) {
            ch = 'O';
        }
        return ch;
    }
}
