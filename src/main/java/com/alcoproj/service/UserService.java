package com.alcoproj.service;

import com.alcoproj.dao.UserDAO;
import com.alcoproj.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDAO userDAO = new UserDAO();

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    UserService() {}

    public void add(User user) {
        userDAO.add(user);
    }

    public void delete(User user) {
        userDAO.delete(user);
    }

    public void edit(User user) {
        userDAO.edit(user);
    }

    public User getById(int id) {
        return userDAO.getById(id);
    }

}
