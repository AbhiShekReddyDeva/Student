package com.example.StudentManagement.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Student")
public class Student {

    private int rollNum;
    private String studentName;
    private int age;
    private String address;

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }

    public int getRollNum() {
        return rollNum;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
