package com.joaquin.ct5studentgradesv1.model;

import androidx.annotation.NonNull;

public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private double grade;

    public Student(@NonNull String fName, @NonNull String lName, @NonNull double grade) {
        firstName = fName;
        lastName = lName;
        this.grade = grade;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String fName) {
        firstName = fName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lName) {
        lastName = lName;
    }
}
