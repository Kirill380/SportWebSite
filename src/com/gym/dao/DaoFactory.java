package com.gym.dao;

import com.gym.dao.exceptions.PersistException;

/**
 * Created by Nout on 10/03/2015.
 */
public interface DaoFactory {
    public DaoNews getDaoNews() throws PersistException;
}
