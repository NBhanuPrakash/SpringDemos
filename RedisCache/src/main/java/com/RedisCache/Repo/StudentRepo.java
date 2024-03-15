package com.RedisCache.Repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Repository;

import com.RedisCache.Entity.Student;

@Repository
@EnableRedisRepositories
public class StudentRepo {
	
	private final String HASH_KEY = "Student";
	
	@Autowired
	private RedisTemplate<String, Student> template;
	
	public Student save(Student student) {
		template.opsForHash().put(HASH_KEY, student.getStudentId(), student);
		return student;
	}
	
	public List<Object> listOfStudent(){
		return template.opsForHash().values(HASH_KEY);
	}
	
	public Student getStudent(int stdId) {
		return (Student) template.opsForHash().get(HASH_KEY, stdId);
	}
	
	public String deleteProduct(int id) {
		template.opsForHash().delete(HASH_KEY, id);
		return "Done";
	}
	
	public Student updateStd(Student student) {
		Object stdId = template.opsForHash().get(HASH_KEY, student.getStudentId());
		if(stdId!=null) {
			template.opsForHash().put(HASH_KEY, student.getStudentId(), student);
			return student;
		}else {
			return null;
		}
		
	}

}
