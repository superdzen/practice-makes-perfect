package com.superdzen.hibernate.demo.onetomanyapp;


import com.superdzen.hibernate.demo.entity.onetomany.Course;
import com.superdzen.hibernate.demo.entity.onetomany.Instructor;
import com.superdzen.hibernate.demo.entity.onetomany.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesDemo {

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

            Course tmpCourse1 = new Course("Air Guitar - The Ultimate Guide");
            Course tmpCourse2 = new Course("The Pinball Masterclass");

            tmpInstructor.add(tmpCourse1);
            tmpInstructor.add(tmpCourse2);

            session.save(tmpCourse1);
            session.save(tmpCourse2);

            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }


}
