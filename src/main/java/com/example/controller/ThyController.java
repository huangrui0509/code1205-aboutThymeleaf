package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Student;
import com.example.domain.User;
import com.example.service.StudentService;

@Controller
public class ThyController {
	
	@Autowired
	StudentService studentService;
	
		
	
	/*
	@RequestMapping("/test1")
	public String testSession(HttpServletRequest req) {
	
		HttpSession session = req.getSession();
		session.setAttribute("str", "jiujiujiu");
		
		return "test1";
		
	}
	
	
	//生成一个list集合，使用model传值，前台页面使用thymeleaf获取list
	@RequestMapping("/testList")
	public String testList(Model model) {
		List<User> userList = new ArrayList();
		for(int i=1;i<10;i++) {
			User u = new User(i+"","user"+i,"9"+i);
			userList.add(u);
		}
		model.addAttribute("userList", userList);
		
		return "test2";
	
	}
	
	
	//测试th:if
	@RequestMapping("/test3")
	public String test3(Model model) {
		List<User> userList = new ArrayList();
		for(int i=1;i<10;i++) {
			User u = new User(i+"","user"+i,"9"+i);
			userList.add(u);
		}
		model.addAttribute("userList", userList);
		model.addAttribute("result", "true");
		return "test3";
		
	}
*/	
		
	//获取数据库中student信息
	@RequestMapping("/testStu")
	public String testStu(Model model) {
		List<Student> findAll = studentService.findAll();
		model.addAttribute("stuList", findAll);
		
		return "test4";
	
	}
	//跳转add.html
	@RequestMapping("/add")
	public String toInsertStu(Model model) {
		
		return "add";
	
	}
	//保存Student
	@RequestMapping("/saveStu")
	public String saveStu(String id,String name,String gender,String score,Model model) {
		if(id!=null) {
			
			Student stu = new Student(id,name,gender,score);
			studentService.insertStudent(stu);
			
		}
		List<Student> findAll = studentService.findAll();
		model.addAttribute("stuList", findAll);
		

		return "test4";
	
	}
	
	//通过返回的id获取student
	//跳转getSTU页面
	@RequestMapping("/getStu")
	public String togetStu(String id,Model model) {
		//System.out.println("---------------------"+stuList);
		
		
		List<Student> stuList = studentService.findAll();
		for (Student student : stuList) {
			if("0".equals(id)) {
				Student s = new Student("","","","");
				model.addAttribute("stu", s);
				
			}else if(id.equals(student.getId())) {
				model.addAttribute("stu", student);
				System.out.println(student);
			}
		}
		return "getstu";
	
	}
	
	//通过id删除student信息
	@RequestMapping("/delStu")
	public String delStu(String id,Model model) {
		System.out.println("------------ -----------------"+id);
		studentService.deleteStudent(id);
		List<Student> findAll = studentService.findAll();
		model.addAttribute("stuList", findAll);
		return "test4";
		
	}
	
	
	
}
