package by.teachmeskills.eshop.repositories;

import by.teachmeskills.eshop.entities.BaseEntity;

import java.util.List;

public interface BaseRepository<T extends BaseEntity> {

    T create(T entity) throws Exception;

    List<T> read() throws Exception;

    T update(T entity) throws Exception;

    void delete(int id) throws Exception;
}
