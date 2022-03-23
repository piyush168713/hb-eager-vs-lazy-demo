// file 5 copy of GetInstructorCoursesDemo.java

package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
//import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
    public static void main(String[] args) {

        // Create Session factory
        SessionFactory factory = new Configuration()
                .configure("com/luv2code/jdbc/hibernate.cfg.xml")       // must specify the path of hibernate.cfg.xml file.
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)      // adding reference for new Course Class
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {

            // Start a transaction
            session.beginTransaction();

            // get a course
            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);

            // delete course
            System.out.println("Deleting Course: " + tempCourse);

            session.delete(tempCourse);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally{
            // add clean up code
            session.close();

            factory.close();
        }
    }
}