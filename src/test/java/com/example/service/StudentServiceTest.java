package com.example.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
	
	@Autowired
	StudentService studentService;

	@Test
	public void testFindAll() {
		List<Student> findAll = studentService.findAll();
		System.out.println(findAll);
	}
	
	@Test
	public void insertStudent() {
		Student student  = new Student("4","小东风","0","88");
		Student s = studentService.insertStudent(student);
		System.out.println(s);
	}
	
	@Test
	public void deleteStudent() {
		
		String str = studentService.deleteStudent("5");
		System.out.println(str);
		
	}
	
}
