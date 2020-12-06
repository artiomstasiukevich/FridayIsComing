package com.alcoproj.service;

import com.alcoproj.dao.BarRepository;
import com.alcoproj.model.Bar;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class BarService {
    private final BarRepository barRepository;

    public void add(Bar bar) {
        barRepository.save(bar);
    }

    public void delete(Bar bar) {
        barRepository.delete(bar);
    }

    public void edit(Bar bar) {
        if (barRepository.existsById(bar.getId())) {
            barRepository.save(bar);
        } else {
            throw new EntityNotFoundException("You are a fag (edit)");
        }
    }

    public Bar getById(int id) {
        return barRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("You are a fag (get)"));
    }

}
