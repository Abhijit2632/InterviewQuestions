package com.cosmos.notesservice.controller;

import com.cosmos.notesservice.document.Note;
import com.cosmos.notesservice.pojo.Notes;
import com.cosmos.notesservice.service.NotesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
@Slf4j
public class NotesController {
    @Autowired
    private NotesService notesService;
    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public Note saveNote(@RequestBody Note note){
        log.info("Save Notes got called"+note);
        return notesService.saveNote(note);
    }
    @GetMapping
    public Notes getAllNotes(){
        return notesService.getAllNotes();
    }
    @GetMapping("/bycompany/{companyName}")
    public Notes getAllNotesByCompanyName(@PathVariable String companyName){
        return notesService.getNotesBasedOnCompanyName(companyName);
    }
    @GetMapping("/dummy")
    public Note saveDummyNote(){
        Note note = new Note();
        note.setCompanyName("RELIANCE");
        note.setNoteDescription("NA");
        return notesService.saveNote(note);
    }
}
