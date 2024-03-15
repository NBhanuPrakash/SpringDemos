package com.SpringJpa.DAO;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.SpringJpa.Dto.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student, String> {

	List<Student> findBySrdName(String srdname);
	
	@Query("{totalmarks:?0}")
	List<Student> findByTotalMark(int totlMarsk);
	
	
}
