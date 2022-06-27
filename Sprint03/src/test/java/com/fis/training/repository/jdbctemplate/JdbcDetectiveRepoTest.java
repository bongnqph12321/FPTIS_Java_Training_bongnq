package com.fis.training.repository.jdbctemplate;

import com.fis.training.core.EmploymentStatus;
import com.fis.training.core.Rank;
import com.fis.training.model.Detective;
import com.fis.training.model.Person;
import com.fis.training.repository.DetectiveRepo;
import com.fis.training.repository.jdbctemplate.advance.ExtraJdbcDetectiveRepo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;


@SpringBootTest
class JdbcDetectiveRepoTest {
    private Logger logger = LoggerFactory.getLogger(JdbcDetectiveRepoTest.class);

    static final Long DETECTIVE_ID = 1L;

    @Autowired
    @Qualifier("extraJdbcDetectiveRepo")
    DetectiveRepo detectiveRepo;
    @Test
    void findById() {
        System.out.println(detectiveRepo.findById(8L));
    }

    @Test
    void findByBadgeNumber() {
        System.out.println(detectiveRepo.findByBadgeNumber("774744"));
    }

    @Test
    void save() {
        Detective dec = new Detective();
        Person person = new Person();
        person.setCreatedAt(LocalDateTime.now());
        person.setModifiedAt(LocalDateTime.now());
        person.setVersion(1);
        person.setFirstName("bongnq19");
        person.setHiringDate(LocalDateTime.now());
        person.setLastName("Nguyen Quy Bong ");
        person.setPassword("123456");
        person.setUsername("bong123");
        dec.setVersion(1);
        dec.setArmed(true);
        dec.setBadgeNumber("774744");
        dec.setRank(Rank.valueOf("JUNIOR"));
        dec.setStatus(EmploymentStatus.valueOf("ACTIVE"));
        dec.setPerson(person);
        detectiveRepo.save(dec);
        System.out.println(dec.toString());
        System.out.println("DONE");
    }

    @Test
    void findAll() {
        System.out.println(detectiveRepo.findAll());
    }

    @Test
    void findbyRank() {
        System.out.println( detectiveRepo.findbyRank(Rank.JUNIOR));
    }


    @Test
    void deleteById() {
        detectiveRepo.deleteById(8L);
    }
}