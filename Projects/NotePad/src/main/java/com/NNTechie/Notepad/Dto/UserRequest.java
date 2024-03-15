package com.NNTechie.Notepad.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

	private String id;
	
	private String title;

	private String data;

	private String date;

	private String time;
}
