package fis.com.training.dao.mem;

import fis.com.training.core.object.Storage;
import fis.com.training.dao.IStorgeDAO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StorageDAOMemImplTest {

    @Test
    void save() {
        IStorgeDAO s = new StorageDAOMemImpl();
        Storage st = new Storage(3l, 004, "Bm", "FHN");

        s.save(st);
        long id = st.getId();

        assertEquals(3L, id);
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
        IStorgeDAO s = new StorageDAOMemImpl();

        List<Storage> list = s.getAll();

        assertEquals(3,list.size());
    }

    @Test
    void update() {
        IStorgeDAO s = new StorageDAOMemImpl();
        Storage st = new Storage(2l, 0041, "Am", "VAVN");

        s.update(st);
        long verion = st.getVersion();

        assertEquals(0041,verion);
    }

    @Test
    void delete() {
        IStorgeDAO s = new StorageDAOMemImpl();

        s.delete(5l);

        assertNotEquals(5L, s.getStorageById(5L));
    }
}