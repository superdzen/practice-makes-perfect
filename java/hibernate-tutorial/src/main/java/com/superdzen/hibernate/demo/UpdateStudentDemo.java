package com.superdzen.hibernate.demo;


import com.superdzen.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UpdateStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int studentID = 1;

            // start a transaction
            session.beginTransaction();

            System.out.println("Getting student with ID=" + studentID);
            Student student = session.get(Student.class, studentID);

            System.out.println("Updating student with ID=" + studentID);
            student.setFirstName("Vasya");

            // commit transaction
            session.getTransaction().commit();


            // another updating
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nUpdate email for all students:");
            session.createQuery("update Student set email='foo@gmail.com'")
                    .executeUpdate();

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
