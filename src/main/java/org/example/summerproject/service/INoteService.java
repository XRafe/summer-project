package org.example.summerproject.service;

import org.example.summerproject.dto.NoteDTO;
import org.example.summerproject.entity.Note;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface INoteService {

    NoteDTO createNote(NoteDTO noteDTO);

    List<NoteDTO> getAllNote();

    Set<NoteDTO> findAllNoteFromData() throws SQLException;

    Note findNoteByName(String name);
}
