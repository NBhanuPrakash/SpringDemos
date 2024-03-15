package com.NNTechie.Notepad.BuilderMapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.NNTechie.Notepad.Dto.UserRequest;
import com.NNTechie.Notepad.Dto.UserResponse;
import com.NNTechie.Notepad.Entity.NotePad;

@Component
public class NotepadMapper {
	
	@Autowired
	ModelMapper modelMapper;
	
	public NotePad userRequest(UserRequest userRequest) {
		 return modelMapper.map(userRequest, NotePad.class);
	}
	
	public UserResponse userResponse(NotePad notePad) {
		return modelMapper.map(notePad, UserResponse.class);
	}
	
	public List<UserResponse> listUserResponse(List<NotePad> list){
		return modelMapper.map(list, new TypeToken<List<UserResponse>>() {}.getType());
	}

}
