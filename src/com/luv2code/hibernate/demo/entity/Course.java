package com.luv2code.hibernate.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="course")
public class Course {

    // define our fields

    // define constructors

    // define getter/setter

    // define toString

    // annotate fields

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    // a course has a many to one relationship
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="instructor_id")
    private Instructor instructor;

    public Course(){            // no-arg constructor

    }

    public Course(String title){         // arg const
        this.title = title;
    }

    // getter/setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course [" + "id=" + id + ", title='" + title + '\'' +']';
    }


}
