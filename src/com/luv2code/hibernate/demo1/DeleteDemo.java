package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
//import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {

        // Create Session factory
        SessionFactory factory = new Configuration()
                .configure("com/luv2code/jdbc/hibernate.cfg.xml")       // must specify the path of hibernate.cfg.xml file.
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Start a transaction
            session.beginTransaction();

            // get instructor by primary key/id
            int theId = 5;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("Found Instructor: " + tempInstructor);

            // delete the instructors
            if (tempInstructor != null){
                System.out.println("Deleting: " + tempInstructor);

                // Note: will also delete associated "details" objects because of CascadeType.ALL
                session.delete(tempInstructor);
            }

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally{
            factory.close();
        }
    }
}