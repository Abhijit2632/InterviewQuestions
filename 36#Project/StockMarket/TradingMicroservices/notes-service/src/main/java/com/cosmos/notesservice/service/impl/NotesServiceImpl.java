package com.cosmos.notesservice.service.impl;

import com.cosmos.notesservice.document.Note;
import com.cosmos.notesservice.error.NoNoteFoundException;
import com.cosmos.notesservice.pojo.Notes;
import com.cosmos.notesservice.repository.NotesRepository;
import com.cosmos.notesservice.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class NotesServiceImpl implements NotesService {
    @Autowired
    private NotesRepository notesRepository;
    @Override
    public Notes getAllNotes() {
        return new Notes(notesRepository.findAll());
    }

    @Override
    public Notes getNotesBasedOnCompanyName(String companyName) {
        return new Notes(notesRepository.findNotesByCompanyName(companyName));
    }

    @Override
    public Note saveNote(Note note) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        note.setNoteTakenTime(now);
        return notesRepository.save(note);
    }

    @Override
    public Note getNote(String noteId) {
        return notesRepository.findById(noteId).orElseThrow(
                ()-> new NoNoteFoundException("No Note Found with id : "+noteId)
        );
    }

    @Override
    public ResponseEntity updateNote(Long noteId, Note note) {
        return null;
    }

    @Override
    public ResponseEntity deleteNote(Long noteId) {
        return null;
    }
}
