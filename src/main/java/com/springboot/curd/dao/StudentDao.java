package com.springboot.curd.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.curd.entities.Student;

public interface StudentDao extends JpaRepository<Student, Long>{

}
