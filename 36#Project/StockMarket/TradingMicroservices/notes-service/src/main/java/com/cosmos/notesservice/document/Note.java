package com.cosmos.notesservice.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "notes003")
public class Note {
    @Id
    private String noteId;
    private String companyName;
    private String noteDescription;
    private LocalDateTime noteTakenTime;

}
