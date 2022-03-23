// file 6 copy of GetInstructorCoursesDemo.java

package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
//import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
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

            // get the instructor from db
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("luv2code: Instructor: " + tempInstructor);

            // get course for the Instructor
            System.out.println("luv2code: Courses: " + tempInstructor.getCourses());

            // commit transaction
            session.getTransaction().commit();


            // close the session
            session.close();

            System.out.println("\nluv2code: The session is now closed!\n");

            // Option 1: call getter method while session is open

            // get course for the Instructor
            System.out.println("luv2code: Courses: " + tempInstructor.getCourses());


            System.out.println("luv2code: Done!");

        }
        finally{
            // add clean up code
            session.close();

            factory.close();
        }
    }
}