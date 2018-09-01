package com.superdzen.hibernate.demo;


import com.superdzen.hibernate.demo.entity.student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int studentID = 3;

            // start a transaction
            session.beginTransaction();

            System.out.println("Getting student with ID=" + studentID);
            Student student = session.get(Student.class, studentID);

            System.out.println("Deleting student with ID=" + studentID);
            session.delete(student);

            studentID = 2;
            System.out.println("Deleting student with ID=" + studentID);
            session.createQuery("delete from Student where id=" + studentID)
                    .executeUpdate();

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
