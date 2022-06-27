package com.fis.training.service.impl;

import com.fis.training.model.Detective;
import com.fis.training.model.Storage;
import com.fis.training.service.StorageService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StorageImpl implements StorageService {
    @Override
    public Storage findById(Long id) {
        return null;
    }

    @Override
    public void createStorage(Storage storage) {

    }

    @Override
    public Detective updateStorage(Storage storage) {
        return null;
    }

    @Override
    public void deleteStorageById(Long storageId) {

    }

    @Override
    public List<Storage> findAll() {
        return null;
    }
}
