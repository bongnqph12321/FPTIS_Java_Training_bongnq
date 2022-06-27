package com.fis.training.service.impl;

import com.fis.training.model.CriminalCase;
import com.fis.training.model.Evidence;
import com.fis.training.repository.CriminalCaseRepository;
import com.fis.training.repository.EvidenceRepository;
import com.fis.training.service.CriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriminalCaseImpl implements CriminalCaseService {
    @Autowired
    CriminalCaseRepository criminalCaseRepository;

    @Autowired
    EvidenceRepository evidenceRepository;
    @Override
    public CriminalCase findById(Long id) {
        return criminalCaseRepository.getById(id);
    }

    @Override
    public CriminalCase createCriminalCase(CriminalCase criminalCase) {
        return criminalCaseRepository.save(criminalCase);
    }

    @Override
    public CriminalCase updateCriminalCase( CriminalCase criminalCase) {
        return criminalCaseRepository.save(criminalCase);
    }

    @Override
    public void deleteCriminalCaseById(Long criminalCaseId) {
        CriminalCase criminalCase  = criminalCaseRepository.getById(criminalCaseId);
        criminalCaseRepository.delete(criminalCase);
    }


    @Override
    public List<CriminalCase> findAll() {
        return criminalCaseRepository.findAll();
    }
}
