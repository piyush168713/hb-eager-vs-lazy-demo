package com.luv2code.hibernate.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="instructor")
public class Instructor {

    // annotate the class as an entity and map to db table

    // define the fields

    // annotate the fields with db column names

    // *** setup mapping to InstructorDetail entity

    // create constructors

    // generate getter/setter methods

    // generate toString() methods

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @OneToOne(cascade=CascadeType.ALL)                  // relationship b/w instructor class and instructorDetail class.
    @JoinColumn(name="instructor_detail_id")
    private InstructorDetail instructorDetail;

    // instructor can have many courses, so we have to add a new entry for an instructor. we need some type of relationship.
    // refers to "instructor" property in "Course" class
    @OneToMany(fetch = FetchType.LAZY,
               mappedBy="instructor",
               cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Course> courses;

    // constructor defined
    public Instructor(){

    }

    public Instructor(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // getter/setter methods
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getlastName(){
        return lastName;
    }

    public void setlastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public InstructorDetail getInstructorDetail(){
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail){
        this.instructorDetail = instructorDetail;
    }

    @Override
    public String toString(){
        return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName +
                ", email=" + email + ", instructorDetail=" + instructorDetail + "]";
    }

    // added getter/setter
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // add convenience method for bi-directional relationship
    public void add(Course tempCourse){
        if (courses == null){
            courses = new ArrayList<>();
        }

        courses.add(tempCourse);      // add the courses to the list of courses

        tempCourse.setInstructor(this);         // setup bi-directional relationship ....like both meetup here and shaking hands
    }

}
