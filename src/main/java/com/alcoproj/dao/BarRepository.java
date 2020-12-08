package com.alcoproj.dao;

import com.alcoproj.model.Bar;
import com.alcoproj.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarRepository extends JpaRepository<Bar, Integer> {
}
