package com.NNTechie.Notepad;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotepadConfig {
	
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
