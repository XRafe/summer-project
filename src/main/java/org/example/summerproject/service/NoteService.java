package org.example.summerproject.service;

import org.example.summerproject.dto.NoteDto;
import org.example.summerproject.entity.Note;

import java.util.List;

public interface NoteService {

    NoteDto createNote(NoteDto noteDTO);

    List<NoteDto> getAllNotes();

    Note findNoteByName(String name);
}
