package fis.com.training.dao.mem;

import fis.com.training.core.object.Evidence;
import fis.com.training.dao.ICriminalDAO;
import fis.com.training.dao.IEvidenceDAO;
import fis.com.training.dao.IStorgeDAO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EvidenceDAOMemImplTest {

    @Test
    void save() {
        IEvidenceDAO e = new EvidenceDAOMemImpl();
        ICriminalDAO cri = new CriminalDAOMemImpl();
        IStorgeDAO st = new StorageDAOMemImpl();
        Evidence evi = new Evidence(3L,003,cri.getCriminalById(1L),st.getStorageById(1L),"333","item3","note3",false);
        e.save(evi);
    }

    @Test
    void get() {
        IEvidenceDAO e = new EvidenceDAOMemImpl();

        List<Evidence> list = e.getAll();
        //System.out.println(evi.getAll());
        assertEquals(3,list.size());
    }

    @Test
    void getAll() {
    }

    @Test
    void update() {
        IEvidenceDAO e = new EvidenceDAOMemImpl();
        ICriminalDAO cri = new CriminalDAOMemImpl();
        IStorgeDAO st = new StorageDAOMemImpl();
        Evidence evi = new Evidence(3L,020,cri.getCriminalById(2L),st.getStorageById(2L),"222L","item2","note2",false);

        e.update(evi);
        int version = evi.getVersion();

        assertEquals(020,version);
    }

    @Test
    void delete() {
        IEvidenceDAO e = new EvidenceDAOMemImpl();

        e.deleteById(1L);

        assertNotEquals(1,e.getEvidenceById(1L));
    }
}