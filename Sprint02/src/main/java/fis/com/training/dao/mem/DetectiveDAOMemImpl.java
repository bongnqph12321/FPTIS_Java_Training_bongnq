package fis.com.training.dao.mem;

import fis.com.training.core.object.Detective;
import fis.com.training.core.object.Person;
import fis.com.training.dao.IDetectiveDAO;
import fis.com.training.dao.jdbc.JDBCDetectiveDAO;
import fis.com.training.dao.util.DatabaseUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class DetectiveDAOMemImpl implements IDetectiveDAO {
    private final static Logger logger = LoggerFactory.getLogger(JDBCDetectiveDAO.class);

    @Override
    public void save(Detective detective) {
        String sql = "INSERT INTO detective(`id`, `version`, `personId`, `badgeNumber`, `rank`, `armed`, `status`) " +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);) {

            stmt.setLong(1, detective.getId());
            stmt.setInt(2, detective.getVersion());
            stmt.setLong(3, detective.getPerson().getId());
            stmt.setString(4, detective.getBadgeNumber());
            stmt.setString(5, detective.getRank().toString());
            stmt.setBoolean(6, detective.isArmed());
            stmt.setString(7, detective.getStatus().toString());
            stmt.executeUpdate();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public Optional<Detective> get(long id) {
        return MemoryDataSource.DETECTIVES.stream()
                .filter(criminalCase -> criminalCase.getId()==id)
                .findFirst();
    }

    @Override
    public List<Detective> getAll() {
        return null;
    }

    @Override
    public Person update(Detective detective) {
        String sql = "UPDATE `detective` SET " +
                "`version` = ?, " +
                "`personId` = ?, " +
                "`badgeNumber` = ?, " +
                "`rank` = ?, " +
                "`armed` = ?, " +
                "`status` = ? " +
                "WHERE `id` = ? ";
        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
        ) {
            stmt.setInt(1, detective.getVersion());
            stmt.setLong(2, detective.getPerson().getId());
            stmt.setString(3, detective.getBadgeNumber());
            stmt.setString(4, detective.getRank().name());
            stmt.setBoolean(5, detective.isArmed());
            stmt.setString(6, detective.getStatus().name());
            stmt.setLong(7, detective.getId());
            int update = stmt.executeUpdate();
            if (update == 0) {
                logger.error("Update failed");
                return null;
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
        return detective;
    }

    @Override
    public void delete(Detective detective) {
        String sql = "DELETE FROM `detective` WHERE `id` = ?";
        try(Connection con = DatabaseUtility.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setLong(1, detective.getId());
            int delete = stmt.executeUpdate();
            if (delete == 0) {
                logger.error("Delete Failed");
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());

        }
    }


    @Override
    public Detective getDetectiveById(long leadDetective) {
        return null;
    }
}
