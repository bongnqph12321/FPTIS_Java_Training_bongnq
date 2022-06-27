package com.fis.training.service.impl;

import com.fis.training.model.CriminalCase;
import com.fis.training.model.core.CaseStatus;
import com.fis.training.model.core.CaseType;
import com.fis.training.service.CriminalCaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class CriminalCaseImplTest {
    @Autowired
    CriminalCaseService criminalCaseService;

    @Test
    void findById() {
    }

    @Test
    void createCriminalCase() {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setId(1L);
        criminalCase.setCreatedAt(LocalDateTime.now());
        criminalCase.setModifiedAt(LocalDateTime.now());
        criminalCase.setVersion(1);
        criminalCase.setNumber("12345a");
        criminalCase.setType(CaseType.MISDEMEANOR);
        criminalCase.setShortDescription("shortdes");
        criminalCase.setDetailedDescription("detaildes");
        criminalCase.setStatus(CaseStatus.CLOSED);
        criminalCase.setNotes("notes");
        criminalCaseService.createCriminalCase(criminalCase);
    }

    @Test
    void updateCriminalCase() {
    }

    @Test
    void deleteCriminalCaseById() {
    }

    @Test
    void findAll() {
    }
}