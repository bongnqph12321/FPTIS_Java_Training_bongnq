package fis.com.training.dao.jdbc;

import fis.com.training.core.object.Evidence;
import fis.com.training.core.object.Person;
import fis.com.training.dao.IEvidenceDAO;

import java.util.List;
import java.util.Optional;

public class JDBCEvidenceDAO implements IEvidenceDAO {
    @Override
    public void save(Evidence evidence) {

    }

    @Override
    public Optional<Evidence> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Evidence> getAll() {
        return null;
    }

    @Override
    public Person update(Evidence evidence) {

        return null;
    }

    @Override
    public void delete(Evidence evidence) {

    }

    @Override
    public Evidence getEvidenceById(long evidenceId) {
        return null;
    }
}
