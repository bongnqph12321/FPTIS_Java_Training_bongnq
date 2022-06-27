package com.fis.training.service.impl;
import com.fis.training.core.CaseStatus;
import com.fis.training.core.CaseType;
import com.fis.training.model.CriminalCase;
import com.fis.training.model.Detective;
import com.fis.training.service.CriminalCaseService;
import com.fis.training.service.DetectiveService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CriminalCaseImplTest {
    @Autowired
    CriminalCaseService criminalCaseService;
    @Autowired
    DetectiveService detectiveService;

    @Test
    void findById() {
        CriminalCase criminalCase = criminalCaseService.findById(1L);
        assertEquals("5234321",criminalCase.getNumber());
    }

    @Test
    void createCriminalCase() {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setCreatedAt(LocalDateTime.now());
        criminalCase.setModifiedAt(LocalDateTime.now());
        criminalCase.setVersion(1);
        criminalCase.setNumber("12345");
        criminalCase.setType(CaseType.FELONY);
        criminalCase.setShortDescription("shortDes");
        criminalCase.setDetailedDescription("DetailDes");
        criminalCase.setStatus(CaseStatus.COLD);
        Detective detective = detectiveService.findById(2l);
        criminalCase.setLeadInvestigator(detective);
        criminalCaseService.createCriminalCase(criminalCase);
    }


    @Test
    void deleteCriminalCaseById() {
        criminalCaseService.deleteCriminalCaseById(2L);
        assertEquals(6,criminalCaseService.findAll().size());
    }

    @Test
    void findAll() {
        System.out.println(criminalCaseService.findAll());
        assertEquals(2,criminalCaseService.findAll().size());
    }
}