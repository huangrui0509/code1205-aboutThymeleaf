package com.example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Serializable>{

	
	public Student findById(String id);
}
