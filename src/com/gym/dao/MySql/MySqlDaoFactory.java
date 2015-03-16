package com.gym.dao.MySql;


import com.gym.dao.DaoFactory;
import com.gym.dao.DaoNews;
import com.gym.dao.exceptions.PersistException;

public class MySqlDaoFactory implements DaoFactory {

    @Override
    public DaoNews getDaoNews() throws PersistException {
        return new MySqlDaoNews();
    }
}
