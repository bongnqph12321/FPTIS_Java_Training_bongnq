package com.fis.training.service;

import com.fis.training.model.CriminalCase;

import java.util.List;

public interface CriminalCaseService {
    CriminalCase findById(Long id);
    CriminalCase createCriminalCase(CriminalCase criminalCase);
    CriminalCase updateCriminalCase(CriminalCase criminalCase);
    void deleteCriminalCaseById(Long criminalCaseId);
    List<CriminalCase> findAll();
}
