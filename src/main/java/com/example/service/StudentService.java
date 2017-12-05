package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	//查询全部
	public List<Student> findAll() {
		List<Student> findAll = studentRepository.findAll();
		return findAll;
	}
	
	//插入数据
	public Student insertStudent(Student student) {
		Student saveAndFlush = studentRepository.saveAndFlush(student);
		return saveAndFlush;
	}
	
	//删除数据
	public String deleteStudent(String id) {
		Student student = studentRepository.findById(id);
		studentRepository.delete(student);
		return "学生信息删除成功！！";
		
	}
	
}
