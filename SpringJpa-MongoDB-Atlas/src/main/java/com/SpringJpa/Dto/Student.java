package com.SpringJpa.Dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "studentsdetails")

public class Student {
	
	@Id
	private String stdId;
	
	private String srdName;
	
	private String stdSubject;
	
	private int totalmarks;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String stdId, String srdName, String stdSubject, int totalmarks) {
		super();
		this.stdId = stdId;
		this.srdName = srdName;
		this.stdSubject = stdSubject;
		this.totalmarks = totalmarks;
	}

	public String getStdId() {
		return stdId;
	}

	public void setStdId(String string) {
		this.stdId = string;
	}

	public String getSrdName() {
		return srdName;
	}

	public void setSrdName(String srdName) {
		this.srdName = srdName;
	}

	public String getStdSubject() {
		return stdSubject;
	}

	public void setStdSubject(String stdSubject) {
		this.stdSubject = stdSubject;
	}

	public int getTotalmarks() {
		return totalmarks;
	}

	public void setTotalmarks(int totalmarks) {
		this.totalmarks = totalmarks;
	}
	
	

}
