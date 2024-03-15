package com.SpringJpa.Service;

import java.util.List;


import com.SpringJpa.Dto.Student;

public interface StudentService {

	public Student createUser(Student student);
	
	public List<Student> listOfStudent();
	
	public Student getById(String id);
	
	public List<Student> getByName(String stdname);
	
	public List<Student> getByTotalMarks(int totalMarks);
	
	public Student updateStudent(Student student);
	
	public String deleteStudent(String id);
	
}
