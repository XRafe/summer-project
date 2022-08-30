package org.example.summerproject.service;

import org.example.summerproject.dto.user.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDTO);

    List<UserDto> getAllUser();

    List<UserDto> findAllUserFromData();
}
