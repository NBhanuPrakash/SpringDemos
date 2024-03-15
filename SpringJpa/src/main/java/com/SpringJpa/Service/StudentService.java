package com.SpringJpa.Service;

import java.util.List;


import com.SpringJpa.Dto.Student;

public interface StudentService {
	
	public int createUser(Student student);
	
	public List<Student> listOfStudent();
	
	public Student getById(int id);
	
	public Student updateData(Student student, int id);
	
	public int deleteData(int id);
	
	

}
