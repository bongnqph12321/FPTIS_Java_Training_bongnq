package fis.com.training.dao;

import fis.com.training.core.object.Person;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {
    //CREATE
    void save(T t);

    //READ | RETRIEVE
    Optional<T> get(long id);
    List<T> getAll();

    //UPDATE
    Person update(T t);

    //DELETE
    void delete(T t);

    //Other ...
}
