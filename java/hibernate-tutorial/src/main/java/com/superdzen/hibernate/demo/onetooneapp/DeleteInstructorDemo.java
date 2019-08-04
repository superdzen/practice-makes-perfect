package com.superdzen.hibernate.demo.onetooneapp;

import com.superdzen.hibernate.demo.entity.onetoone.Instructor;
import com.superdzen.hibernate.demo.entity.onetoone.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate_one_to_one.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();


        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            // get instructor by PK
            int id = 3;

            Instructor tmpInstructor = session.get(Instructor.class, id);

            // delete the instructor

            if (tmpInstructor != null) {
                System.out.println("Found instructor: " + tmpInstructor);
                System.out.println("Deleting...");
                session.delete(tmpInstructor);
            }

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }


}
