package org.example.summerproject.repository.custom;

import lombok.RequiredArgsConstructor;
import org.example.summerproject.dto.user.UserDto;
import org.example.summerproject.repository.custom.connection.AppDataSource;
import org.example.summerproject.repository.custom.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomUserRepository {

    private final UserMapper userMapper;

    public List<UserDto> findAllUser() {
        String sql = "select * from summerproject.user";
        return userMapper.mapResultSetToUserDto(AppDataSource.requestToDatabase(sql));
    }
}
