package org.example.summerproject.controller;

import lombok.AllArgsConstructor;
import org.example.summerproject.dto.NoteDTO;
import org.example.summerproject.dto.UserDTO;
import org.example.summerproject.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserServiceImpl userService;

    @PostMapping("/create")
    public UserDTO createUser(UserDTO userDTO) {
        return userService.createUser(userDTO);
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
