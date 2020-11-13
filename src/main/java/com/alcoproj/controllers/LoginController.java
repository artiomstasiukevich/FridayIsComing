package com.alcoproj.controllers;

import com.alcoproj.model.User;
import com.alcoproj.model.UserCredentials;
import com.alcoproj.service.UserCredentialsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class LoginController {
    private final PasswordEncoder passwordEncoder;
    private final UserCredentialsService userCredentialsService;

    @PostMapping(value = "/registration")
    ResponseEntity<?> register(@RequestBody User user) {
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setPassword(passwordEncoder.encode(user.getPassword()));
        userCredentials.setEmail(user.getEmail());
        userCredentials.setUser(user);
        userCredentialsService.add(userCredentials);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userCredentials.getEmail(),
                userCredentials.getPassword());
        token.setAuthenticated(true);
        return new ResponseEntity<>(token, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/login")
    ResponseEntity<?> login(@RequestParam String email,
                            @RequestParam String pasword) {
        if(passwordEncoder.encode(pasword).equals(userCredentialsService.getByEmail(email).getPassword())) {
            return new ResponseEntity<>(
                    new UsernamePasswordAuthenticationToken(userCredentialsService.getByEmail(email).getEmail(),
                    userCredentialsService.getByEmail(email).getPassword()), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
