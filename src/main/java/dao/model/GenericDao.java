package dao.model;

import java.util.List;

public interface GenericDao<T> {
    void add(T t);
    void update(T t);
    void delete(T t);
    T getById(long id);
    List<T> getAll();
}