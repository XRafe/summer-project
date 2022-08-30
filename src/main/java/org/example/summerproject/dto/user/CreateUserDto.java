package org.example.summerproject.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateUserDto {

    private final String email;

    private final String name;

    public CreateUserDto(@JsonProperty("email") String email,
                         @JsonProperty("name") String name) {
        this.email = email;
        this.name = name;
    }
}
