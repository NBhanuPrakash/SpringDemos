package com.SpringJpa.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringJpa.Dto.Student;
import com.SpringJpa.Repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepo studentRepo;

	@Override
	public int createUser(Student student) {
		studentRepo.save(student);
		return 0;
	}

	@Override
	public List<Student> listOfStudent() {
		List<Student> students = studentRepo.findAll();
		return students;
	}

	@Override
	public Student getById(int id) {
		Student student = studentRepo.findById(id).get();
		return student;
	}

	@Override
	public Student updateData(Student student, int id) {
		Optional<Student> student2 = studentRepo.findById(id);
		if (student2.isPresent()) {
			Student student3 = student2.get();
			student3.setStdName(student.getStdName());
			student3.setStdSubject(student.getStdSubject());
			student3.setTotalMarks(student.getTotalMarks());
			studentRepo.save(student3);
			
		}
		return student;
	}

	@Override
	public int deleteData(int id) {
		Optional<Student> findById = studentRepo.findById(id);
		if (findById!=null) {
			studentRepo.delete(findById.get());
		}
		return id;
	}

}
