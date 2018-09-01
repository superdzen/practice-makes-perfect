package com.superdzen.hibernate.demo;

import com.superdzen.hibernate.demo.entity.student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        Student student1 = new Student("FirstName1", "LastName1", "name1@mail.ru");
        Student student2 = new Student("FirstName2", "LastName2", "name2@mail.ru");
        Student student3 = new Student("FirstName3", "LastName3", "name3@mail.ru");

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.getTransaction().commit();

    }
}
