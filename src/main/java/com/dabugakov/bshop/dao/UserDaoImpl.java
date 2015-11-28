package com.dabugakov.bshop.dao;

import com.dabugakov.bshop.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DABugakov on 26.11.2015.
 */
//CRUD


public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;
    private Session session;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void addUser(User user){
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public void editUser(User user) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        User existingUser = (User)session.load(User.class,user.getId());
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        session.save(existingUser);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteUserById(User user){
        session = sessionFactory.openSession();
        session.beginTransaction();
        User userDelete = (User)session.load(User.class,user.getId());
        if(user != null){
            session.delete(userDelete);
        }
        session.getTransaction().commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers(){
        session = sessionFactory.openSession();
        session.beginTransaction();
        List<User> users = (List<User>)session.createQuery("from User").list();
        session.close();
        return users;
    }

}