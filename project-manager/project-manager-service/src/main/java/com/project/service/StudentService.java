package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mapper.StudentMapper;
import com.project.pojo.Student;
@Service
public class StudentService {
	@Autowired
	private StudentMapper student;


	public List<Student> ceshi() {
		List<Student> list = student.getDate();
		return list;
	}

}
