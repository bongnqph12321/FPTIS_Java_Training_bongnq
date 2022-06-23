package fis.com.training.dao.mem;


import fis.com.training.core.object.CriminalCase;
import fis.com.training.dao.ICriminalDAO;

import java.util.List;
import java.util.Optional;

public class CriminalDAOMemImpl implements ICriminalDAO {


    @Override
    public boolean delete(long id) {
        for(CriminalCase criminalCase : MemoryDataSource.CRIMINAL_CASES) {
            if (criminalCase.getId() == id){
                MemoryDataSource.CRIMINAL_CASES.remove(criminalCase);
                return false;
            }
        }
        return false;
    }

    @Override
    public void save(CriminalCase criminalCase) {
        if(
        !MemoryDataSource.CRIMINAL_CASES.stream().filter(item -> item.getId()==criminalCase.getId()).findFirst().isPresent()
        )
        MemoryDataSource.CRIMINAL_CASES.add(criminalCase);
    }

    @Override
    public Optional<CriminalCase> get(long id) {
        return MemoryDataSource.CRIMINAL_CASES.stream()
                .filter(criminalCase -> criminalCase.getId()==id)
                .findFirst();
    }

    @Override
    public List<CriminalCase> getAll() {
        return null;
    }

    @Override
    public void update(CriminalCase newCriminalCase) {
        Optional<CriminalCase> criminalCase = get(newCriminalCase.getId());
        if(criminalCase.isPresent()){
            CriminalCase updatedCriminalCase = criminalCase.get();
            updatedCriminalCase.replaceWith(newCriminalCase);
        }
    }

    @Override
    public void delete(CriminalCase criminalCase) {
        MemoryDataSource.CRIMINAL_CASES.remove(criminalCase);
    }
}
