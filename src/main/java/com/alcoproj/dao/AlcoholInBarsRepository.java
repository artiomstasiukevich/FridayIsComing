package com.alcoproj.dao;

import com.alcoproj.model.AlcoholInBars;
import com.alcoproj.model.Bar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlcoholInBarsRepository extends JpaRepository<AlcoholInBars, Integer> {
}
