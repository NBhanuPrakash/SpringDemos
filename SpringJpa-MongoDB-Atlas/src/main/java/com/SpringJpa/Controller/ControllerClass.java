package com.SpringJpa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.SpringJpa.Dto.Student;
import com.SpringJpa.Service.StudentServiceIMPL;

@RestController
@RequestMapping("/mongoData")
public class ControllerClass {

	@Autowired
	StudentServiceIMPL studentService;

	@PostMapping("/saveData")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Student createDocument(@RequestBody Student student) {
		return studentService.createUser(student);
	}
	
	
	@GetMapping
	public List<Student> getStudents(){
		return studentService.listOfStudent();
	}
	
	
	@GetMapping("/{stdId}")
	public Student getByStudentId(@PathVariable String stdId) {
		return studentService.getById(stdId);
	}
	
	
	@GetMapping("/name/{stdName}")
	public List<Student> findByName(@PathVariable String stdName){
		return studentService.getByName(stdName);
	}
	
	@GetMapping("/marks/{marks}")
	public List<Student> getByTotalMarks(@PathVariable int marks){
		return studentService.getByTotalMarks(marks);
	}
	
	
	@PutMapping
	public Student updateTask(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("/{stdid}")
	public String deleteStudent(@PathVariable String stdid) {
		return studentService.deleteStudent(stdid);
	}
	
	

}
