package fis.com.training.dao.mem;


import fis.com.training.core.object.CriminalCase;
import fis.com.training.core.object.Person;
import fis.com.training.dao.ICriminalDAO;
import fis.com.training.dao.jdbc.JDBCCriminalCaseDAO;
import fis.com.training.dao.util.DatabaseUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class CriminalDAOMemImpl implements ICriminalDAO {
    private final static Logger logger = LoggerFactory.getLogger(JDBCCriminalCaseDAO.class);

    @Override
    public boolean delete(long id) {
        for(CriminalCase criminalCase : MemoryDataSource.CRIMINAL_CASES) {
            if (criminalCase.getId() == id){
                MemoryDataSource.CRIMINAL_CASES.remove(criminalCase);
                return false;
            }
        }
        return false;
    }

    @Override
    public CriminalCase getCriminalById(long criminalId) {
        return null;
    }

    @Override
    public void save(CriminalCase criminalCase) {
        if(
        !MemoryDataSource.CRIMINAL_CASES.stream().filter(item -> item.getId()==criminalCase.getId()).findFirst().isPresent()
        )
        MemoryDataSource.CRIMINAL_CASES.add(criminalCase);
    }

    @Override
    public Optional<CriminalCase> get(long id) {
        return MemoryDataSource.CRIMINAL_CASES.stream()
                .filter(criminalCase -> criminalCase.getId()==id)
                .findFirst();
    }

    @Override
    public List<CriminalCase> getAll() {
        return null;
    }

    @Override
    public Person update(CriminalCase newCriminalCase) {
        String sql = "UPDATE `Criminal` SET " +
                "`version` = ?, " +
                "`number` = ?, " +
                "`type` = ?, " +
                "`shortDescription` = ?, " +
                "`detailedDescription` = ?, " +
                "`status` = ?, " +
                "`note` = ?, " +
                "`leadDetective` = ? " +
                "WHERE `id` = ? ";
        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);) {

            stmt.setInt(1, newCriminalCase.getVersion());
            stmt.setString(2, newCriminalCase.getNumber());
            stmt.setString(3, newCriminalCase.getType().name());
            stmt.setString(4, newCriminalCase.getShortDescription());
            stmt.setString(5, newCriminalCase.getDetailedDescription());
            stmt.setString(6, newCriminalCase.getStatus().name());
            stmt.setString(7, newCriminalCase.getNotes());
            stmt.setLong(8, newCriminalCase.getLeadInvestigator().getId());
            stmt.setLong(9, newCriminalCase.getId());
            int update = stmt.executeUpdate();
            if (update == 0) {
                logger.error("Update failed");
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return newCriminalCase;
    }

    @Override
    public void delete(CriminalCase criminalCase) {
        MemoryDataSource.CRIMINAL_CASES.remove(criminalCase);
    }
}
