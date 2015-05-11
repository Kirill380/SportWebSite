package com.gym.dao;

import com.gym.dao.exceptions.PersistException;
import com.gym.entity.News;

import java.util.List;

/**
 * Created by Nout on 16/03/2015.
 */
public interface DaoNews {
    List<News> getActual() throws PersistException;
    void persist(News n) throws PersistException;
    void delete(News n) throws PersistException;

}
