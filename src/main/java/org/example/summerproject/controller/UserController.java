package org.example.summerproject.controller;

import org.example.summerproject.dto.NoteDto;
import org.example.summerproject.dto.UserDto;
import org.example.summerproject.entity.User;
import org.example.summerproject.service.ImplService.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserDto createUser(User user) {
        return userService.createUser(user);
    }

    @GetMapping("/data/find-all")
    public List<NoteDto> findAllUserFromData() throws SQLException {
        return userService.findAllUserFromData().stream().toList();
    }

    @GetMapping("/find-all")
    public List<UserDto> getAllUser() {
        return userService.getAllUser();
    }
}
