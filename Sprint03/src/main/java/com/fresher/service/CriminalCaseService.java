package com.fresher.service;

import com.fresher.model.CriminalCase;

import java.util.List;

public interface CriminalCaseService {
    CriminalCase findById(Long id);
    CriminalCase createCriminalCase(CriminalCase criminalCase);
    CriminalCase updateCriminalCase(CriminalCase criminalCase);
    void deleteCriminalCaseById(Long criminalCaseId);
    List<CriminalCase> findAll();
}
