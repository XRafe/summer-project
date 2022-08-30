package org.example.summerproject.service.ImplService;

import lombok.RequiredArgsConstructor;
import org.example.summerproject.dto.NoteDto;
import org.example.summerproject.entity.Note;
import org.example.summerproject.exception.NoteAlreadyExistsException;
import org.example.summerproject.mapper.NoteMapper;
import org.example.summerproject.repository.NoteRepository;
import org.example.summerproject.service.NoteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    private final NoteMapper noteMapper;

    @Transactional
    @Override
    public NoteDto createNote(NoteDto requestBody) {
        if (noteRepository.existsNoteByName(requestBody.getName())) {
            throw new NoteAlreadyExistsException(requestBody.getName());
        }

        Note note = new Note();
        note.setName(requestBody.getName());
        note.setText(requestBody.getText());

        noteRepository.saveAndFlush(note);

        return noteMapper.toNoteDto(note);
    }

    @Override
    public List<NoteDto> getAllNotes() {
        List<Note> notes = noteRepository.findAll();
        return noteMapper.toNoteDtos(notes);
    }

    @Override
    public Note findNoteByName(String name) {
        return noteRepository.findNoteByName(name);
    }
}
