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

@SpringBootTest
class DetectiveImplTest {
    @Autowired
    DetectiveService detectiveService;
    @Autowired
    DetectiveRepository detectiveRepository;
    @Test
    void findById() {
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
    }

    @Test
    void deleteDetectiveById() {
    }

    @Test
    void findAll() {
    }
}