package com.pfe.AllTheTps.controllers;


import com.pfe.AllTheTps.DTOs.UserDto;
import com.pfe.AllTheTps.services.IUserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto user) {
        log.debug(" start add user{}",user);
        UserDto savedUser = userService.addUser(user);
        log.debug(" end add user {} ",user);
        return ResponseEntity.ok(savedUser);
    }
    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
    @GetMapping
    public List<UserDto> selectUsers() {
        return userService.selectUsers();
    }
}
