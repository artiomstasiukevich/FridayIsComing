package com.alcoproj.service;

import com.alcoproj.dao.AlcTypeRepository;
import com.alcoproj.model.AlcType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class AlcTypeService {
    private final AlcTypeRepository alcTypeRepository;

    public void add(AlcType alcType) {
        alcTypeRepository.save(alcType);
    }

    public void delete(AlcType alcType) {
        alcTypeRepository.delete(alcType);
    }

    public void edit(AlcType alcType) {
        if (alcTypeRepository.existsById(alcType.getId())) {
            alcTypeRepository.save(alcType);
        } else {
            throw new EntityNotFoundException("You are a fag (edit)");
        }
    }

    public AlcType getById(int id) {
        return alcTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("You are a fag (get)"));
    }

    public List<AlcType> getAllAlcType() {
        return alcTypeRepository.findAll();
    }
}
