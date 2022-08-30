package org.example.summerproject.service.ImplService;

import lombok.RequiredArgsConstructor;
import org.example.summerproject.dto.UserDto;
import org.example.summerproject.entity.User;
import org.example.summerproject.repository.UserRepository;
import org.example.summerproject.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(User user) {
        user.setEmail(user.getEmail());
        user.setName(user.getName());

        userRepository.saveAndFlush(user);

        return mapUserToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        return null;
    }

    public UserDto mapUserToUserDto(User user) {
        return new UserDto(
                user.getEmail(),
                user.getName()
        );
    }
}
