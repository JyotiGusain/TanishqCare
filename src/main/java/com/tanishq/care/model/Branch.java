package com.tanishq.care.model;

import javax.persistence.*;

@Entity
@Table(name = "branch")
public class Branch{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String course;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        course = course;
    }
}
