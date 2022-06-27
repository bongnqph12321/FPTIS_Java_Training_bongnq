package com.fis.training.service;

import com.fis.training.model.Detective;
import com.fis.training.model.Storage;

import java.util.List;

public interface StorageService {
    Storage findById(Long id);
    void createStorage(Storage storage);
    Detective updateStorage(Storage storage);
    void deleteStorageById(Long storageId);
    List<Storage> findAll();
}
