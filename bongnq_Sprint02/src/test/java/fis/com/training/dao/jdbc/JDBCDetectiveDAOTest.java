package fis.com.training.dao.jdbc;

import fis.com.training.core.object.CriminalCase;
import fis.com.training.core.object.Detective;
import fis.com.training.dao.ICriminalDAO;
import fis.com.training.dao.IDetectiveDAO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JDBCDetectiveDAOTest {

    @Test
    void save() {
    }

    @Test
    void get() {
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
    }

    @Test
    void delete() {
    }
}