package com.dabugakov.bshop.dao;

import com.dabugakov.bshop.entities.User;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by DABugakov on 27.11.2015.
 */
public interface UserDao {
    public void setSessionFactory(SessionFactory sessionFactory);
    public void addUser(User user);
    public void editUser(User user);
    public void deleteUserById(User user);
    public List<User> getAllUsers();


}
