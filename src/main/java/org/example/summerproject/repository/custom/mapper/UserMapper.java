package org.example.summerproject.repository.custom.mapper;

import lombok.SneakyThrows;
import org.example.summerproject.dto.user.UserDto;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    @SneakyThrows
    public List<UserDto> mapResultSetToUserDto(ResultSet resultSet) {
        List<UserDto> users = new ArrayList<>();
        while (resultSet.next()) {
            Integer id = Integer.parseInt(resultSet.getString("id"));
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");

            users.add(new UserDto(id, email, name));
        }
        return users;
    }
}
