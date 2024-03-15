package com.RedisCache.ServiceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RedisCache.Dto.StudentDto;
import com.RedisCache.Entity.Student;
import com.RedisCache.ModelMappers.ModelMappers;
import com.RedisCache.Repo.StudentRepo;
import com.RedisCache.Service.StudentService;

@Service
public class StudentServiceIMPL implements StudentService {

	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	ModelMappers modelMappers;

	@Override
	public StudentDto createData(StudentDto studentDto) {
		Student dtoToEntity = modelMappers.DtoToEntity(studentDto);
		Student std = studentRepo.save(dtoToEntity);
		StudentDto entityToDto = modelMappers.entityToDto(std);
		return entityToDto;
	}

	@Override
	public List<Object> listOfStudents() {
		List<Object> listOfStudent = studentRepo.listOfStudent();
		return listOfStudent;
	}

	@Override
	public StudentDto getStudent(int stdId) {
		Student student = studentRepo.getStudent(stdId);
		StudentDto entityToDto = modelMappers.entityToDto(student);
		return entityToDto;
	}

	@Override
	public StudentDto updateStd(StudentDto studentDto) {
		Student dtoToEntity = modelMappers.DtoToEntity(studentDto);
		Student updateStd = studentRepo.updateStd(dtoToEntity);
		StudentDto entityToDto = modelMappers.entityToDto(updateStd);
		return entityToDto;
	}

	@Override
	public String deleteStd(int stdId) {
		String deleteProduct = studentRepo.deleteProduct(stdId);
		return deleteProduct;
	}

}
