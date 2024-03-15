package com.SpringJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringJpa.Dto.Student;
import com.SpringJpa.Service.StudentServiceImpl;

@RestController
public class StudentController {

	@Autowired
	StudentServiceImpl studentServiceImpl;

	@PostMapping("/saveData")
	public Student createStudent(@RequestBody Student student) {
		studentServiceImpl.createUser(student);
		return student;
	}

	@GetMapping("/getData")
	public List<Student> getStudents() {
		List<Student> listOfStudent = studentServiceImpl.listOfStudent();
		return listOfStudent;
	}

}
