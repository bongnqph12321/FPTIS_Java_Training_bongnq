package fis.com.training.dao.jdbc;

import fis.com.training.core.object.Person;
import fis.com.training.dao.ITrackEntryDAO;

import java.util.List;
import java.util.Optional;

public class JDBCTrackEntryDAO implements ITrackEntryDAO {
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
}
