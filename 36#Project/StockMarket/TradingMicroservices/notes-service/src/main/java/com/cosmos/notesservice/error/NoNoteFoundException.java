package com.cosmos.notesservice.error;

public class NoNoteFoundException extends RuntimeException{
    private String message;

    public NoNoteFoundException() {}

    public NoNoteFoundException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
