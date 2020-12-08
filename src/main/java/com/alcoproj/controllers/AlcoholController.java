package com.alcoproj.controllers;

import com.alcoproj.model.Alcohol;
import com.alcoproj.service.AlcoholService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AlcoholController {
    private final AlcoholService alcoholService;

    @Autowired
    public AlcoholController(AlcoholService alcoholService) {
        this.alcoholService = alcoholService;
    }

    @PostMapping(value = "/alcohol")
    public ResponseEntity<?> create(@RequestBody Alcohol alcohol) {
        alcoholService.add(alcohol);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/alcohol")
    public ResponseEntity<?> showAll() {
        return new ResponseEntity<>(alcoholService.getAllAlcohol(),
                HttpStatus.OK);
    }

    @GetMapping(value = "/alcohol/{id}")
    public ResponseEntity<?> read(@PathVariable int id) {
        return new ResponseEntity<>(alcoholService.getById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/alcohol/{id}")
    public ResponseEntity<?> update(@PathVariable int id,
                                    @RequestBody Alcohol alcohol) {
        alcohol.setId(id);
        alcoholService.edit(alcohol);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/alcohol/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        alcoholService.delete(alcoholService.getById(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE,
            reason = "You are fag (runtime)")
    @ExceptionHandler(RuntimeException.class)
    public void runtime() {
    }

}
