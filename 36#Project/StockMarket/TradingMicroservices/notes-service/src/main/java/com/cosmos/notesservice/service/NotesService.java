package com.cosmos.notesservice.service;

import com.cosmos.notesservice.document.Note;
import com.cosmos.notesservice.pojo.Notes;
import org.springframework.http.ResponseEntity;

public interface NotesService {
    public Notes getAllNotes();
    public Notes getNotesBasedOnCompanyName(String companyName);
    public Note saveNote(Note note);
    public Note getNote(String noteId);
    public ResponseEntity updateNote(Long noteId,Note note);
    public ResponseEntity deleteNote(Long noteId);

}
