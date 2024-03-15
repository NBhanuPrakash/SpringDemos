package com.RedisCache.Service;

import java.util.List;

import com.RedisCache.Dto.StudentDto;

public interface StudentService {

	public StudentDto createData(StudentDto stdeDto);
	
	public List<Object> listOfStudents();
	
	public StudentDto getStudent(int stdId);
	
	public StudentDto updateStd(StudentDto studentDto);
	
	public String deleteStd(int stdId);

	
}
