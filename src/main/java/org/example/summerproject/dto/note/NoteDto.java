package org.example.summerproject.dto.note;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NoteDto {

    private final Integer id;

    private final String name;

    private final String text;
}
