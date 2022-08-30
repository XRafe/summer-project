package org.example.summerproject.dto.note;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateNoteDto {

    private final String name;

    private final String text;

    public CreateNoteDto(@JsonProperty("name") String name,
                         @JsonProperty("text") String text) {
        this.name = name;
        this.text = text;
    }
}
