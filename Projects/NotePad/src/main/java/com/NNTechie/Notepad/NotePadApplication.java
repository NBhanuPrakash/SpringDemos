package com.NNTechie.Notepad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class NotePadApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotePadApplication.class, args);
	}

}
