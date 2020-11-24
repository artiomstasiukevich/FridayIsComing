package com.alcoproj.controllers;

import com.alcoproj.model.User;
import com.alcoproj.model.UserCredentials;
import com.alcoproj.service.UserCredentialsService;
import com.alcoproj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class DBController {
    private final UserCredentialsService userCredentialsService;
    private final UserService userService;

    @Autowired
    public DBController(UserCredentialsService userCredentialsService,
                        UserService userService) {
        this.userCredentialsService = userCredentialsService;
        this.userService = userService;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<?> create(@RequestBody User user) {
        userService.add(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<?> read(@PathVariable int id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody User user) {
        userService.edit(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        userCredentialsService.delete(
                userCredentialsService.getByEmail(
                        userService.getById(id).getEmail()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE,
            reason = "You are fag (runtime)")
    @ExceptionHandler(RuntimeException.class)
    public void runtime() {
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED,
            reason = "You are fag (credentials)")
    @ExceptionHandler(IllegalArgumentException.class)
    public void illegalArgument() {
    }
}
