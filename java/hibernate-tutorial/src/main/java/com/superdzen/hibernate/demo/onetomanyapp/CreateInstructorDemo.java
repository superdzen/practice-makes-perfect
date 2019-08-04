package com.superdzen.hibernate.demo.onetomanyapp;


import com.superdzen.hibernate.demo.entity.onetomany.Course;
import com.superdzen.hibernate.demo.entity.onetomany.Instructor;
import com.superdzen.hibernate.demo.entity.onetomany.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate_one_to_many.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            Instructor tmpInstructor =
                    new Instructor("Susan", "Public", "susanin@mail.ru");

            InstructorDetail tmpInstructorDetail =
                    new InstructorDetail("http://ya.ru", "Gaming");

            tmpInstructor.setInstructorDetail(tmpInstructorDetail);

            session.beginTransaction();

            session.save(tmpInstructor);

            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }


}
