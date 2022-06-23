package fis.com.training.dao;


import fis.com.training.core.object.CriminalCase;

public interface ICriminalDAO extends IDao<CriminalCase> {
    public boolean delete(long id);

}
