package com.superdzen.hibernate.demo.onetomanyapp;


import com.superdzen.hibernate.demo.entity.onetomany.Course;
import com.superdzen.hibernate.demo.entity.onetomany.Instructor;
import com.superdzen.hibernate.demo.entity.onetomany.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorCoursesDemo {

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

            System.out.println("Courses: " + tmpInstructor.getCourses());

            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }


}
