package com.example.StudentManagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentManagement.Model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer>
{
	
	
}
