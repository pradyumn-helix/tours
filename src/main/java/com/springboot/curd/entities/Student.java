package com.springboot.curd.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Student {

	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long student_no;

	@Column(length = 30)
	private String student_name;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate student_dob;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate student_doj;

//	Parameterize Constructor
	public Student(Long student_no, String student_name, LocalDate student_dob, LocalDate student_doj) {
		super();
		this.student_no = student_no;
		this.student_name = student_name;
		this.student_dob = student_dob;
		this.student_doj = student_doj;
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

	public LocalDate getStudent_dob() {
		return student_dob;
	}

	public void setStudent_dob(LocalDate student_dob) {
		this.student_dob = student_dob;
	}

	public LocalDate getStudent_doj() {
		return student_doj;
	}

	public void setStudent_doj(LocalDate student_doj) {
		this.student_doj = student_doj;
	}

	// Default Constructor
	public Student() {
		super();
	}

}
