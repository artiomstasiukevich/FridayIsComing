package com.alcoproj.service;

import com.alcoproj.dao.AlcTypeRepository;
import com.alcoproj.dao.BelovedAlcoholRepository;
import com.alcoproj.model.AlcType;
import com.alcoproj.model.BelovedAlcohol;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BelovedAlcoholService {
    private final BelovedAlcoholRepository belovedAlcoholService;
    private final AlcTypeRepository alcTypeRepository;

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

    public List<AlcType> getAllBelovedAlcTypeById(int user_id) {
        List<BelovedAlcohol> belovedAlcoholList = belovedAlcoholService.findAllByUserId(user_id);
        List<Integer> flex = new ArrayList<>();
        for (BelovedAlcohol belovedAlcohol : belovedAlcoholList) {
            flex.add(belovedAlcohol.getAlcoType());
        }
        return alcTypeRepository.findAllById(flex);
    }
}
