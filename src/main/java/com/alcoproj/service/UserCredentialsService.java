package com.alcoproj.service;

import com.alcoproj.dao.UserCredentialsDAO;
import com.alcoproj.model.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialsService {
    private UserCredentialsDAO userCredentialsDAO = new UserCredentialsDAO();

    @Autowired
    public void setUserDAO(UserCredentialsDAO userCredentialsDAO) {
        this.userCredentialsDAO = userCredentialsDAO;
    }

    UserCredentialsService() {}

    public void add(UserCredentials userCredentials) {
        userCredentialsDAO.add(userCredentials);
    }

    public void delete(UserCredentials userCredentials) {
        userCredentialsDAO.delete(userCredentials);
    }

    public void edit(UserCredentials user) {
        userCredentialsDAO.edit(user);
    }

    public UserCredentials getById(int id) {
        return userCredentialsDAO.getById(id);
    }

    public UserCredentials getByEmail(String email) {
        return userCredentialsDAO.getByEmail(email);
    }
}
