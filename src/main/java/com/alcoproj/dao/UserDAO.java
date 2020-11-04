package com.alcoproj.dao;

import com.alcoproj.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.flush();
        session.getTransaction().commit();
    }

    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.remove(user);
        session.getTransaction().commit();
    }

    public void edit(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    public User getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }
}
