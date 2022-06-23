package fis.com.training.dao.detective;

import fis.com.training.core.object.Detective;


import java.util.List;

public interface IDetectiveDAO {
    //Create Functions C
    public void add(Detective detective);

    //Retrieve Functions R
    public Detective get(long id);
    public List<Detective> getAll();

    //Update Functions U
    public Detective update(Detective detective);

    //Delete Functions D
    public Detective remove(long id);

    //Other Functions
}
