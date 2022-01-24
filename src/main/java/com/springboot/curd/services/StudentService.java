package com.springboot.curd.services;

import java.util.List;
import java.util.Optional;

import com.springboot.curd.entities.Student;

public interface StudentService {
	
	public List<Student> getStudents();
	
	public Optional<Student> getStudent(long student_id);

	public Student addStudent(Student student);
	
	public Student updateStudent(Student student);
	
	public void deleteStudent(long student_id);

	public boolean alreadyExist(long parseLong);
}
