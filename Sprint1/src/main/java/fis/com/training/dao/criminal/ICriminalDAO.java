package fis.com.training.dao.criminal;


import fis.com.training.core.object.Detective;

import java.util.List;

public interface ICriminalDAO {
    public void add(Detective detective);
    public Detective get(long id);
    public List<Detective> getAll();
    public Detective update(Detective detective);
    public Detective remove(long id);
}
