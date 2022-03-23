package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
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

            // get the instructor detail object
            int theId = 7;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

            // print the instructor detail
            System.out.println("tempInstructorDetail: " + tempInstructorDetail);

            // print the associated instructor
            System.out.println("The associated instructor: " + tempInstructorDetail.getInstructor());

            // now let's delete the instructor detail
            System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);
            session.delete(tempInstructorDetail);


            // remove the associated object reference      // line 38-40 in InstructorDetail class
            // break bi-directional link  for delete only InstructorDetail

            //tempInstructorDetail.getInstructor().setInstantorDetail(null);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        catch (Exception exc){
            exc.printStackTrace();
        }
        finally{
            // handle connection leak issue
            session.close();

            factory.close();
        }
    }
}