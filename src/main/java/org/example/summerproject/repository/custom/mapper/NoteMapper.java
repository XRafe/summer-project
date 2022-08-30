package org.example.summerproject.repository.custom.mapper;

import lombok.SneakyThrows;
import org.example.summerproject.dto.note.NoteDto;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class NoteMapper {

    @SneakyThrows
    public List<NoteDto> mapResultSetToNoteDto(ResultSet resultSet) {
        List<NoteDto> notes = new ArrayList<>();
        while (resultSet.next()) {
            Integer id = Integer.parseInt(resultSet.getString("id"));
            String email = resultSet.getString("name");
            String name = resultSet.getString("text");

            notes.add(new NoteDto(id, email, name));
        }
        return notes;
    }
}
