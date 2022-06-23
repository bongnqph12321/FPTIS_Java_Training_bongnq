package fis.com.training.dao.mem;


import fis.com.training.core.object.Evidence;
import fis.com.training.core.object.Person;
import fis.com.training.dao.IEvidenceDAO;
import fis.com.training.dao.util.DBMapper;
import fis.com.training.dao.util.DatabaseUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EvidenceDAOMemImpl implements IEvidenceDAO {
    Logger logger = LoggerFactory.getLogger(EvidenceDAOMemImpl.class);

    @Override
    public void save(Evidence evidence) {
        String sql = "INSERT INTO `evidence` (`id`, `version`, `criminalId`, `storageId`, `number`, `itemName`, `note`, `archired`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection con = DatabaseUtility.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
        ) {
            stmt.setLong(1, evidence.getId());
            stmt.setInt(2, evidence.getVersion());
            stmt.setLong(3, evidence.getCriminalCase().getId());
            stmt.setLong(4, evidence.getStorage().getId());
            stmt.setString(5, evidence.getNumber());
            stmt.setString(6, evidence.getItemName());
            stmt.setString(7, evidence.getNotes());
            stmt.setBoolean(8, evidence.isArchired());
            int insert = stmt.executeUpdate();
            if (insert == 0) {logger.error("Insert failed");}
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    @Override
    public Optional<Evidence> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Evidence> getAll() {
        List<Evidence> evidenceList = new ArrayList<>();
        String sql = "SELECT * FROM evidence";
        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery ();) {
            while (rs.next()) {
                Evidence evidence = DBMapper.getEvidence(rs);
                if(evidence != null) evidenceList.add(evidence);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return evidenceList;
    }

    @Override
    public Person update(Evidence evidence) {

        String sql = "UPDATE `evidence` SET " +
                "`version` = ?, " +
                "`criminalId` = ?, " +
                "`storageId` = ?, " +
                "`number` = ?, " +
                "`itemName` = ?, " +
                "`note` = ?, " +
                "`archired` = ? " +
                "WHERE `id` = ?";
        try(Connection con = DatabaseUtility.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setInt(1, evidence.getVersion());
            stmt.setLong(2, evidence.getCriminalCase().getId());
            stmt.setLong(3, evidence.getStorage().getId());
            stmt.setString(4, evidence.getNumber());
            stmt.setString(5, evidence.getItemName());
            stmt.setString(6, evidence.getNotes());
            stmt.setBoolean(7, evidence.isArchired());
            stmt.setLong(8, evidence.getId());
            int update = stmt.executeUpdate();
            if(update == 0){
                logger.error("Update Failed");
                return null;
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
        return evidence;
    }

    @Override
    public void delete(Evidence evidence) {
        String sql = "DELETE FROM `evidence` WHERE `id` = ?";
        try(Connection con = DatabaseUtility.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);){
            stmt.setLong(1, evidence.getId());
            int delete = stmt.executeUpdate();
            if (delete == 0){
                logger.error("Delete Failed");
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());

        }
    }


    @Override
    public Evidence getEvidenceById(long evidenceId) {
        Evidence e;
        String sql = "SELECT * FROM evidence WHERE id = ?";
        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);){
            stmt.setLong(1, evidenceId);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                e = DBMapper.getEvidence(rs);
                return e;
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
        return null;
    }
}
