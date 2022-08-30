package org.example.summerproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.summerproject.dto.user.UserDto;
import org.example.summerproject.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public UserDto createUser(UserDto userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping("/data/find-all")
    public List<UserDto> findAllUserFromData() {
        return userService.findAllUserFromData();
    }

    @GetMapping("/find-all")
    public List<UserDto> getAllUser() {
        return userService.getAllUser();
    }
}
