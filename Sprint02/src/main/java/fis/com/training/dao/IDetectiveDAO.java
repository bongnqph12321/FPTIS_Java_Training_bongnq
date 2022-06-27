package fis.com.training.dao;

import fis.com.training.core.object.Detective;

public interface IDetectiveDAO extends IDao<Detective> {
    public void deleteById(Long id);
    Detective getDetectiveById(long leadDetective);
}
