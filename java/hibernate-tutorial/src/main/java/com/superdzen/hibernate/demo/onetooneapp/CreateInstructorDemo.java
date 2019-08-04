package com.superdzen.hibernate.demo.onetooneapp;

import com.superdzen.hibernate.demo.entity.onetoone.Instructor;
import com.superdzen.hibernate.demo.entity.onetoone.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate_one_to_one.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();


        Session session = sessionFactory.getCurrentSession();

        try {
            Instructor tempInstructor =
                    new Instructor("Den", "Kushnerik", "superdzen@gmail.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("http://www.superdzen.com", "Coding");

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            System.out.println("\nSaving instructor: " + tempInstructor);
            session.save(tempInstructor);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }


}
