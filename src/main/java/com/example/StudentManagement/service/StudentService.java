package com.example.StudentManagement.service;

import com.example.StudentManagement.dto.StudentDTO;
import com.example.StudentManagement.Model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService
{
    ResponseEntity<String> addStudent(StudentDTO studentDto);
    Student getStudent(int rollNum);
    ResponseEntity<String> updateStudent(StudentDTO studentDto);
    ResponseEntity<String> deleteStudent(int rollNum);
    ResponseEntity<List<Student>> getAllStudents();

}



