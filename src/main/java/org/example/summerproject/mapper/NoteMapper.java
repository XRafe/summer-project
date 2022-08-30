package org.example.summerproject.mapper;

import org.example.summerproject.dto.NoteDto;
import org.example.summerproject.entity.Note;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class NoteMapper {

    public NoteDto toNoteDto(Note note) {
        NoteDto noteDTO = new NoteDto();
        noteDTO.setName(note.getName());
        noteDTO.setText(note.getText());
        return noteDTO;
    }

    public List<NoteDto> toNoteDtos(Collection<Note> notes) {
        return notes.stream()
                .map(n -> new NoteDto(
                        n.getName(),
                        n.getText())).toList();
    }
}
