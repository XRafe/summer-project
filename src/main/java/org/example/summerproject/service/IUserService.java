package org.example.summerproject.service;

import org.example.summerproject.dto.NoteDTO;
import org.example.summerproject.dto.UserDTO;
import org.example.summerproject.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface IUserService {

    UserDTO createUser(User user);

    List<UserDTO> getAllUser();

    Set<NoteDTO> findAllUserFromData() throws SQLException;

    UserDTO signIn();
}
