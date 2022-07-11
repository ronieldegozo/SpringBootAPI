package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.*;

@Entity
@Table

public class Student {
    @Id
    @SequenceGenerator(name = "student_seq", sequenceName = "student_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    private Long id;
    private String fname;
    private String lname;
    private LocalDate dov;
    private String email;

    @Transient
    private Integer age;

    public Integer getAge() {
        return Period.between(dov, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public LocalDate getDov() {
        return this.dov;
    }

    public void setDov(LocalDate dov) {
        this.dov = dov;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Student() {
    }

    public Student(String fname, String lname, LocalDate dov, String email) {
        this.fname = fname;
        this.lname = lname;
        this.dov = dov;
        this.email = email;
    }

    public Student(Long id, String fname, String lname, LocalDate dov, String email) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.dov = dov;
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", fname='" + getFname() + "'" +
                ", lname='" + getLname() + "'" +
                ", age='" + getAge() + "'" +
                ", dov='" + getDov() + "'" +
                ", email='" + getEmail() + "'" +
                "}";
    }

}
