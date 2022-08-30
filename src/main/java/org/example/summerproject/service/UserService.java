package org.example.summerproject.service;

import org.example.summerproject.dto.NoteDTO;
import org.example.summerproject.dto.UserDTO;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> getAllUser();

    Set<NoteDTO> findAllUserFromData() throws SQLException;

    UserDTO signIn();
}
