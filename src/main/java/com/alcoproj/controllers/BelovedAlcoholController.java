package com.alcoproj.controllers;

import com.alcoproj.model.BelovedAlcohol;
import com.alcoproj.service.BelovedAlcoholService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class BelovedAlcoholController {
    private final BelovedAlcoholService belovedAlcoholService;

    @Autowired
    public BelovedAlcoholController(BelovedAlcoholService belovedAlcoholService) {
        this.belovedAlcoholService = belovedAlcoholService;
    }

    @PostMapping(value = "/belovedalcohol")
    public ResponseEntity<?> create(@RequestBody BelovedAlcohol belovedAlcohol) {
        belovedAlcoholService.add(belovedAlcohol);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/belovedalcohol/{id}")
    public ResponseEntity<?> read(@PathVariable int id) {
        return new ResponseEntity<>(belovedAlcoholService.getById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/belovedalcohol/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody BelovedAlcohol belovedAlcohol) {
        belovedAlcoholService.edit(belovedAlcohol);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/belovedalcohol/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        belovedAlcoholService.delete(
                belovedAlcoholService.getById(id));
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
