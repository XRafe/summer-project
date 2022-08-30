package org.example.summerproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.summerproject.dto.user.UserDto;
import org.example.summerproject.entity.User;
import org.example.summerproject.repository.custom.CustomUserRepository;
import org.example.summerproject.repository.jpa.UserRepository;
import org.example.summerproject.service.UserService;
import org.example.summerproject.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImplUserService implements UserService {

    private final CustomUserRepository customUserRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDTO) {
        User user = new User(
                userDTO.getEmail(),
                userDTO.getName()
        );

        userRepository.saveAndFlush(user);

        return userMapper.mapUserToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
        return userMapper.mapUserToUserDto(users);
    }

    @Override
    public List<UserDto> findAllUserFromData() {
        return customUserRepository.findAllUser();
    }
}
