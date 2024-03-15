package com.NNTechie.Notepad.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.NNTechie.Notepad.Entity.NotePad;

@Repository
public interface NotepadRepo extends MongoRepository<NotePad, String> {

}
