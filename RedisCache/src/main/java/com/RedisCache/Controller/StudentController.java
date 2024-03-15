package com.RedisCache.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RedisCache.Dto.StudentDto;
import com.RedisCache.Service.StudentService;

@RestController
@RequestMapping("std/std")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	@PostMapping
	public StudentDto studentDto(@RequestBody StudentDto studentDto) {
		StudentDto createData = studentService.createData(studentDto);
		return createData;
	}
	
	@GetMapping
	public List<Object> listOfStudents(){
		List<Object> listOfStudents = studentService.listOfStudents();
		return listOfStudents;
	}
	
	@GetMapping("/{studentId}")
	public StudentDto getStudent(@PathVariable int studentId) {
		StudentDto student = studentService.getStudent(studentId);
		return student;
	}
	
	@PutMapping
	public StudentDto updateStd(@RequestBody StudentDto std) {
		StudentDto updateStd = studentService.updateStd(std);
		return updateStd;
	}
	
	@DeleteMapping("/{stdId}")
	public String delete(@PathVariable int stdId) {
		return studentService.deleteStd(stdId);
	}
	
	
	

}
