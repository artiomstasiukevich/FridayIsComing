package com.alcoproj.service;

import com.alcoproj.dao.BarRepository;
import com.alcoproj.dao.PreferredBarRepository;
import com.alcoproj.model.Bar;
import com.alcoproj.model.PreferredBar;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PreferredBarService {
    private final PreferredBarRepository prefferedBarRepository;
    private final BarRepository barRepository;

    public void add(PreferredBar preferredBar) {
        prefferedBarRepository.save(preferredBar);
    }

    public void delete(PreferredBar preferredBar) {
        prefferedBarRepository.delete(preferredBar);
    }

    @Transactional
    public void edit(PreferredBar preferredBar) {
        if (prefferedBarRepository.existsById(preferredBar.getId())) {
            prefferedBarRepository.save(preferredBar);
        } else {
            throw new EntityNotFoundException("You are a fag (edit)");
        }
    }


    public PreferredBar getById(int id) {
        return prefferedBarRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("You are a fag (get)"));
    }

    public List<Bar> getAllPrefferedBarsById(int user_id) {
        List<PreferredBar> preferredBarList = prefferedBarRepository.findAllByUserId(user_id);
        List<Integer> flex = new ArrayList<>();
        for (PreferredBar preferredBar : preferredBarList) {
            flex.add(preferredBar.getBarId());
        }
        return barRepository.findAllById(flex);
    }
}
