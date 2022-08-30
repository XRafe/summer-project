package org.example.summerproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.summerproject.dto.NoteDTO;
import org.example.summerproject.dto.UserDTO;
import org.example.summerproject.entity.User;
import org.example.summerproject.repository.Data;
import org.example.summerproject.repository.UserRepository;
import org.example.summerproject.service.UserService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final Data data;
    private final UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setName(user.getName());

        userRepository.saveAndFlush(user);

        return mapUserToUserDto(user);
    }

    @Override
    public List<UserDTO> getAllUser() {
        return null;
    }

    @Override
    public Set<NoteDTO> findAllUserFromData() throws SQLException {
        return data.findAllNote();
    }

    @Override
    public UserDTO signIn() {
        return null;
    }

    public UserDTO mapUserToUserDto(User user) {
        return new UserDTO(
                user.getEmail(),
                user.getName()
        );
    }

    public List<UserDTO> mapUserToUserDto(Collection<User> users) {
        return users.stream()
                .map(this::mapUserToUserDto)
                .toList();
    }
}
