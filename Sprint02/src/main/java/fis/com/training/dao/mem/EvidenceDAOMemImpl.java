package fis.com.training.dao.mem;


import fis.com.training.core.object.Evidence;
import fis.com.training.dao.IEvidenceDAO;

import java.util.List;
import java.util.Optional;

public class EvidenceDAOMemImpl implements IEvidenceDAO {


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
    public void update(Evidence evidence) {

    }

    @Override
    public void delete(Evidence evidence) {

    }
}
