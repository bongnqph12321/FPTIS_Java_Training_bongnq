package fis.com.training.dao.mem;

import fis.com.training.core.object.Detective;
import fis.com.training.dao.IDetectiveDAO;

import java.util.List;
import java.util.Optional;

public class DetectiveDAOMemImpl implements IDetectiveDAO {


    @Override
    public void save(Detective detective) {
        if(
           !MemoryDataSource.DETECTIVES.stream().filter(item -> item.getId()==detective.getId()).findFirst().isPresent()
        )
            MemoryDataSource.DETECTIVES.add(detective);
    }

    @Override
    public Optional<Detective> get(long id) {
        return MemoryDataSource.DETECTIVES.stream()
                .filter(criminalCase -> criminalCase.getId()==id)
                .findFirst();
    }

    @Override
    public List<Detective> getAll() {
        return null;
    }

    @Override
    public void update(Detective detective) {
        Optional<Detective> detectives = get(detective.getId());
        if(detectives.isPresent()){
            Detective updatedDetective = detectives.get();
            updatedDetective.replaceWith(detective);
        }
    }

    @Override
    public void delete(Detective detective) {

    }
}
