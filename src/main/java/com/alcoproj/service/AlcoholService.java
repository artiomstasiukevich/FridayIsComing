package com.alcoproj.service;

import com.alcoproj.dao.AlcTypeRepository;
import com.alcoproj.dao.AlcoholRepository;
import com.alcoproj.model.AlcType;
import com.alcoproj.model.Alcohol;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class AlcoholService {
    private final AlcoholRepository alcoholRepository;

    public void add(Alcohol alcohol) {
        alcoholRepository.save(alcohol);
    }

    public void delete(Alcohol alcohol) {
        alcoholRepository.delete(alcohol);
    }

    public void edit(Alcohol alcohol) {
        if (alcoholRepository.existsById(alcohol.getId())) {
            alcoholRepository.save(alcohol);
        } else {
            throw new EntityNotFoundException("You are a fag (edit)");
        }
    }

    public Alcohol getById(int id) {
        return alcoholRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("You are a fag (get)"));
    }

    public List<Alcohol> getAllAlcohol() {
        return alcoholRepository.findAll();
    }
}
