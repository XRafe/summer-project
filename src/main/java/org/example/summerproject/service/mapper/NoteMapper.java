package org.example.summerproject.service.mapper;

import org.example.summerproject.dto.note.NoteDto;
import org.example.summerproject.entity.Note;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class NoteMapper {

    public NoteDto mapNoteToNoteDto(Note note) {
        NoteDto noteDTO = new NoteDto(
                note.getId(),
                note.getName(),
                note.getText()
        );
        return noteDTO;
    }

    public List<NoteDto> mapNoteToNoteDto(Collection<Note> notes) {
        return notes.stream()
                .map(this::mapNoteToNoteDto)
                .toList();
    }
}
