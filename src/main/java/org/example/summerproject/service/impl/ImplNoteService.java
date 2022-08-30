package org.example.summerproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.summerproject.dto.note.NoteDto;
import org.example.summerproject.entity.Note;
import org.example.summerproject.repository.custom.CustomNoteRepository;
import org.example.summerproject.repository.jpa.NoteRepository;
import org.example.summerproject.service.NoteService;
import org.example.summerproject.service.mapper.NoteMapper;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImplNoteService implements NoteService {

    private final NoteRepository noteRepository;
    private final CustomNoteRepository customNoteRepository;
    private final NoteMapper noteMapper;

    @Override
    public NoteDto createNote(NoteDto noteDto) {
        validate(noteDto.getName());
        Note note = new Note(
                noteDto.getName(),
                noteDto.getText()
        );

        noteRepository.saveAndFlush(note);

        return noteMapper.mapNoteToNoteDto(note);
    }

    @Override
    public List<NoteDto> getAllNote() {
        List<Note> notes = noteRepository.findAll();
        return noteMapper.mapNoteToNoteDto(notes);
    }

    @Override
    public List<NoteDto> findAllNoteFromData() {
        return customNoteRepository.findAllNote();
    }

    @Override
    public NoteDto findNoteByName(String name) {
        Note note = noteRepository.findNoteByName(name)
                .orElseThrow();
        return noteMapper.mapNoteToNoteDto(note);
    }

    private void validate(String name) {
        if (noteRepository.existsNoteByName(name)) {
            throw new ValidationException("Пользователь уже существует!");
        }
    }
}
