package com.superdzen.hibernate.demo.onetooneapp;

import com.superdzen.hibernate.demo.entity.onetoone.Instructor;
import com.superdzen.hibernate.demo.entity.onetoone.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorDetailDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate_one_to_one.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();


        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            int id = 23;

            InstructorDetail tmpInstructorDetail =
                    session.get(InstructorDetail.class, id);

           // if (tmpInstructorDetail != null) {
                System.out.println("tmpInstructorDetail: " + tmpInstructorDetail);
                System.out.println("tmpInstrcutor: " + tmpInstructorDetail.getInstructor());
           // }

            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }


}
