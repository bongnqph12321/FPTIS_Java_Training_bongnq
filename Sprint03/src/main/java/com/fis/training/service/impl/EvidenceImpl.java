package com.fis.training.service.impl;

import com.fis.training.model.Evidence;
import com.fis.training.repository.jpa.EvidenceRepository;
import com.fis.training.service.EvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvidenceImpl implements EvidenceService {
    @Autowired
    EvidenceRepository evidenceRepository;
    @Override
    public Evidence findById(Long id) {
        return this.evidenceRepository.findById(id).get();
    }

    @Override
    public void createEvidence(Evidence evidence) {
        this.evidenceRepository.save(evidence);
    }

    @Override
    public Evidence updateEvidence(Evidence evidence) {
        return evidenceRepository.save(evidence);
    }

    @Override
    public void deleteEvidenceById(Long evidenceId) {
        this.evidenceRepository.deleteById(evidenceId);
    }

    @Override
    public List<Evidence> findAll() {
        return this.evidenceRepository.findAll();
    }
}
