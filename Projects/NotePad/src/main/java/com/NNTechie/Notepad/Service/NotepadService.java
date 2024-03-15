package com.NNTechie.Notepad.Service;

import java.util.List;


import com.NNTechie.Notepad.Dto.UserRequest;
import com.NNTechie.Notepad.Dto.UserResponse;
import com.NNTechie.Notepad.Exceptions.UserDefinedException;

public interface NotepadService {
	
	public String createnote(UserRequest userRequest);
	
	public UserResponse getNotePad(String id) throws UserDefinedException;
	
	public List<UserResponse> listNotes();
	
	public UserResponse updateNotes(UserRequest notePad) throws UserDefinedException;
	
	public String deleteNote(String id) throws UserDefinedException;

}
