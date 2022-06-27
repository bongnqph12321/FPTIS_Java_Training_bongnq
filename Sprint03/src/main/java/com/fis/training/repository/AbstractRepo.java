package com.fis.training.repository;

import com.fis.training.model.AbstractEntity;
import com.fis.training.model.Detective;

import java.util.Optional;

public interface AbstractRepo <T extends AbstractEntity> {
    Detective save(T entity);
    void delete(T entity);
    T update(T entity);
    int deleteById(Long entityId);
    Optional<T> findById(Long entityId);
}
