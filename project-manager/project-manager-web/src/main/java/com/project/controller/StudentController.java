package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.pojo.Student;
import com.project.service.StudentService;

@Controller
public class StudentController {
	
	
	@Autowired
	private StudentService student;
	
	
	@ResponseBody
	@RequestMapping("/abc")
	public List<Student> get(){
		List<Student> list = student.ceshi();
		return list;
	}

}
