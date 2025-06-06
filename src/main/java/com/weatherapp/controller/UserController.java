package com.weatherapp.controller;


import com.weatherapp.dto.user.LoginRequestDTO;
import com.weatherapp.dto.user.RegisterUserRequestDTO;
import com.weatherapp.dto.user.UpdateUserRequestDTO;
import com.weatherapp.dto.user.UserEditTypeRequestDTO;
import com.weatherapp.service.user.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequestDTO dto) {
        return userService.registerUser(dto);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO dto) {
        return userService.login(dto);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @PutMapping("/permission/{email}")
    public ResponseEntity<?> editPermission(@PathVariable String email, @RequestBody UserEditTypeRequestDTO dto) {
        return userService.editPermission(email, dto);
    }

    @PutMapping("/{email}")
    public ResponseEntity<?> updateUser(@PathVariable String email, @RequestBody UpdateUserRequestDTO dto) {
        return userService.updateUser(email, dto);
    }
}
