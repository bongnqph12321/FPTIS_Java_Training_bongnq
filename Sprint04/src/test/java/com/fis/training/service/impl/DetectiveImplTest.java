package com.fis.training.service.impl;

import com.fis.training.model.Detective;
import com.fis.training.model.Person;
import com.fis.training.model.core.EmploymentStatus;
import com.fis.training.model.core.Rank;
import com.fis.training.repository.DetectiveRepository;
import com.fis.training.service.DetectiveService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DetectiveImplTest {
    @Autowired
    DetectiveService detectiveService;
    @Autowired
    DetectiveRepository detectiveRepository;
    @Test
    void findById() {
        System.out.println(detectiveRepository.findById(1L));
    }

    @Test
    void createDetective() {
        Detective detective = new Detective();
        detective.setId(1L);
        detective.setCreatedAt(LocalDateTime.now());
        detective.setModifiedAt(LocalDateTime.now());
        detective.setVersion(1);
        detective.setHiringDate(LocalDateTime.now());
        detective.setBadgeNumber("12345a");
        detective.setRank(Rank.JUNIOR);
        detective.setArmed(false);
        detective.setStatus(EmploymentStatus.ACTIVE);
        Person person = new Person();
        person.setId(1L);
        detective.setPerson(person);
        Mockito.when(detectiveRepository.save(detective)).thenReturn(detective);
        Assertions.assertThat(this.detectiveService.createDetective(detective)).isEqualTo(detective);

    }

    @Test
    void updateDetective() {
        Detective detective = new Detective();
        detective.setId(15L);
        detective.setCreatedAt(LocalDateTime.now());
        detective.setModifiedAt(LocalDateTime.now());
        detective.setVersion(1);
        detective.setArmed(true);
        detective.setBadgeNumber("9871263");
        detective.setRank(Rank.valueOf("SENIOR"));
        detective.setStatus(EmploymentStatus.valueOf("VACATION"));
        Person person = new Person();
        person.setId(2L);
        detective.setPerson(person);
        Mockito.when(this.detectiveRepository.findById(15L)).thenReturn(Optional.of(detective));
        detective.setBadgeNumber("bug1231");
        Mockito.when(this.detectiveRepository.save(detective)).thenReturn(detective);
        Assertions.assertThat(this.detectiveService.updateDetective(detective)).isEqualTo(detective);
    }

    @Test
    void deleteDetectiveById() {
        Detective detective = new Detective();
        detective.setId(15L);
        detective.setCreatedAt(LocalDateTime.now());
        detective.setModifiedAt(LocalDateTime.now());
        detective.setVersion(1);
        detective.setArmed(true);
        detective.setBadgeNumber("9871263");
        detective.setRank(Rank.valueOf("SENIOR"));
        detective.setStatus(EmploymentStatus.valueOf("VACATION"));
        Person person = new Person();
        person.setId(2L);
        detective.setPerson(person);
        Mockito.when(this.detectiveRepository.findById(15L)).thenReturn(Optional.of(detective));
        Mockito.when(this.detectiveRepository.existsById(detective.getId())).thenReturn(false);
        assertFalse (this.detectiveRepository.existsById(detective.getId()));
    }

    @Test
    void findAll() {
        System.out.println(detectiveRepository.findAll());
    }
}