package com.SpringJpa.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringJpa.Dto.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}
