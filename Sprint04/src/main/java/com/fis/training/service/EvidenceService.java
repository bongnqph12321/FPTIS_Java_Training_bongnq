package com.fis.training.service;

import com.fis.training.model.Evidence;

import java.util.List;

public interface EvidenceService {
    Evidence findById(Long id);
    Evidence createEvidence(Evidence evidence);
    Evidence updateEvidence(Evidence evidence);
    void deleteEvidenceById(Long evidenceId);
    List<Evidence> findAll();
}
