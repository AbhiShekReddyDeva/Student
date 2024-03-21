package com.example.StudentManagement.controller;

import com.example.StudentManagement.dto.StudentDTO;
import com.example.StudentManagement.Model.Student;
import com.example.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addStudent(@RequestBody StudentDTO studentDto)
	{
		return  studentService.addStudent(studentDto);
	}
	
	@GetMapping("/get")
	public ResponseEntity<Student> getStudent(@RequestParam int rollNum)
	{
		Student student = studentService.getStudent(rollNum);
		if(student!=null)
		{
			return new ResponseEntity<Student>(student,HttpStatus.OK);
		}
		return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateStudent(@RequestBody StudentDTO studentDto)
	{
		return studentService.updateStudent(studentDto);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteStudent(@RequestParam int rollNum)
	{
		return studentService.deleteStudent(rollNum);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAllStudents()
	{
		return studentService.getAllStudents();
	}
}
