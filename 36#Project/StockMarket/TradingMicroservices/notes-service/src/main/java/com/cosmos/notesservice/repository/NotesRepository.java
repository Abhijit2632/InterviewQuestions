package com.cosmos.notesservice.repository;

import com.cosmos.notesservice.document.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotesRepository extends MongoRepository<Note,String> {
    List<Note> findNotesByCompanyName(String companyName);
}
