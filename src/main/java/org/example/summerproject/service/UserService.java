package org.example.summerproject.service;

import org.example.summerproject.dto.NoteDto;
import org.example.summerproject.dto.UserDto;
import org.example.summerproject.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface UserService {

    UserDto createUser(User user);

    List<UserDto> getAllUser();

    Set<NoteDto> findAllUserFromData() throws SQLException;

    UserDto signIn();
}
