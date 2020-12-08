package com.alcoproj.dao;

import com.alcoproj.model.AlcType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlcTypeRepository extends JpaRepository<AlcType, Integer> {
}
