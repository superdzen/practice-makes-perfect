package com.superdzen.studentdatabaseapp;

import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 22.05.2018.
 */
public class StudentDatabaseApp {
    public static void main(String[] args) {

        // Ask how many students we want to add
        System.out.print("Enter number of students to enroll: ");
        Scanner in = new Scanner(System.in);
        int numOfStudents = in.nextInt();
        Student[] students = new Student[numOfStudents];
        // Create m number of new students
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].enroll();
            students[i].payTuition();
        }

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
}
