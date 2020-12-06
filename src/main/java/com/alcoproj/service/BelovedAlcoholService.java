package com.alcoproj.service;

import com.alcoproj.dao.BelovedAlcoholRepository;
import com.alcoproj.model.BelovedAlcohol;
import com.alcoproj.model.PreferredBar;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class BelovedAlcoholService {
    private final BelovedAlcoholRepository belovedAlcoholService;

    public void add(BelovedAlcohol belovedAlcohol) {
        belovedAlcoholService.save(belovedAlcohol);
    }

    public void delete(BelovedAlcohol belovedAlcohol) {
        belovedAlcoholService.delete(belovedAlcohol);
    }

    @Transactional
    public void edit(BelovedAlcohol belovedAlcohol) {
        if (belovedAlcoholService.existsById(belovedAlcohol.getId())) {
            belovedAlcoholService.save(belovedAlcohol);
        } else {
            throw new EntityNotFoundException("You are a fag (edit)");
        }
    }


    public BelovedAlcohol getById(int id) {
        return belovedAlcoholService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("You are a fag (get)"));
    }
}
