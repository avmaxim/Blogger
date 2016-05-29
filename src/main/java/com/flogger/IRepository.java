package com.flogger;

import com.flogger.domains.User;

import java.util.List;

public interface IRepository <TEntity> {
    TEntity getById(Integer id);
    List<TEntity> getAll();
    Boolean insert(TEntity entity);
    void update(TEntity entity);
    void delete(TEntity entity);
}
