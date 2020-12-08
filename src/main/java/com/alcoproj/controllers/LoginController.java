package com.alcoproj.controllers;

import com.alcoproj.model.User;
import com.alcoproj.model.UserCredentials;
import com.alcoproj.service.UserCredentialsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class LoginController {
    private final PasswordEncoder passwordEncoder;
    private final UserCredentialsService userCredentialsService;

    @CrossOrigin
    @PostMapping(value = "/registration")
    ResponseEntity<?> register(@RequestBody User user) {
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setPassword(passwordEncoder.encode(user.getPassword()));
        userCredentials.setEmail(user.getEmail());
        userCredentials.setUser(user);
        userCredentialsService.add(userCredentials);
        return new ResponseEntity<>(new UsernamePasswordAuthenticationToken(userCredentials.getEmail(),
                userCredentials.getPassword()), HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @PostMapping(value = "/login")
    ResponseEntity<?> login(@RequestParam String email,
                            @RequestParam String password) {
        if(passwordEncoder.matches(password, userCredentialsService.getByEmail(email).getPassword())) {
            return new ResponseEntity<>(
                    new UsernamePasswordAuthenticationToken(userCredentialsService.getByEmail(email).getEmail(),
                    userCredentialsService.getByEmail(email).getPassword()), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
