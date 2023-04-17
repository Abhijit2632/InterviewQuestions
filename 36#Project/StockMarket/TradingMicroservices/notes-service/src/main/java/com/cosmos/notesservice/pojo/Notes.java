package com.cosmos.notesservice.pojo;

import com.cosmos.notesservice.document.Note;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notes {
    private List<Note> notesList;
}
