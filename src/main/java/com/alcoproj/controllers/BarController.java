package com.alcoproj.controllers;

import com.alcoproj.model.Bar;
import com.alcoproj.service.BarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BarController {
    private final BarService barService;


    @PostMapping(value = "/bars")
    public ResponseEntity<?> create(@RequestBody Bar bar) {
        barService.add(bar);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/bars/{id}")
    public ResponseEntity<?> read(@PathVariable int id) {
        return new ResponseEntity<>(barService.getById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/bars/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Bar bar) {
        barService.edit(bar);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/bars/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        barService.delete(barService.getById(id));
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
