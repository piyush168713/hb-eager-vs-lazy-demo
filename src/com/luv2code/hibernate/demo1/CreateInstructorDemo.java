// file 2 copy of CreateDemo.java

package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
//import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
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
            // create the objects
            Instructor tempInstructor = new Instructor("Kaushal", "Kumar", "kaushal.kumar@luv2code.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/opensource", "Video Games");

            // associate the objects
            System.out.println("Saving Instructor: " + tempInstructor);
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // Start a transaction
            session.beginTransaction();

            // save the instructor
            //
            // ** Note: this will ALSO save the details object because of CascadeType.ALL
            //
            session.save(tempInstructor);

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