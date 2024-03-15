package com.SpringJpa.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringJpa.DAO.StudentRepo;
import com.SpringJpa.Dto.Student;

@Service
public class StudentServiceIMPL implements StudentService {

	@Autowired
	StudentRepo studentRepo;

	// CRUD CREATE , READ, UPDATE ,DELETE

	@Override
	public Student createUser(Student student) {
		student.setStdId(UUID.randomUUID().toString().split("-")[0]);
		return studentRepo.save(student);
	}

	@Override
	public List<Student> listOfStudent() {
		return studentRepo.findAll();
	}

	@Override
	public Student getById(String id) {
		return studentRepo.findById(id).get();
	}

	@Override
	public List<Student> getByName(String srdname) {
		return studentRepo.findBySrdName(srdname);
	}

	@Override
	public List<Student> getByTotalMarks(int totalMarks) {
		return studentRepo.findByTotalMark(totalMarks);
	}

	@Override
	public Student updateStudent(Student student) {
		Student student2 = studentRepo.findById(student.getStdId()).get();
		if (student2!=null) {
			student2.setTotalmarks(student.getTotalmarks());
			student2.setStdSubject(student.getStdSubject());
		}
		return studentRepo.save(student2);
	}

	@Override
	public String deleteStudent(String id) {
		studentRepo.deleteById(id);
		return id+"Student Document Is Deleted";
	}

}
