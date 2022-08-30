package org.example.summerproject.exception;

public class NoteAlreadyExistsException extends RuntimeException {

    private static final String EX_MSG_TMPL = "Note with name %s already exists";

    public NoteAlreadyExistsException(String noteName) {
        super(String.format(EX_MSG_TMPL, noteName));
    }
}
