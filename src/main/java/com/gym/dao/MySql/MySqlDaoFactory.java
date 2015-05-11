package com.gym.dao.MySql;


import com.gym.dao.*;
import com.gym.dao.exceptions.PersistException;

public class MySqlDaoFactory implements DaoFactory {

    @Override
    public DaoNews getDaoNews() throws PersistException {
        return new MySqlDaoNews();
    }

    @Override
    public DaoUser getDaoUser() throws PersistException {
        return null;
    }

    @Override
    public DaoWorkout getDaoWorkout() throws PersistException {
        return null;
    }

    @Override
    public DaoExercise getDaoExercise() throws PersistException {
        return null;
    }
}
