package fis.com.training.dao.mem;

import fis.com.training.core.enums.EmploymentStatus;
import fis.com.training.core.enums.Rank;
import fis.com.training.core.object.Detective;
import fis.com.training.dao.IDetectiveDAO;
import fis.com.training.dao.PersonDAO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DetectiveDAOMemImplTest {

    @Test
    void save() {
        IDetectiveDAO d = new DetectiveDAOMemImpl();
        PersonDAO p = new PersonDAOJdbcImp();
        Detective det = new Detective(3L, 002, p.getPersonById(1L), "ttTtt", Rank.CHIEF_INSPECTOR, true, EmploymentStatus.UNDER_INVESTIGATION);

        d.save(det);
        long lo = det.getId();

        assertEquals(3L,lo);
    }

    @Test
    void get() {
        IDetectiveDAO d = new DetectiveDAOMemImpl();

        List<Detective> de = d.getAll();

        assertEquals(3,de.size());
    }

    @Test
    void getAll() {
    }

    @Test
    void update() {
        IDetectiveDAO d = new DetectiveDAOMemImpl();
        PersonDAO p = new PersonDAOJdbcImp();
        Detective det = new Detective(3L, 002, p.getPersonById(1L), "tArtt", Rank.INSPECTOR, false, EmploymentStatus.SUSPENDED);

        d.update(det);
        int verson = det.getVersion();

        assertEquals(002, verson);
    }

    @Test
    void delete() {
        IDetectiveDAO d = new DetectiveDAOMemImpl();

        d.delete(1l);

        assertNotEquals(5L,d.getAll().size());
    }
}