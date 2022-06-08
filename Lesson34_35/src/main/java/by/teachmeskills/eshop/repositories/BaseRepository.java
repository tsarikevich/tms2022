package by.teachmeskills.eshop.repositories;

import by.teachmeskills.eshop.entities.BaseEntity;
import by.teachmeskills.eshop.utils.ConnectionPool;

import java.util.List;

public interface BaseRepository<T extends BaseEntity> {
    ConnectionPool connectionPool = ConnectionPool.getInstance();

    T create(T entity);

    List<T> read();

    T update(T entity);

    void delete(int id);
}
