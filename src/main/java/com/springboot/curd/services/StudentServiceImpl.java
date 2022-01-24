package com.springboot.curd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.curd.dao.StudentDao;
import com.springboot.curd.entities.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	public boolean alreadyExist(long studend_id) {
		return studentDao.existsById(studend_id);
	}

	@Override
	public List<Student> getStudents() {
		return studentDao.findAll();
	}

	@Override
	public Optional<Student> getStudent(long student_id) {
		return studentDao.findById(student_id);
	}

	@Override
	public Student addStudent(Student student) {
		return studentDao.save(student);			
	}

	@Override
	public Student updateStudent(Student student) {
		Student existStud = studentDao.getById(student.getStudent_no());
		studentDao.delete(existStud);
		return studentDao.save(student);
		
	}
	
	public void deleteStudent(long student_id) {
		studentDao.deleteById(student_id);
	}

}
