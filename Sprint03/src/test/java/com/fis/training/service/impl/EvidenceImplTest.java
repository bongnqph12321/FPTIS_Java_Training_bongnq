package com.fis.training.service.impl;


import com.fis.training.model.CriminalCase;
import com.fis.training.model.Evidence;
import com.fis.training.model.Storage;
import com.fis.training.service.CriminalCaseService;
import com.fis.training.service.EvidenceService;
import com.fis.training.service.StorageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class EvidenceImplTest {
    @Autowired
    EvidenceService evidenceService;
    @Autowired
    CriminalCaseService criminalCaseService;
    @Autowired
    StorageService  storageService;
    @Test
    void findById() {
        Evidence evidence = evidenceService.findById(1L);
        assertEquals("1",evidence.getVersion());
    }

    @Test
    void createEvidence() {
        Evidence evidence = new Evidence();
        evidence.setCreatedAt(LocalDateTime.now());
        evidence.setModifiedAt(LocalDateTime.now());
        evidence.setVersion(1);
        evidence.setNotes("notes");
        evidence.setItemName("ItemName");
        CriminalCase criminalCase = criminalCaseService.findById(1L);
        evidence.setCriminalCase(criminalCase);
        Storage storage = storageService.findById(2l);
        evidence.setStorage(storage);
        criminalCaseService.createCriminalCase(criminalCase);
    }

    @Test
    void updateEvidence() {
    }

    @Test
    void deleteEvidenceById() {
        evidenceService.deleteEvidenceById(2L);
        assertEquals(6,evidenceService.findAll().size());
    }

    @Test
    void findAll() {
        //System.out.println(EvidenceService.findAll());
        assertEquals(2,evidenceService.findAll().size());
    }
}