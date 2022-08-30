package org.example.summerproject.service;

import org.example.summerproject.dto.note.NoteDto;

import java.util.List;

public interface NoteService {

    NoteDto createNote(NoteDto noteDTO);

    List<NoteDto> getAllNote();

    List<NoteDto> findAllNoteFromData();

    NoteDto findNoteByName(String name);
}
