package fis.com.training.dao;


import fis.com.training.core.object.Evidence;

public interface IEvidenceDAO extends IDao<Evidence> {
    public void deleteById(Long Id);
    Evidence getEvidenceById(long evidenceId);
}
