package org.example.summerproject.service.mapper;

import org.example.summerproject.dto.user.UserDto;
import org.example.summerproject.entity.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class UserMapper {
    public UserDto mapUserToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getName()
        );
    }

    public List<UserDto> mapUserToUserDto(Collection<User> users) {
        return users.stream()
                .map(this::mapUserToUserDto)
                .toList();
    }
}
