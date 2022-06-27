package fis.com.training.dao.jdbc;

import fis.com.training.core.object.CriminalCase;
import fis.com.training.core.object.Evidence;
import fis.com.training.core.object.Storage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
class JDBCEvidenceDAOTest {
    JDBCEvidenceDAO jdbcEvidence = new JDBCEvidenceDAO();
    @Test
    void save() {
        Evidence evidence = new Evidence();
        evidence.setVersion(1);
        evidence.setItemName("bongnq");
        evidence.setNotes("132a");
        evidence.setNumber("12346");
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setId(3L);
        evidence.setCriminalCase(criminalCase);
        Storage storage = new Storage();
        storage.setId(1L);
        evidence.setStorage(storage);
        jdbcEvidence.save(evidence);
        System.out.println("Done");
    }

    @Test
    void get() {
        System.out.println(jdbcEvidence.getEvidenceById(1L));
    }

    @Test
    void getAll() {
        System.out.println(jdbcEvidence.getAll());
    }

    @Test
    void update() {
        Evidence evidence = new Evidence();
        evidence.setVersion(1);
        evidence.setItemName("Update");
        evidence.setNotes("Note Update");
        evidence.setNumber("12391919");
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setId(3L);
        evidence.setCriminalCase(criminalCase);
        Storage storage = new Storage();
        storage.setId(1L);
        evidence.setStorage(storage);
        evidence.setId(1L);
        jdbcEvidence.update(evidence);
        System.out.println("Done");
    }

    @Test
    void delete(Long id) {
        jdbcEvidence.deleteById(1L);
    }
}