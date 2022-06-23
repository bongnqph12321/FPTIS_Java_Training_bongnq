package fis.com.training.dao.jdbc;

import fis.com.training.core.object.Person;
import fis.com.training.core.object.Storage;
import fis.com.training.dao.IStorgeDAO;

import java.util.List;
import java.util.Optional;

public class JDBCStorageDAO implements IStorgeDAO {
    @Override
    public void save(Object o) {

    }

    @Override
    public Optional get(long id) {
        return Optional.empty();
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Person update(Object o) {

        return null;
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public Storage getStorageById(long storageId) {
        return null;
    }
}
