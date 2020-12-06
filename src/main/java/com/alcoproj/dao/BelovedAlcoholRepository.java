package com.alcoproj.dao;


import com.alcoproj.model.BelovedAlcohol;
import com.alcoproj.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BelovedAlcoholRepository extends JpaRepository<BelovedAlcohol, Integer> {
}
