package com.RedisCache.Entity;


import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Student")
public class Student implements Serializable {
	

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int studentId;
	
	private String name;
	
	private String stdSubject;

}
