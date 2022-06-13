package fis.com.training.dao.mem;

import fis.com.training.core.object.Detective;
import fis.com.training.dao.IDetectiveDAO;

import java.util.List;
import java.util.Optional;

public class DetectiveDAOMemImpl implements IDetectiveDAO {


    @Override
    public void save(Detective detective) {

    }

    @Override
    public Optional<Detective> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Detective> getAll() {
        return null;
    }

    @Override
    public void update(Detective detective) {

    }

    @Override
    public void delete(Detective detective) {

    }
}
