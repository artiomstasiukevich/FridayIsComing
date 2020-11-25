package com.alcoproj.controllers;

import com.alcoproj.model.AlcType;
import com.alcoproj.service.AlcTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AlcTypeController {
    private final AlcTypeService alcTypeService;

    @Autowired
    public AlcTypeController(AlcTypeService alcTypeService) {
        this.alcTypeService = alcTypeService;
    }

    @PostMapping(value = "/alctype")
    public ResponseEntity<?> create(@RequestBody AlcType alcType) {
        alcTypeService.add(alcType);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/alctype")
    public ResponseEntity<?> showAll() {
        return new ResponseEntity<>(alcTypeService.getAllAlcType(),
                HttpStatus.OK);
    }

    @GetMapping(value = "/alctype/{id}")
    public ResponseEntity<?> read(@PathVariable int id) {
        return new ResponseEntity<>(alcTypeService.getById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/alctype/{id}")
    public ResponseEntity<?> update(@PathVariable int id,
                                    @RequestBody AlcType alcType) {
        alcType.setId(id);
        alcTypeService.edit(alcType);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/alctype/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        alcTypeService.delete(alcTypeService.getById(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE,
            reason = "You are fag (runtime)")
    @ExceptionHandler(RuntimeException.class)
    public void runtime() {
    }

}
