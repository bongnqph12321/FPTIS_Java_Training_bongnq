package fis.com.training.dao.jdbc;

import fis.com.training.core.enums.CaseStatus;
import fis.com.training.core.enums.CaseType;
import fis.com.training.core.object.CriminalCase;
import fis.com.training.core.object.Detective;
import fis.com.training.dao.ICriminalDAO;
import fis.com.training.dao.jdbc.JDBCCriminalCaseDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
class JDBCCriminalCaseDAOTest {
    JDBCCriminalCaseDAO jdbcCriminal_case = new JDBCCriminalCaseDAO();
    @Test
    void getAll() {
        //A1
        ICriminalDAO criminalCaseDAO = new JDBCCriminalCaseDAO();

        //A2
        List<CriminalCase> criminalCaseList = criminalCaseDAO.getAll();

        //A3: Assert
        System.out.println(criminalCaseList);
    }

    @Test
    void update() {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setVersion(3);
        criminalCase.setDetailedDescription("ok");
        criminalCase.setNotes("Note 121231");
        criminalCase.setNumber("018312831");
        criminalCase.setShortDescription("shoert");
        criminalCase.setStatus(CaseStatus.valueOf("DISMISSED"));
        criminalCase.setType(CaseType.valueOf("MISDEMEANOR"));
        Detective detective  = new Detective();
        detective.setId(1L);
        criminalCase.setLeadInvestigator(detective);
        criminalCase.setId(2L);
        jdbcCriminal_case.update(criminalCase);
        System.out.println("Done");
    }

    @Test
    void delete() {
        jdbcCriminal_case.delete(2L);
    }
}