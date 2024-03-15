package com.RedisCache.ModelMappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RedisCache.Dto.StudentDto;
import com.RedisCache.Entity.Student;


@Component
public class ModelMappers {

	@Autowired
	private final ModelMapper modelMapper;

	public ModelMappers(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public Student DtoToEntity(StudentDto studentDto) {
		Student std = modelMapper.map(studentDto, Student.class);
		return std;
	}

	public StudentDto entityToDto(Student student) {
		StudentDto stdDto = modelMapper.map(student, StudentDto.class);
		return stdDto;
	}

}
