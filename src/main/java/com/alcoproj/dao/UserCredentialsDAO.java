package com.alcoproj.dao;

import com.alcoproj.model.UserCredentials;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserCredentialsDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(UserCredentials userCred) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(userCred);
        session.flush();
        session.getTransaction().commit();
    }

    public void delete(UserCredentials userCred) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.remove(userCred);
        session.getTransaction().commit();
    }

    public void edit(UserCredentials userCred) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(userCred);
        session.getTransaction().commit();
    }

    public UserCredentials getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(UserCredentials.class, id);
    }

    public UserCredentials getByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        return session.byNaturalId(UserCredentials.class)
                .using("email", email)
                .load();
    }
}
