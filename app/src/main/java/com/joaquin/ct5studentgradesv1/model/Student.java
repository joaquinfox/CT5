package com.joaquin.ct5studentgradesv1.model;

import androidx.annotation.NonNull;

public class Student {
    private long id;
    private String firstName;
    private String lastName;
//    private String test;
    private double grade;

//    public Student(@NonNull String fName, @NonNull String lName, @NonNull double grade) {
    public Student(@NonNull String fName, @NonNull String lName, double grade){
        firstName = fName;
        lastName = lName;
        this.grade = grade;
//        this.test=test;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public String getText() {
//        return test;
//    }

    public String getFirstName() {
        return this.firstName;
    }
//
    public void setFirstName(String fName) {
        firstName = fName;
    }
//
    public String getLastName() {
        return this.lastName;
    }
//
    public void setLastName(String lName) {
        lastName = lName;
    }
    public double getGrade(){
        return this.grade;
    }
    public void setGrade(double grade){
        this.grade=grade;
    }
}
