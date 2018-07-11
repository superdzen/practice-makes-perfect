package com.superdzen.java_challenges.data_structures.java_sort;

import java.util.*;

/**
 * Created by superdzen@gmail.com on 21.10.2017.
 * https://www.hackerrank.com/challenges/java-sort
 */
public class JavaSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();

        while (testCases > 0) {
            int id = scanner.nextInt();
            String name = scanner.next();
            double cgpa = scanner.nextDouble();
            students.add(new Student(id, name, cgpa));
            testCases--;
        }
        scanner.close();

        Collections.sort(students,
                Comparator.comparing(Student::getCgpa).reversed()
                        .thenComparing(Student::getName)
                        .thenComparing(Student::getId));
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}
