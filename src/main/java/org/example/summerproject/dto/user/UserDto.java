package org.example.summerproject.dto.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserDto {

    private final Integer id;

    private final String email;

    private final String name;
}
