package com.superdzen.hibernate.demo.studentapp;


import com.superdzen.hibernate.demo.entity.student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create a student object
            Student tmpStudent = new Student("Daffy", "Duck", "daffy@gmail.com");
            // start a transaction
            session.beginTransaction();
            // save the student object
            session.save(tmpStudent);
            // commit transaction
            session.getTransaction().commit();
            System.out.println("Temp Student object: " + tmpStudent);

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Getting object with id:" + tmpStudent.getId());
            Student newStudent = session.get(Student.class, tmpStudent.getId());
            session.getTransaction().commit();

            System.out.println("New Student object from DB: " + newStudent);

        } finally {
            factory.close();
        }
    }
}
