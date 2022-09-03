package com.example.Employee.model;

import java.time.LocalDate;

public class Employee
{
    private int Id;
    private String Name;

    private String Desigination;

    private LocalDate dob;

    private boolean major;



    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDesigination() {
        return Desigination;
    }

    public void setDesigination(String desigination) {
        Desigination = desigination;
    }


    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public boolean isMajor() {
        return major;
    }

    public void setMajor(boolean major) {
        this.major = major;
    }


}
