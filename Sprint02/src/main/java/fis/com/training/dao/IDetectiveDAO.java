package fis.com.training.dao;

import fis.com.training.core.object.Detective;

public interface IDetectiveDAO extends IDao<Detective> {

    Detective getDetectiveById(long leadDetective);
}
