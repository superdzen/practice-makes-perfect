package com.superdzen.hibernate.demo.eagervslazyapp;


import com.superdzen.hibernate.demo.entity.eagervslazy.Course;
import com.superdzen.hibernate.demo.entity.eagervslazy.Instructor;
import com.superdzen.hibernate.demo.entity.eagervslazy.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class EagerLazyDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate_one_to_many.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            // get the instructor from DB
            int id = 1;
            Instructor tmpInstructor = session.get(Instructor.class, id);

            System.out.println("Instructor: " + tmpInstructor);
            System.out.println("Calling Getter to load courses: " + tmpInstructor.getCourses());

            session.getTransaction().commit();
            session.close();
            System.out.println("Lazy-loaded Courses: " + tmpInstructor.getCourses());

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
