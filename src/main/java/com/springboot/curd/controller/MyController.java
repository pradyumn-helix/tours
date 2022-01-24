package com.springboot.curd.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.curd.entities.Student;
import com.springboot.curd.services.StudentService;

@RestController
public class MyController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents() {
		try {
			return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/students/{student_id}")
	public ResponseEntity<Optional<Student>> getStudent(@PathVariable String student_id) {
		try {
			if(studentService.alreadyExist(Long.parseLong(student_id))==true) {
				Optional<Student> stud = studentService.getStudent(Long.parseLong(student_id));
				return new ResponseEntity<>(stud, HttpStatus.OK);				
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		try {
			return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);				
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PutMapping("/students")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student){
		try {
			if(studentService.alreadyExist(student.getStudent_no())==true) {
				return new ResponseEntity<>(studentService.updateStudent(student), HttpStatus.ACCEPTED);				
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/students/{student_id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable String student_id){
		try{
			if(studentService.alreadyExist(Long.parseLong(student_id))==true) {
				studentService.deleteStudent(Long.parseLong(student_id));
				return new ResponseEntity<>(HttpStatus.OK);				
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
