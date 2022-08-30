package org.example.summerproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.summerproject.dto.NoteDTO;
import org.example.summerproject.entity.Note;
import org.example.summerproject.repository.Data;
import org.example.summerproject.repository.NoteRepository;
import org.example.summerproject.service.NoteService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    private final Data data;

    @Override
    public NoteDTO createNote(NoteDTO noteDTO) {
        Note note = new Note();
        note.setName(noteDTO.getName());
        note.setText(noteDTO.getText());

        noteRepository.saveAndFlush(note);

        return mapNoteToNoteDto(note);
    }

    @Override
    public List<NoteDTO> getAllNote() {
        List<Note> notes = noteRepository.findAll();
        return mapNoteToNoteDto(notes);
    }

    @Override
    public Set<NoteDTO> findAllNoteFromData() throws SQLException {
        return data.findAllNote();
    }

    @Override
    public Note findNoteByName(String name) {
        return noteRepository.findNoteByName(name);
    }

    public NoteDTO mapNoteToNoteDto(Note note) {
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setName(note.getName());
        noteDTO.setText(note.getText());
        return noteDTO;
    }

    public List<NoteDTO> mapNoteToNoteDto(Collection<Note> notes) {
        return notes.stream()
                .map(n -> new NoteDTO(
                        n.getName(),
                        n.getText())).toList();
    }
}
