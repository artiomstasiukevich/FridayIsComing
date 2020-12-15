package com.alcoproj.controllers;

import com.alcoproj.service.BelovedAlcoholService;
import com.alcoproj.service.PreferredBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BelovedListController {
    private final BelovedAlcoholService belovedAlcoholService;
    private final PreferredBarService preferredBarService;

    @Autowired
    public BelovedListController(BelovedAlcoholService belovedAlcoholService,
                                 PreferredBarService preferredBarService) {
        this.belovedAlcoholService = belovedAlcoholService;
        this.preferredBarService = preferredBarService;
    }

    @GetMapping(value = "/belovedalctypelist/{id}")
    public ResponseEntity<?> showBelovedAlcType(@PathVariable int id) {
        return new ResponseEntity<>(belovedAlcoholService.getAllBelovedAlcTypeById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/preferredbarlist/{id}")
    public ResponseEntity<?> showPreferredBars(@PathVariable int id) {
        return new ResponseEntity<>(preferredBarService.getAllPrefferedBarsById(id), HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE,
            reason = "You are fag (runtime)")
    @ExceptionHandler(RuntimeException.class)
    public void runtime() {
    }
}
