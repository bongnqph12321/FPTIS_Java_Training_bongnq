package fis.com.training.dao.mem;


import fis.com.training.core.object.CriminalCase;
import fis.com.training.dao.ICriminalDAO;
import fis.com.training.dao.mem.CriminalDAOMemImpl;
import fis.com.training.dao.mem.MemoryDataSource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@Slf4j
class CriminalDAOMemImplTest {
    //public static Logger LOG = LoggerFactory.getLogger(CriminalCase.class);
    public static Logger LOG = LoggerFactory.getLogger(CriminalDAOMemImpl.class);

    @BeforeEach
    public void initTest(){
        LOG.info("initTest");
    }
    @BeforeEach
    public void initDataEachTest(){
        LOG.info("initDataEachTest");
        MemoryDataSource.CRIMINAL_CASES.clear();
        CriminalCase criminalCase1  = new CriminalCase();
        criminalCase1.setId(1);
        CriminalCase criminalCase2  = new CriminalCase();
        criminalCase2.setId(2);
        CriminalCase criminalCase3  = new CriminalCase();
        criminalCase3.setId(3);

        MemoryDataSource.CRIMINAL_CASES.add(criminalCase1);
        MemoryDataSource.CRIMINAL_CASES.add(criminalCase2);
        MemoryDataSource.CRIMINAL_CASES.add(criminalCase3);
    }

    @Test
    void save_CriminalCaseNotExits() {
        //A1: Arrange
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setId(4);
        criminalCase.setNumber("0001");
        // init data
        // ...
        //A2: Action
        int before = MemoryDataSource.CRIMINAL_CASES.size();
        ICriminalDAO iCriminalCaseDAO = new CriminalDAOMemImpl() {
        };
        iCriminalCaseDAO.save(criminalCase);
        //A3: Assert
        assertEquals(4, MemoryDataSource.CRIMINAL_CASES.size());


    }

    @Test
    void save_CriminalCaseExits() {
        CriminalCase criminalCase = new CriminalCase();

        //A1
        criminalCase = new CriminalCase();
        criminalCase.setId(1);
        criminalCase.setNumber("0001");

        //A2
        ICriminalDAO iCriminalCaseDAO = new CriminalDAOMemImpl();
        iCriminalCaseDAO.save(criminalCase);

        //A3
        assertEquals(4,MemoryDataSource.CRIMINAL_CASES.size());
    }
    @Test
    void get() {
        LOG.info("test get");
    }

    @Test
    void getAll() {
        LOG.info("test getAll");
    }

    @Test
    void update() {
        LOG.info("test update");
        CriminalCase criminalCase1 = new CriminalCase();
        criminalCase1.setId(1);
        CriminalDAOMemImpl criminalDAOMem = new CriminalDAOMemImpl();
        criminalDAOMem.update(criminalCase1);
    }

    @Test
    void delete() {
        CriminalDAOMemImpl criminalDAOMem = new CriminalDAOMemImpl();
        boolean result = criminalDAOMem.delete(1);

        assertEquals(true,result);
    }

    @AfterEach
    public void clearDataEachTest() {
        LOG.info("clearDataEachTest");
    }

    @AfterAll
    public static void clearTest(){
        LOG.info("clearTest");
    }
}