package com.SpringJpa.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	
	private String stdName;
	
	private String stdSubject;
	
	private String totalMarks;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int studentId, String stdName, String stdSubject, String totalMarks) {
		super();
		this.studentId = studentId;
		this.stdName = stdName;
		this.stdSubject = stdSubject;
		this.totalMarks = totalMarks;
	}

	public int getStudentid() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getStdSubject() {
		return stdSubject;
	}

	public void setStdSubject(String stdSubject) {
		this.stdSubject = stdSubject;
	}

	public String getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(String totalMarks) {
		this.totalMarks = totalMarks;
	}
	

	
}
