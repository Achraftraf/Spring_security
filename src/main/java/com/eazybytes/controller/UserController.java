package com.eazybytes.controller;

import com.eazybytes.model.User;
import com.eazybytes.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User User) {
        try {
                String hashPwd = passwordEncoder.encode(User.getPassword());
                User.setPassword(hashPwd);
                User savedUser = userRepository.save(User);

            if(savedUser.getId() != null) {
                    return ResponseEntity.status(HttpStatus.CREATED).
                            body("Given user details are successfully registered");
                } else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                            body("User registration failed");
                }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("An exception occurred: " + ex.getMessage());
        }

    }

}
