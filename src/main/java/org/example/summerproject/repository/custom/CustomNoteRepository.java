package org.example.summerproject.repository.custom;

import lombok.RequiredArgsConstructor;
import org.example.summerproject.dto.note.NoteDto;
import org.example.summerproject.repository.custom.connection.AppDataSource;
import org.example.summerproject.repository.custom.mapper.NoteMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomNoteRepository {

    private final NoteMapper noteMapper;

    public List<NoteDto> findAllNote() {
        String sql = "select * from summerproject.note";
        return noteMapper.mapResultSetToNoteDto(AppDataSource.requestToDatabase(sql));
    }
}
