package com.luv2code.hibernate.demo.entity;


import javax.persistence.*;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

    // annotate the class as an entity and map to db table

    // define the fields

    // annotate the fields with db column names

    // create constructors

    // generate getter/setter methods

    // generate toString() methods

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;                                 // define the fields

    @Column(name="youtube_channel")
    private String youtubeChannel;

    @Column(name="hobby")
    private String hobby;

    // add new field for instructor (also add getter/setters)

    // add One-To-One annotation
    @OneToOne(mappedBy="instructorDetail", cascade = CascadeType.ALL)            // mapping will be same in both file        // used in all cases

    // use this for Delete only instructor detail
    //@OneToOne(mappedBy="instructorDetail", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})

    private Instructor instructor;

    public Instructor getInstructor(){
        return instructor;
    }

    public void setInstructor(Instructor instructor){
        this.instructor = instructor;
    }



    public InstructorDetail(){

    }
    public InstructorDetail(String youtubeChannel, String hobby){
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    // getter/setter methods

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getYoutubeChannel(){
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel){
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby(){
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString(){
        return "InstructorDetail [id= " + id + ", youtubeChannel= " + youtubeChannel + ", hobby= " + hobby + "]";
    }
}
