package com.NNTechie.Notepad.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.NNTechie.Notepad.BuilderMapper.NotepadMapper;
import com.NNTechie.Notepad.Dto.UserRequest;
import com.NNTechie.Notepad.Dto.UserResponse;
import com.NNTechie.Notepad.Entity.NotePad;
import com.NNTechie.Notepad.Exceptions.UserDefinedException;
import com.NNTechie.Notepad.Repository.NotepadRepo;
import com.NNTechie.Notepad.Service.NotepadService;

import org.slf4j.*;

@Service
public class NotepadServiceImpl implements NotepadService {

	private static final Logger log = LoggerFactory.getLogger(NotepadServiceImpl.class);

	@Autowired
	private NotepadMapper notepadMapper;

	@Autowired
	private NotepadRepo notepadRepo;

	@Override
	public String createnote(UserRequest notePad) {
		NotePad userRequest = notepadMapper.userRequest(notePad);
		notepadRepo.save(userRequest);
		return "Created";
	}

	@Override
	@Cacheable(value = "UserResponse", key = "#id")
	public UserResponse getNotePad(String id) throws UserDefinedException {
		log.info("get notepad " + id);
		NotePad notePad = notepadRepo.findById(id).get();
		UserResponse userResponse = notepadMapper.userResponse(notePad);
		if (userResponse != null) {
			return userResponse;
		} else {
			throw new UserDefinedException("User is Not Found.." + id);
		}

	}

	@Override
	public List<UserResponse> listNotes() {
		List<NotePad> findAll = notepadRepo.findAll();
		List<UserResponse> listUserResponse = notepadMapper.listUserResponse(findAll);
		return listUserResponse;
	}

	@Override
	@CachePut(value = "UserResponse", key = "#result?.id")
	public UserResponse updateNotes(UserRequest notePad) throws UserDefinedException {
		NotePad notePad2 = notepadRepo.findById(notePad.getId())
				.orElseThrow(() -> new UserDefinedException("Note not found"));

// Update the entity
		notePad2.setData(notePad.getData());
		notepadRepo.save(notePad2);

// Log the update
		log.info("Updated Notepad with ID: {}", notePad2.getId());

// Return the response
		return notepadMapper.userResponse(notePad2);
	}

	@Override
	@CacheEvict(value = "UserResponse", key = "#id")
	public String deleteNote(String id) throws UserDefinedException {
		NotePad notePad = notepadRepo.findById(id).get();
		if (notePad != null) {
			notepadRepo.deleteById(id);
			log.info("Deleted Notepad  :" + id);
			return "Note Deleted";
		} else {
			throw new UserDefinedException("User is Not Found.." + id);
		}
	}

}
