package com.gym.dao;

import com.gym.dao.exceptions.PersistException;
import com.gym.entity.News;
import com.gym.entity.User;

/**
 * Created by Nout on 11/05/2015.
 */
public interface DaoUser {
    public User find(String email) throws PersistException;
    public User find(int id) throws PersistException;
    public User persist(User user) throws PersistException;
    void delete(String email) throws PersistException;
}
