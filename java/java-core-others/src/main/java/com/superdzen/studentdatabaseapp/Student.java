package com.superdzen.studentdatabaseapp;

import java.util.Scanner;

/**
 * Created by superdzen@gmail.com on 22.05.2018.
 */
public class Student {

    private String firstName;
    private String lastName;
    private String studentID;
    private int gradeYear;
    private String courses = "";
    private int tuitionBalance;
    private static int costOfCourse = 600;
    private static int id = 10000;

    // Constructor: prompt user to enter student's name and year
    public Student() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter student first name: ");
        this.firstName = in.nextLine();

        System.out.print("Enter student last name: ");
        this.lastName = in.nextLine();

        System.out.print("1 - Freshman\n2 - for Sophmore\n3 - for a Junior\n4 - for Senior\nEnter student class level: ");
        this.gradeYear = in.nextInt();

        setStudentID();
    }

    // Generate a ID
    private void setStudentID() {
        // Grade level + static ID
        id++;
        this.studentID = gradeYear + "" + id;
    }

    // Enroll m courses
    public void enroll() {
        // Get inside the loop, user hits 0
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Enter course to enroll (Q to quit): ");
            String course = in.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n " + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            } else {
                break;
            }
        } while (true);
    }

    // View balance
    public void viewBalance() {
        System.out.println("Your balance is $" + tuitionBalance);
    }

    // Pay Tuition
    public void payTuition() {
        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }

    // Show status
    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName +
                "\nGrade Level: " + gradeYear +
                "\nID: " + studentID +
                "\nCourses Enrolled: " + courses +
                "\nBalance: " + tuitionBalance;
    }
}
