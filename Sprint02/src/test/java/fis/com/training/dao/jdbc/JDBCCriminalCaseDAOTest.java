package fis.com.training.dao.jdbc;

import fis.com.training.core.object.CriminalCase;
import fis.com.training.dao.ICriminalDAO;
import fis.com.training.dao.jdbc.JDBCCriminalCaseDAO;
import org.junit.jupiter.api.Test;

import java.util.List;

class JDBCCriminalCaseDAOTest {

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

    }

    @Test
    void delete() {

    }
}