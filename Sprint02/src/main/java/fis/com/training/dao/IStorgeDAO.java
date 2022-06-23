package fis.com.training.dao;

import fis.com.training.core.object.Storage;

public interface IStorgeDAO extends IDao{
    Storage getStorageById(long storageId);
}
