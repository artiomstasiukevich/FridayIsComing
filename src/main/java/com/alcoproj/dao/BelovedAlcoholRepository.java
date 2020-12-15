package com.alcoproj.dao;


import com.alcoproj.model.BelovedAlcohol;
import com.alcoproj.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BelovedAlcoholRepository extends JpaRepository<BelovedAlcohol, Integer> {

    List<BelovedAlcohol> findAllByUserId(int user_id);
}
