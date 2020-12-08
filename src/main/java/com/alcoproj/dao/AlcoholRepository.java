package com.alcoproj.dao;

import com.alcoproj.model.Alcohol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlcoholRepository extends JpaRepository<Alcohol, Integer> {
}
