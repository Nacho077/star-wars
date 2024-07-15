package com.challenge.sw.service;

import com.challenge.sw.domain.AuthResponse;
import com.challenge.sw.domain.User;
import com.challenge.sw.domain.UserInfoDto;
import com.challenge.sw.exceptions.InternalException;
import com.challenge.sw.repositories.UserRepository;
import com.challenge.sw.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    public AuthResponse login(UserInfoDto userRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.email(), userRequest.password()));
        UserDetails user = userRepository.findByEmail(userRequest.email())
                .orElseThrow(() -> new InternalException("User not found", HttpStatus.NOT_FOUND));

        return new AuthResponse(JwtUtil.generateToken(user));
    }

    public AuthResponse register(UserInfoDto userRequest) {
        var user = User.builder()
                .email(userRequest.email())
                .password(passwordEncoder.encode(userRequest.password()))
                .build();

        userRepository.save(user);

        return new AuthResponse(JwtUtil.generateToken(user));
    }
}
