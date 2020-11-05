package com.alcoproj.service;

import com.alcoproj.dao.UserCredentialsRepository;
import com.alcoproj.model.UserCredentials;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class UserCredentialsService {
    private final UserCredentialsRepository userCredentialsRepository;

    public void add(UserCredentials userCredentials) {
        userCredentialsRepository.save(userCredentials);
    }

    public void delete(UserCredentials userCredentials) {
        userCredentialsRepository.delete(userCredentials);
    }

    public void edit(UserCredentials user) {
        if (userCredentialsRepository.existsById(user.getId())) {
            userCredentialsRepository.save(user);
        } else {
            throw new EntityNotFoundException("You are a fag (edit)");
        }
    }

    public UserCredentials getById(int id) {
        return userCredentialsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("You are a fag (get)"));
    }

    public UserCredentials getByEmail(String email) {
        return userCredentialsRepository.findByEmail(email);
    }
}
