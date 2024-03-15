package com.NNTechie.Notepad.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.NNTechie.Notepad.Dto.UserRequest;
import com.NNTechie.Notepad.Dto.UserResponse;
import com.NNTechie.Notepad.Exceptions.UserDefinedException;
import com.NNTechie.Notepad.Service.NotepadService;


@RestController
@RequestMapping("/notepad/note")
@CrossOrigin(origins = "http://localhost:3000/")
public class NotepadController {
	
	
	@Autowired
	private NotepadService notepadServiceImpl;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String saveNote(@RequestBody UserRequest userRequest) {
		userRequest.setId(UUID.randomUUID().toString().split("-")[0]);
		String createnote = notepadServiceImpl.createnote(userRequest);
		return createnote;
	}
	
	
	@GetMapping("/{id}")
	public UserResponse getNote(@PathVariable String id) throws UserDefinedException {
		UserResponse notePad = notepadServiceImpl.getNotePad(id);
		return notePad;
	}
	
	@GetMapping
	public List<UserResponse> listNotes(){
		List<UserResponse> listNotes = notepadServiceImpl.listNotes();
		return listNotes;
	}
	
	@PutMapping
	public UserResponse updateNote(@RequestBody UserRequest userRequest) throws UserDefinedException {
		UserResponse updateNotes = notepadServiceImpl.updateNotes(userRequest);
		return updateNotes;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public String deleteNote(@PathVariable String id) throws UserDefinedException {
		String deleteNote = notepadServiceImpl.deleteNote(id);
		return deleteNote;
	}

}
