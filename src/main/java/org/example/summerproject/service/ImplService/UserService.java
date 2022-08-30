package org.example.summerproject.service.ImplService;

import lombok.RequiredArgsConstructor;
import org.example.summerproject.dto.NoteDTO;
import org.example.summerproject.dto.UserDTO;
import org.example.summerproject.entity.User;
import org.example.summerproject.repository.DataRepository;
import org.example.summerproject.repository.UserRepository;
import org.example.summerproject.service.IUserService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final DataRepository dataRepository;
    private final UserRepository userRepository;

    @Override
    public UserDTO createUser(User user) {
        user.setEmail(user.getEmail());
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
        return new HashSet<>(dataRepository.findAllNote())
                .stream()
                .sorted(Comparator.comparing(NoteDTO::getName))
                .collect(Collectors.toSet());
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
