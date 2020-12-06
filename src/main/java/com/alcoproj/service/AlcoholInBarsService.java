package com.alcoproj.service;

import com.alcoproj.dao.AlcoholInBarsRepository;
import com.alcoproj.model.AlcoholInBars;
import com.alcoproj.model.Bar;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class AlcoholInBarsService {
    private final AlcoholInBarsRepository alcoholInBarsRepository;

    public void add(AlcoholInBars alcoholInBars) {
        alcoholInBarsRepository.save(alcoholInBars);
    }

    public void delete(AlcoholInBars alcoholInBars) {
        alcoholInBarsRepository.delete(alcoholInBars);
    }

    public void edit(AlcoholInBars alcoholInBars) {
        if (alcoholInBarsRepository.existsById(alcoholInBars.getId())) {
            alcoholInBarsRepository.save(alcoholInBars);
        } else {
            throw new EntityNotFoundException("You are a fag (edit)");
        }
    }

    public AlcoholInBars getById(int id) {
        return alcoholInBarsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("You are a fag (get)"));
    }

}
