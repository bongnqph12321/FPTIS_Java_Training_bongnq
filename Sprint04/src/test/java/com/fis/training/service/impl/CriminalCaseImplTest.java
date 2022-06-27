package com.fis.training.service.impl;

import com.fis.training.model.CriminalCase;
import com.fis.training.model.Detective;
import com.fis.training.model.core.CaseStatus;
import com.fis.training.model.core.CaseType;
import com.fis.training.repository.CriminalCaseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class CriminalCaseImplTest {
    @Autowired
    CriminalCaseRepository criminalCaseRepository;

    @Test
    void findById() {
        CriminalCase employee = getCriminalCase();
        this.criminalCaseRepository.save(employee);
        CriminalCase result = this.criminalCaseRepository.findById(employee.getId()).get();
        assertEquals(employee.getId(), result.getId());
    }


    @Test
    void createCriminalCase() {
        CriminalCase employee = getCriminalCase();
        this.criminalCaseRepository.save(employee);
        CriminalCase found = this.criminalCaseRepository.findById(employee.getId()).get();
        assertEquals(employee.getId(), found.getId());
    }


    @Test
    void deleteCriminalCaseById() {
        CriminalCase employee = criminalCaseRepository.findById(1L).get();
        this.criminalCaseRepository.save(employee);
        this.criminalCaseRepository.deleteById(employee.getId());
        List<CriminalCase> result = new ArrayList<>(this.criminalCaseRepository.findAll());
        assertEquals(result.size(), 1);
    }

    @Test
    void findAll() {
        CriminalCase employee = getCriminalCase();
        this.criminalCaseRepository.save(employee);
        List<CriminalCase> result = new ArrayList<>(this.criminalCaseRepository.findAll());
        assertEquals(result.size(), 2);
    }

    private CriminalCase getCriminalCase() {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setCreatedAt(LocalDateTime.now());
        criminalCase.setModifiedAt(LocalDateTime.now());
        criminalCase.setVersion(2);
        criminalCase.setDetailedDescription("knduidioa");
        criminalCase.setNotes("nodanda");
        criminalCase.setNumber("231124");
        criminalCase.setShortDescription("009897087");
        criminalCase.setStatus(CaseStatus.valueOf("SUBMITTED"));
        criminalCase.setType(CaseType.valueOf("UNCATEGORIZED"));
        Detective person = new Detective();
        person.setId(3L);
        criminalCase.setLeadInvestigator(person);
        return criminalCase;
    }
}