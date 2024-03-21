package com.example.StudentManagement.service.impl;

import com.example.StudentManagement.Model.Student;
import com.example.StudentManagement.dto.StudentDTO;
import com.example.StudentManagement.repository.StudentRepository;
import com.example.StudentManagement.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices implements StudentService {



    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public ResponseEntity<String> addStudent(StudentDTO studentDto) {

        notifyViaController(studentDto);
        Optional<Student> op1 = studentRepository.findById(studentDto.getRollNum());
        if (op1.isEmpty())
        {
            Student student = copy(studentDto);
            studentRepository.save(student);
            return new ResponseEntity<String>("Student added Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Student with roll number " + studentDto.getRollNum() + " already exist", HttpStatus.BAD_REQUEST);

    }

    @Override
    public Student getStudent(int rollNum) {

        Optional<Student> op1 = studentRepository.findById(rollNum);
        return op1.orElse(null);
    }

    @Override
    public ResponseEntity<String> updateStudent(StudentDTO studentDto) {

        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentRepository.save(student);
        return new ResponseEntity<String>("updated", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteStudent(int rollNum) {

        Student s = getStudent(rollNum);
        if (s != null) {
            studentRepository.deleteById(rollNum);
            return new ResponseEntity<String>("Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Student with roll number " + rollNum + " does not exist", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Student>> getAllStudents() {

        List<Student> l = studentRepository.findAll();
        return new ResponseEntity<List<Student>>(l, HttpStatus.OK);
    }

    public void notifyViaController(StudentDTO studentDto)
    {
        String apiUrl = "http://localhost:8080/notification/send";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<StudentDTO> requestEntity = new HttpEntity<>(studentDto,headers);
        restTemplate.postForObject(apiUrl,requestEntity,Void.class);
    }
    public Student copy(StudentDTO studentDto)
    {
        Student student = new Student();
        student.setStudentName(studentDto.getStudentName());
        student.setAge(studentDto.getAge());
        student.setRollNum(studentDto.getRollNum());
        student.setAddress(studentDto.getAddress());
        return student;
    }

}
