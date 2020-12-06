package com.alcoproj.controllers;

import com.alcoproj.model.PreferredBar;
import com.alcoproj.service.PreferredBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class PreferredBarController {
    private final PreferredBarService preferredBarService;

    @Autowired
    public PreferredBarController(PreferredBarService preferredBarService) {
        this.preferredBarService = preferredBarService;
    }

    @PostMapping(value = "/prefferedbar")
    public ResponseEntity<?> create(@RequestBody PreferredBar preferredBar) {
        preferredBarService.add(preferredBar);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/prefferedbar/{id}")
    public ResponseEntity<?> read(@PathVariable int id) {
        return new ResponseEntity<>(preferredBarService.getById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/prefferedbar/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody PreferredBar preferredBar) {
        preferredBarService.edit(preferredBar);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/prefferedbar/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        preferredBarService.delete(
                preferredBarService.getById(id));
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
