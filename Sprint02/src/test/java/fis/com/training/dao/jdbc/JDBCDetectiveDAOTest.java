package fis.com.training.dao.jdbc;

import fis.com.training.core.enums.EmploymentStatus;
import fis.com.training.core.enums.Rank;
import fis.com.training.core.object.CriminalCase;
import fis.com.training.core.object.Detective;
import fis.com.training.core.object.Person;
import fis.com.training.dao.ICriminalDAO;
import fis.com.training.dao.IDetectiveDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class JDBCDetectiveDAOTest {

    @Test
    void save() {
        JDBCDetectiveDAO detective = new JDBCDetectiveDAO();
        Detective dec = new Detective();
        Person person = new Person();
        person.setCreatedAt(LocalDateTime.now());
        person.setModifiedAt(LocalDateTime.now());
        person.setVersion(1);
        person.setFirstName("bongnq");
        person.setHiringDate(LocalDateTime.now());
        person.setLastName("nguyen quy bong ");
        person.setPassWord("838383");
        person.setUserName("bongnq19");
        dec.setVersion(1);
        dec.setArmed(true);
        dec.setBadgeNumber("774744");
        dec.setRank(Rank.valueOf("JUNIOR"));
        dec.setStatus(EmploymentStatus.valueOf("ACTIVE"));
        dec.setPerson(person);
        detective.save(dec);
        System.out.println(dec.toString());
        System.out.println("DONE");
    }

    @Test
    void get() {
        JDBCDetectiveDAO detective = new JDBCDetectiveDAO();
        System.out.println(detective.getDetectiveById(8L));
    }

    @Test
    void getAll() {
        //A1
        IDetectiveDAO iDetectiveDAO = new JDBCDetectiveDAO();

        //A2
        List<Detective> detectiveList = iDetectiveDAO.getAll();

        //A3: Assert
        System.out.println(detectiveList);
    }

    @Test
    void update() {
        JDBCDetectiveDAO detective = new JDBCDetectiveDAO();
        Detective dec = new Detective();
        dec.setModifiedAt(LocalDateTime.now());
        dec.setVersion(4);
        dec.setArmed(false);
        dec.setBadgeNumber("badgeNumber");
        dec.setId(1L);
        detective.update(dec);
        System.out.println("OK");
    }

    @Test
    void deleteById() {
        JDBCDetectiveDAO detective = new JDBCDetectiveDAO();
        detective.deleteById(8L);
    }
}