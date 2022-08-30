package org.example.summerproject.controller;

import org.example.summerproject.dto.NoteDTO;
import org.example.summerproject.dto.UserDTO;
import org.example.summerproject.entity.User;
import org.example.summerproject.service.ImplService.UserService;
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

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserDTO createUser(User user) {
        return userService.createUser(user);
    }

    @GetMapping("/data/find-all")
    public List<NoteDTO> findAllUserFromData() throws SQLException {
        return userService.findAllUserFromData().stream().toList();
    }

    @GetMapping("/find-all")
    public List<UserDTO> getAllUser() {
        return userService.getAllUser();
    }
}
