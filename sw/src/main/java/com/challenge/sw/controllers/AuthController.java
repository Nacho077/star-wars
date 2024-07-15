package com.challenge.sw.controllers;

import com.challenge.sw.domain.AuthResponse;
import com.challenge.sw.domain.UserInfoDto;
import com.challenge.sw.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody UserInfoDto user) {
        return ResponseEntity.status(201).body(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody UserInfoDto user) {
        return ResponseEntity.status(200).body(userService.login(user));
    }
}
