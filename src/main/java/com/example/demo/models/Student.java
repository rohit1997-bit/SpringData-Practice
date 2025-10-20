package com.example.demo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long StudentID;

    @Embedded
    Person person;

    @CreationTimestamp
    LocalDateTime createDateTime;

    @UpdateTimestamp
    LocalDateTime updateDate;

    @ManyToMany(cascade ={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Student_Course", joinColumns = @JoinColumn(name = "Student_ID" , referencedColumnName = "StudentID")
     , inverseJoinColumns = @JoinColumn (name = "course_Id", referencedColumnName ="courseId"))
    List<Courses> courses = new ArrayList<>();

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getStudentID() {
        return StudentID;
    }

    public void setStudentID(Long studentID) {
        StudentID = studentID;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    public void addCourse(Courses course) {
        if (course != null) {
            this.courses.add(course);
            course.student.add(this);
        }
    }



}
