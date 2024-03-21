package com.example.StudentManagement.dto;

import org.springframework.data.annotation.Id;

public class StudentDTO
{
    @Id
    private int rollNum;
    private String studentName;
    private int age;
    private String address;

    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }

    public int getRollNum() {
        return rollNum;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Student:{ studentName : "+this.studentName+" age : "+ this.age +" address : "+this.address +"}";
    }
}
