package com.fis.training.service.impl;

import com.fis.training.service.EvidenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EvidenceImplTest {
    @Autowired
    EvidenceService evidenceService;

    @Test
    void findById() {
        System.out.println(evidenceService.findById(1L));
    }

    @Test
    void createEvidence() {
    }

    @Test
    void updateEvidence() {
    }

    @Test
    void deleteEvidenceById() {
    }

    @Test
    void findAll() {
        System.out.println(evidenceService.findAll());
    }
}