package com.fis.training.service.impl;

import com.fis.training.core.EmploymentStatus;
import com.fis.training.core.Rank;
import com.fis.training.model.Detective;
import com.fis.training.service.DetectiveService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DetectiveImplTest {
    @Autowired
    DetectiveService detectiveService  ;
    @Test
    void findById() {
        Detective detective = detectiveService.findById(1L);
        assertEquals("512334",detective.getBadgeNumber());
    }

    @Test
    void createCriminalCase() {
        Detective detective = new Detective();
        detective.setCreatedAt(LocalDateTime.now());
        detective.setModifiedAt(LocalDateTime.now());
        detective.setVersion(1);
        detective.setBadgeNumber("1241245");
        detective.setArmed(true);
        detective.setFirstName("Nguyen");
        detective.setLastName("Thao");
        detective.setPassword("123123");
        detective.setRank(Rank.JUNIOR);
        detective.setStatus(EmploymentStatus.ACTIVE);
        detective.setUsername("thaonguyen22");
        detectiveService.createDetective(detective);
        assertEquals(7,detectiveService.findAll().size());
    }

    @Test
    void deleteCriminalCaseById() {
        detectiveService.deleteDetectiveById(5L);
        assertEquals(6,detectiveService.findAll().size());
    }

    @Test
    void findAll() {
        System.out.println(detectiveService.findAll());
        assertEquals(5,detectiveService.findAll().size());
    }
}