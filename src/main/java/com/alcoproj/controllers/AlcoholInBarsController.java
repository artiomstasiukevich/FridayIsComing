package com.alcoproj.controllers;

import com.alcoproj.model.AlcoholInBars;
import com.alcoproj.service.AlcoholInBarsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AlcoholInBarsController {
    private final AlcoholInBarsService alcoholInBarsService;


    @PostMapping(value = "/bars1")
    public ResponseEntity<?> create(@RequestBody AlcoholInBars alcoholInBars) {
        alcoholInBarsService.add(alcoholInBars);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/bars1/{id}")
    public ResponseEntity<?> read(@PathVariable int id) {
        return new ResponseEntity<>(alcoholInBarsService.getById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/bars1/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody AlcoholInBars alcoholInBars) {
        alcoholInBarsService.edit(alcoholInBars);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/bars1/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        alcoholInBarsService.delete(alcoholInBarsService.getById(id));
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
