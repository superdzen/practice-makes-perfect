package com.superdzen.hibernate.demo.studentapp;


import com.superdzen.hibernate.demo.entity.student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            System.out.println("\n All students:");
            List<Student> studentList = session.createQuery("from Student").list();
            displayStudents(studentList);

            studentList = session.createQuery("from Student s " +
                    "where s.firstName='Daffy'").getResultList();
            System.out.println("\nStudent with name 'Daffy':");
            displayStudents(studentList);

            System.out.println("\nQuery with two conditions:");
            studentList = session.createQuery("from Student s " +
                    "where s.firstName='Daffy' OR s.lastName='LastName1'").list();
            displayStudents(studentList);

            System.out.println("\nQuery with LIKE:");
            studentList = session.createQuery("from Student s " +
                    "where s.lastName like 'LastName%'").list();
            displayStudents(studentList);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> studentList) {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
