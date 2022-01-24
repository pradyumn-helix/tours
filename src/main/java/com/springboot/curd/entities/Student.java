package com.springboot.curd.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Student {
	
	@Id()
	private Long student_no;
	
	@Column(length = 30)
	private String student_name;
	
//	Parameterize Constructor
	public Student(Long student_no, String student_name) {
		super();
		this.student_no = student_no;
		this.student_name = student_name;
	}
	
//	Getters and Setters
	public Long getStudent_no() {
		return student_no;
	}
	public void setStudent_no(Long student_no) {
		this.student_no = student_no;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
//	Default Constructor
	public Student() {
		super();
	}
	
}
