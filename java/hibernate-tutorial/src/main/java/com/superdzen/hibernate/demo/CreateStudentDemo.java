package com.superdzen.hibernate.demo;


import com.superdzen.hibernate.demo.entity.student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
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
            Student student = new Student("Denis", "Kushnerik", "superdzen@gmail.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            session.save(student);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
